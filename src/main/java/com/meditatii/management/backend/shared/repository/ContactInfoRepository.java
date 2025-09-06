package com.meditatii.management.backend.shared.repository;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, String> {
}
