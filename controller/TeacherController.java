package com.example.schoolmanagment.controller;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Student;
import com.example.schoolmanagment.model.Teacher;
import com.example.schoolmanagment.service.AdvisorService;
import com.example.schoolmanagment.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ArrayList<Teacher>> getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }
    @PostMapping
    public ResponseEntity<Api> addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isAddTeacher = teacherService.addTeacher(teacher);
        if (!isAddTeacher){
            return ResponseEntity.status(400).body(new Api("Soory about That :(",400));
        }
        return ResponseEntity.status(200).body(new Api("Added Teacher :)",200));
    }
    @PutMapping("{index}")
    public ResponseEntity<Api> editTeacher(@RequestBody @Valid Teacher teacher ,@PathVariable Integer index, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isEditTeacher = teacherService.editTeacher(index,teacher);
        if (!isEditTeacher){
            return ResponseEntity.status(400).body(new Api("Soory about That :(",400));
        }
        return ResponseEntity.status(200).body(new Api("Edit Teacher :)",200));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Api> removeTeacher(String id){
        boolean isTeacherDelete = teacherService.removeTeacher(id);
        if (!isTeacherDelete){
            return ResponseEntity.status(400).body(new Api("Soory about That :(",400));
        }
        return ResponseEntity.status(200).body(new Api("remove Teacher :)",200));
    }
    @GetMapping("/{Teachers}")
    public ResponseEntity<ArrayList<Teacher>> getTeachers(Teacher id){
        ArrayList<Teacher> teacherClassList=teacherService.getTeachers(id);
        return ResponseEntity.status(200).body(teacherService.getTeachers(id));
    }
    @GetMapping("/{Teachersname}")
    public ResponseEntity<ArrayList<Teacher>> getTeachersName(Teacher teacherName){
        ArrayList<Teacher> teacherNames=teacherService.getTeachersName(teacherName);
        return ResponseEntity.status(200).body(teacherService.getTeachersName(teacherName));
    }

}
