package com.example.schoolmanagement.service;

import com.example.schoolmanagement.models.Classes;
import com.example.schoolmanagement.models.Advisor;
import com.example.schoolmanagement.models.Student;
import lombok.RequiredArgsConstructor;
//import org.springframework.aop.Advisor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class AdvisorService {
    private final StudentService studentService;
    private final ClassService classService;


    private ArrayList<Advisor> advisors = new ArrayList<Advisor>();

    public ArrayList<Advisor> getAdvisor() {
        return advisors;
    }

    public void addAdvisor(Advisor advisor){
        advisors.add(advisor);
    }

    public Boolean updateAdvisor(Advisor advisor, Integer index){
        if(index > advisors.size()-1){
            return false;
        }
        advisors.set(index, advisor);
        return true;
    }
    public Boolean deleteAdvisor(Integer index){
        if(index > advisors.size()-1){
            return false;
        }
        advisors.remove(index);
        return true;
    }


    public Integer addClass(String classId, String AdvId) {
        Advisor a = findAdvisor(AdvId);
        Classes c = findClass(classId);
        if(a != null){
            if(c != null){
                a.addClass(c);
                return 0; //Class has been added
            }
            return -1; //Class not found
        }
        return 1; //Student not found
    }



    public ArrayList findStudent(String advId){
        ArrayList<Student> students = new ArrayList<>();
        for(Student student : studentService.getStudents()){
            if(student.getAdvisorName().equals(findAdvisor(advId).getName())){
                students.add(student);
            }
        }
        return students;
    }

    private Advisor findAdvisor(String advId) {
        for(Advisor adv : advisors){
            if(adv.getId().equals(advId)){
                return adv;
            }
        }
        return null;
    }

    public Classes findClass(String classId){
        for(Classes c: classService.getClasses()){
            if(c.getId().equals(classId)){
                return c;
            }
        }
        return null;
    }
}

