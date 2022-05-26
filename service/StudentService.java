package com.example.schoolmanagment.service;

import com.example.schoolmanagment.model.Classes;
import com.example.schoolmanagment.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class StudentService {
   private ArrayList<Student> students = new ArrayList<>();
   private final ClassesService classesService;

   public ArrayList<Student> getStudent(){
       return students;
   }
    public boolean addStudent(Student student) {
       return students.add(student);
    }
    public boolean editStudent(Integer index, Student student) {
       students.set(index,student);
       return true;
    }
    public boolean removeStudent(String id){
       Integer currentStudent=getStudent(id);
       students.remove((int)currentStudent);
       return true;
    }
        public Integer getStudent(String id){
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(id)){
                    return i;
                }
            }
            return null;
        }

        public ArrayList<Student> getClassList(String idStudent,Classes idClasses){
        ArrayList<Student>  classList = new ArrayList<>();
            for (Student student: classList) {
                if(student.getClassList().equals(idStudent)){
                    student.getId();
                }
                if (student.getClassList().equals(idClasses)){
                    student.getId();
                }
            }
            return null;
        }

    public ArrayList<Student> getStudentClassList(Student id) {
       ArrayList <Student>studentList = new ArrayList<>();
        ArrayList <Classes>classes = new ArrayList<>();
        for (Student student:students) {
            if (student.getClassList().equals(id)){
                studentList.add(id);
            }
        }
        return studentList;
    }
    public boolean changemajor(Integer id, Student student) {
        student.setMajor(student.getMajor());
        students.set(id,student);
        return true;
    }

    public ArrayList<Student> getStudentList(Integer index, Student student) {
        return students;
    }
}
