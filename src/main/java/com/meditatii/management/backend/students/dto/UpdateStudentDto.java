package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.students.entities.GradeLevel;
import com.meditatii.management.backend.students.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateStudentDto {
    private String id;
    private String name;
    private Date dateOfBirth;
    private String school;
    private GradeLevel gradeLevel;
    private Double hourlyRate;
    private String address;
    private String phoneNumber;
    private String email;

    public StudentEntity updateStudentEntity(StudentEntity student){
        if(this.getDateOfBirth() != null)
            student.setDateOfBirth(this.getDateOfBirth());

        if(this.getName() != null)
            student.setName(this.getName());

        if(this.getSchool() != null)
            student.setSchool(this.getSchool());

        if(this.getGradeLevel() != null)
            student.setGradeLevel(this.getGradeLevel());

        if(this.getHourlyRate() != null)
            student.setHourlyRate(this.getHourlyRate());

        ContactInfo contactInfo = student.getContactInfo();

        if(contactInfo == null)
            contactInfo = new ContactInfo();

        if(this.getAddress() != null)
            contactInfo.setAddress(this.getAddress());

        if(this.getEmail() != null)
            contactInfo.setEmail(this.getEmail());

        if(this.getPhoneNumber() != null)
            contactInfo.setPhoneNumber(this.getPhoneNumber());

        student.setContactInfo(contactInfo);  // make sense just in the case contact info does not exist and we create a new one
                                              // otherwise, we just set the same reference (we worked with addresses)
        return student;
    }
}
