package com.meditatii.management.backend.students.repositories;

import com.meditatii.management.backend.students.entities.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository    // it generates CRUD operations for GradeEntity
public interface GradeRepository extends JpaRepository<GradeEntity, String> {
}
