package com.meditatii.management.backend.students.entities;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)   // relation one to one to the contactInfo class and
                                            // we connect the two object by cascading all operations
                                            // (if we delete student, the contact info will be deleted too)
    ContactInfo contactInfo;

    @OneToMany(fetch = FetchType.EAGER)  // ne trage si lista de note dim baza de date
    @JoinColumn(name = "student_id")
    List<GradeEntity> grades;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    ParentEntity parent;
}
