package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.shared.repository.ContactInfoRepository;
import com.meditatii.management.backend.students.entities.GradeLevel;
import com.meditatii.management.backend.students.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreateStudentDto {
    private String name;
    private Date dateOfBirth;
    private String school;
    private GradeLevel gradeLevel;
    private Double hourlyRate;
    private String phoneNumber;
    private String address;
    private String email;

    public ContactInfo getContactInfoEntity(){
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress(address);
        contactInfo.setEmail(email);
        contactInfo.setPhoneNumber(phoneNumber);
        return contactInfo;
    }

    public StudentEntity getStudentEntity(ContactInfo contactInfo){
        StudentEntity entity = new StudentEntity();
        entity.setName(name);
        entity.setSchool(school);
        entity.setGradeLevel(gradeLevel);
        entity.setHourlyRate(hourlyRate);
        entity.setDateOfBirth(dateOfBirth);
        entity.setContactInfo(contactInfo);
        return entity;
    }
}

