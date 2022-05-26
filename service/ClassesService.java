package com.example.schoolmanagment.service;

import com.example.schoolmanagment.model.Advisor;
import com.example.schoolmanagment.model.Classes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassesService {
   private ArrayList<Classes> classes = new ArrayList<>();

   public ArrayList<Classes> getClasses(){
       return classes;
   }

    public boolean addClass(Classes lab) {
       classes.add(lab);
       return true;
    }

    public boolean editClass(Integer index,Classes lab) {
       classes.set(index,lab);
       return true;
    }

    public boolean removeClass(String id){
       Integer currentClasses = getClasses(id);
       classes.remove((int)currentClasses);
       return true;
    }
    public Integer getClasses(String id){
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getId().equals(id)){
                return i;
            }
        }
        return null;
    }
}
