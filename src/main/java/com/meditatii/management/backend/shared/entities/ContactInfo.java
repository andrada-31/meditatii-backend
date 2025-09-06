package com.meditatii.management.backend.shared.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data    // generate getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contactInfo")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // generator of id
    String id;

    @Column   // by default the columns are nullable
    String phoneNumber;

    @Column
    String email;

    @Column
    String address;

}
