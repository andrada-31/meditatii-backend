package com.meditatii.management.backend.students.repositories;

import com.meditatii.management.backend.students.entities.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, String> {

}
