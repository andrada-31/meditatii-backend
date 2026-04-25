package com.meditatii.management.backend.appointments.controllers;

import com.meditatii.management.backend.appointments.dto.CreateAppointmentDto;
import com.meditatii.management.backend.appointments.entities.AppointmentEntity;
import com.meditatii.management.backend.appointments.services.AppointmentService;
import com.meditatii.management.backend.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@RequestMapping("api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<AppointmentEntity> getAppointments() {
        return service.getAllAppointments();
    }

    @PostMapping
    public AppointmentEntity createAppointment(@RequestBody CreateAppointmentDto dto){
        return service.createAppointment(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id) {
        service.deleteAppointment(id);
    }
}
