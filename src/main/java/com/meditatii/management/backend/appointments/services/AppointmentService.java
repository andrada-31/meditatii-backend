package com.meditatii.management.backend.appointments.services;

import com.meditatii.management.backend.appointments.dto.CreateAppointmentDto;
import com.meditatii.management.backend.appointments.dto.UpdateAppointmentDto;
import com.meditatii.management.backend.appointments.entities.AppointmentEntity;
import com.meditatii.management.backend.appointments.repositories.AppointmentRepository;
import com.meditatii.management.backend.students.entities.StudentEntity;
import com.meditatii.management.backend.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, StudentRepository studentRepository){
        this.appointmentRepository = appointmentRepository;
        this.studentRepository = studentRepository;
    }

    public List<AppointmentEntity> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public AppointmentEntity createAppointment(CreateAppointmentDto dto){
        Set<String> studentsIds = dto.getStudentIds();
        List<StudentEntity> students = studentRepository.findAllById(studentsIds);
        AppointmentEntity appointment = dto.getAppointmentEntity(students);
        return appointmentRepository.save(appointment);
    }

    public AppointmentEntity updateAppointment(UpdateAppointmentDto dto){
        Optional<AppointmentEntity> result = appointmentRepository.findById(dto.getId());
        AppointmentEntity appointment = result.orElseThrow(); // return 404 if the appointment does not exist
        List<String> studentIds = dto.getStudentsIds();
        for(String id : studentIds){
            boolean studentExists = appointment.getStudents().stream().anyMatch(s -> Objects.equals(s.getId(), id));
            if(studentExists){
                continue;
            }else{
                // when we have to add a student in the list of appointment
                Optional<StudentEntity> studentResult = studentRepository.findById(id);
                StudentEntity student = studentResult.orElseThrow();
                List<StudentEntity> studentsAppointmentList = appointment.getStudents();
                studentsAppointmentList.add(student);
                appointment.setStudents(studentsAppointmentList);
            }
        }
        // when we have to delete student from the list
        List<String> studentsIdsToBeDeleted = new LinkedList<>();
        List<StudentEntity> studentsAppointment = appointment.getStudents();
        for(StudentEntity currentStudent : studentsAppointment){
            if(dto.getStudentsIds().stream().noneMatch(s -> Objects.equals(currentStudent.getId(), s))){
                studentsIdsToBeDeleted.add(currentStudent.getId());
            }
        }

        List<StudentEntity> studentsAppointmentList = appointment.getStudents();
        for(String id : studentsIdsToBeDeleted){
            studentsAppointmentList.removeIf(s -> Objects.equals(s.getId(), id));
        }
        appointment.setStudents(studentsAppointmentList);
        AppointmentEntity updatedAppointment = dto.updateAppointmentEntity(appointment);
        return appointmentRepository.save(updatedAppointment);
    }

    public void deleteAppointment(String id){
        appointmentRepository.deleteById(id);
    }
}
