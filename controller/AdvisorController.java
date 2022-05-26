package com.example.schoolmanagment.controller;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Student;
import com.example.schoolmanagment.model.Teacher;
import com.example.schoolmanagment.service.AdvisorService;
import com.example.schoolmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/advisor")
@RequiredArgsConstructor
public class AdvisorController {
    private final AdvisorService advisorService;

    @GetMapping
    public ResponseEntity<ArrayList<Advisor>> getAdvisor(){
        return ResponseEntity.status(200).body(advisorService.getAdvisor());
    }
    @PostMapping
    public ResponseEntity<Api> addAdvisor(@RequestBody @Valid Advisor advisor, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
       boolean isaddAdvisor = advisorService.addAdvisor(advisor);
        if (!isaddAdvisor){
            return ResponseEntity.status(400).body(new Api("Sorry your request is Not Valid :(",400));
        }
        return ResponseEntity.status(201).body(new Api("Advisor Added :)",201));
    }
    @PutMapping("{index}")
    public ResponseEntity<Api> editAdvisor(@RequestBody @Valid Advisor advisor,@PathVariable Integer index, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isEditAdvisor = advisorService.editAdvisor(index,advisor);
        if (!isEditAdvisor){
            return ResponseEntity.status(400).body(new Api("Sorry your request is Not Valid :(",400));
        }
        return ResponseEntity.status(201).body(new Api("Advisor Edited :)",201));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Api> removeAdvisor(@RequestParam String id){
        boolean isAdvisorDeleted = advisorService.removeAdvisor(id);
        if (!isAdvisorDeleted){
            return ResponseEntity.status(400).body(new Api("Error user is Invalid Deleted :(",400));
        }
        return ResponseEntity.status(200).body(new Api("DELETED!",200));
    }
    @GetMapping("student/advisor/{index}")
    public ArrayList<Advisor> getAdvisorStudent(@PathVariable Integer index, @RequestBody Advisor advisor){
        ArrayList<Advisor> AdvisorStudent=advisorService.getAdvisorStudent(index,advisor);
        return ResponseEntity.status(200).body(advisorService.getAdvisor(advisor));
    }

}
