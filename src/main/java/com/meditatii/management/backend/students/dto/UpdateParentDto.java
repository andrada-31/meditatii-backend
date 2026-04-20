package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.students.entities.ParentEntity;
import lombok.Data;

@Data
public class UpdateParentDto {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public ParentEntity updateParentEntity(ParentEntity parent){
        if(this.getName() != null)
            parent.setName(this.getName());

        ContactInfo contactInfo = parent.getContactInfo();

        if(contactInfo == null)
            contactInfo = new ContactInfo();

        if(this.getAddress() != null)
            contactInfo.setAddress(this.getAddress());

        if(this.getEmail() != null)
            contactInfo.setEmail(this.getEmail());

        if(this.getPhoneNumber() != null)
            contactInfo.setPhoneNumber(this.getPhoneNumber());

        parent.setContactInfo(contactInfo);

        return parent;
    }
}
