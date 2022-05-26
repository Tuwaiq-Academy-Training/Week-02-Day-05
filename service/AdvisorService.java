package com.example.schoolmanagment.service;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Student;
import com.example.schoolmanagment.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class AdvisorService {
   private ArrayList<Advisor> advisors = new ArrayList<>();

   public ArrayList<Advisor> getAdvisor(){
       return advisors;
   }
    public boolean addAdvisor(Advisor advisor) {
       return advisors.add(advisor);
    }

    public boolean editAdvisor(Integer index,Advisor advisor) {
       advisors.set(index,advisor);
       return true;
    }

    public boolean removeAdvisor(String id) {
       Integer currentAdvisor = getAdvisor(id);
       advisors.remove((int)currentAdvisor);
       return true;
    }
    public Integer getAdvisor(String id){
        for (int i = 0; i < advisors.size(); i++) {
           if (advisors.get(i).getId().equals(id)){
               return i;
           }
        }
        return null;
    }
    public ArrayList<Advisor> getAdvisorStudent(Integer index, Advisor advisor) {
        ArrayList <Advisor>advisorNames = new ArrayList<>();
        for (Advisor advisor1:advisorNames) {
            if (advisor1.getId().equals(advisor)){
                advisorNames.add(index,advisor);
            }
        }
        return advisorNames;
    }
}
