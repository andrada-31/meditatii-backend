package com.meditatii.management.backend.students.controllers;

import com.meditatii.management.backend.students.dto.CreateParentDto;
import com.meditatii.management.backend.students.dto.UpdateParentDto;
import com.meditatii.management.backend.students.dto.UpdateStudentDto;
import com.meditatii.management.backend.students.entities.ParentEntity;
import com.meditatii.management.backend.students.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    public ParentEntity createParent(@RequestBody CreateParentDto dto){
        ParentEntity createdParent = parentService.createParent(dto);
        return createdParent;
    }

    @PatchMapping
    public ResponseEntity<ParentEntity> updateParent(@RequestBody UpdateParentDto dto){
        try {
            ParentEntity updatedParent = parentService.updateParent(dto);
            return ResponseEntity.ok(updatedParent);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
