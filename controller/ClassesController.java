package com.example.schoolmanagment.controller;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Classes;
import com.example.schoolmanagment.service.AdvisorService;
import com.example.schoolmanagment.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/classes")
@RequiredArgsConstructor
public class ClassesController {
    private final ClassesService classesService;

    @GetMapping
    public ResponseEntity<ArrayList<Classes>> getClasses(){
        return ResponseEntity.status(200).body(classesService.getClasses());
    }
    @PostMapping
    public ResponseEntity<Api> addClass(@RequestBody @Valid Classes lab, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isAddClass = classesService.addClass(lab);
        if (!isAddClass){
            return ResponseEntity.status(400).body(new Api("Error in add Classes :(",400));
        }
        return ResponseEntity.status(200).body(new Api("Classes adding :)",200));
    }
    @PutMapping("/{index}")
    public ResponseEntity<Api> editClass(@RequestBody @Valid Classes lab, @PathVariable Integer index, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean iseditClass = classesService.editClass(index,lab);
        if (!iseditClass){
            return ResponseEntity.status(400).body(new Api("Error in edit Classes :(",400));
        }
        return ResponseEntity.status(200).body(new Api("Classes editing :)",200));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Api> removeClass(String id){
        return ResponseEntity.status(200).body(new Api("Classes deleted! :)",200));
    }



}
