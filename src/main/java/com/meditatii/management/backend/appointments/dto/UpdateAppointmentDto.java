package com.meditatii.management.backend.appointments.dto;

import com.meditatii.management.backend.appointments.entities.AppointmentEntity;
import com.meditatii.management.backend.appointments.entities.SubjectType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UpdateAppointmentDto {
    private String id;
    private SubjectType subject;
    private Date dateTime;
    private Integer duration;
    private List<String> studentsIds;

    public AppointmentEntity updateAppointmentEntity(AppointmentEntity appointment){
        if(this.getSubject() != null)
            appointment.setSubject(this.getSubject());

        if(this.getDuration() != null)
            appointment.setDuration(this.getDuration());

        if(this.getDateTime() != null)
            appointment.setDateTime(this.getDateTime());

        return appointment;
    }
}
