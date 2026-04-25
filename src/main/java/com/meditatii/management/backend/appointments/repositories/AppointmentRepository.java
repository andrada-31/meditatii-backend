package com.meditatii.management.backend.appointments.repositories;

import com.meditatii.management.backend.appointments.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // generates CRUD operations for AppointmentEntity
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {

}
