package com.meditatii.management.backend.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data   // generate getters and setters
@AllArgsConstructor    // construct a constructor with arguments
@NoArgsConstructor     // construct a constructor without arguments
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // generator of id
    String id;

    @Column
    String name;
}
