package com.meditatii.management.backend.appointments.entities;

import com.meditatii.management.backend.students.entities.StudentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data     // generate getters and setters
@AllArgsConstructor    // construct a constructor with arguments
@NoArgsConstructor     // construct a constructor without arguments
@Table(name = "appointments")   // create a table with the fields of the class
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // generator of id
    String id;

    @Column
    @Enumerated(EnumType.STRING)
    SubjectType subject;

    @Column
    Double totalIncome;

    @Column
    Date dateTime;

    @Column
    int duration;

    @ManyToMany
    @JoinTable(name = "appointment_student",
    joinColumns = @JoinColumn(name = "appointment_id"),   // the dominant relation
    inverseJoinColumns = @JoinColumn(name = "student_id")   // the second relation
    )
    List<StudentEntity> students;
}
