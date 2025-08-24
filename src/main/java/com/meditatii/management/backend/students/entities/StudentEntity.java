package com.meditatii.management.backend.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data   // generate getters and setters
@AllArgsConstructor    // construct a constructor with arguments
@NoArgsConstructor     // construct a constructor without arguments
@Table(name = "students")  // create a table with the fields of the class
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // generator of id
    String id;

    @Column
    String name;

    @Column
    Date dateOfBirth;

    @Column
    String school;

    @Column
    @Enumerated(EnumType.STRING)
    GradeLevel gradeLevel;

    @Column
    Double hourlyRate;

}
