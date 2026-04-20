package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.students.entities.ParentEntity;
import lombok.Data;

@Data
public class CreateParentDto {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String studentId;

    public ContactInfo getContactInfoEntity(){
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress(address);
        contactInfo.setEmail(email);
        contactInfo.setPhoneNumber(phoneNumber);
        return contactInfo;
    }

    public ParentEntity getParentEntity(ContactInfo contactInfo){
        ParentEntity entity = new ParentEntity();
        entity.setName(name);
        entity.setContactInfo(contactInfo);
        return entity;
    }

}
