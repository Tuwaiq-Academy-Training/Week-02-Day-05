package com.example.schoolmanagment.controller;

import com.example.schoolmanagment.model.Classes;
import com.example.schoolmanagment.model.Student;
import com.example.schoolmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ArrayList<Student>> getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudent());
    }
    @PostMapping
    public ResponseEntity<Api> getStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
       boolean isStudentAdded = studentService.addStudent(student);
        if (!isStudentAdded){
            return ResponseEntity.status(400).body(new Api("Error user is Invalid Added :(",400));
        }
        return ResponseEntity.status(201).body(new Api("User is Added :)",201));
    }
    @PutMapping("/{index}")
    public ResponseEntity<Api> editStudent(@PathVariable Integer index,@RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
       boolean isStudentEdit =  studentService.editStudent(index,student);
        if (!isStudentEdit){
            return ResponseEntity.status(400).body(new Api("Error user is Invalid Edited :(",400));
        }
        return ResponseEntity.status(201).body(new Api("User is Edited :)",201));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Api> removeStudent(@RequestParam String id){
        boolean isStudentDeleted = studentService.removeStudent(id);
        if (!isStudentDeleted){
            return ResponseEntity.status(400).body(new Api("Error user is Invalid Deleted :(",400));
        }
        return ResponseEntity.status(200).body(new Api("DELETED!",200));
    }
    // Get student id and class id and add it to the classList
    @GetMapping("/{Students}")
    public ResponseEntity<ArrayList<Student>> getStudents(Student id){
        ArrayList<Student> studentClassList=studentService.getStudentClassList(id);
        return ResponseEntity.status(200).body(studentService.getStudentClassList(id));
    }
    @PutMapping("/changemajor/{index}")
    public ResponseEntity<Api> changemajor(@RequestParam Integer id, @RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isStudentEditMajor =  studentService.changemajor(id,student);
        if (!isStudentEditMajor){
            return ResponseEntity.status(400).body(new Api("Error user is Invalid Edited Major :(",400));
        }
        if (isStudentEditMajor){
            return ResponseEntity.status(200).body(new Api("drop all the classes",200));
        }
        return ResponseEntity.status(201).body(new Api("Major is Edited :)",201));
    }
    @GetMapping("/StudentsList/{index}")
    public ResponseEntity<ArrayList<Student>> getStudentsList(@PathVariable Integer index, Student student){
        ArrayList<Student> studentList=studentService.getStudentList(index,student);
        return ResponseEntity.status(200).body(studentService.getStudentList(index,student));
    }


}
