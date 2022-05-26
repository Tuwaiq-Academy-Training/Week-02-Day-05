package com.example.schoolmanagment.service;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Classes;
import com.example.schoolmanagment.model.Student;
import com.example.schoolmanagment.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public class TeacherService {
   private ArrayList<Teacher> teachers = new ArrayList<>();

   public ArrayList<Teacher> getTeacher(){
       return teachers;
   }

    public boolean addTeacher(Teacher teacher) {
       teachers.add(teacher);
       return true;
    }

    public boolean editTeacher(Integer index, Teacher teacher) {
       teachers.set(index,teacher);
       return true;
    }
    public boolean removeTeacher(@RequestParam String id){
       Integer currentTeacher = getTeacher(id);
       teachers.remove((int)currentTeacher);
       return true;
    }
    public Integer getTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public ArrayList<Teacher> getTeachers(Teacher id) {
        ArrayList <Teacher>teachersList = new ArrayList<>();
        for (Teacher teacher:teachers) {
            if (teacher.getClassList().equals(id)){
                teachersList.add(id);
            }
        }
        return teachersList;
    }
    public ArrayList<Teacher> getTeachersName(Teacher teacherName) {
        ArrayList <Teacher>teacherNames = new ArrayList<>();
        for (Teacher teacher:teacherNames) {
            if (teacher.getName().equals(teacherName)){
                teacherNames.add(teacherName);
            }
        }
        return teacherNames;
    }
}
