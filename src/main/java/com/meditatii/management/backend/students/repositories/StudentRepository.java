package com.meditatii.management.backend.students.repositories;

import com.meditatii.management.backend.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository   // it generates CRUD operations for StudentEntity
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
