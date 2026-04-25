package com.meditatii.management.backend.appointments.dto;

import com.meditatii.management.backend.appointments.entities.AppointmentEntity;
import com.meditatii.management.backend.appointments.entities.SubjectType;
import com.meditatii.management.backend.students.entities.StudentEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class CreateAppointmentDto {
    SubjectType subject;
    Date dateTime;
    int duration;
    Set<String> studentIds;  // set because we can't have the same student twice at an appointment

    public AppointmentEntity getAppointmentEntity(List<StudentEntity> studentEntities){
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDuration(duration);
        entity.setDateTime(dateTime);
        entity.setSubject(subject);
        entity.setStudents(studentEntities);
        Double totalIncome = studentEntities.stream().mapToDouble(s -> s.getHourlyRate() * duration / 60).sum();
        entity.setTotalIncome(totalIncome);
        return entity;
    }
}
