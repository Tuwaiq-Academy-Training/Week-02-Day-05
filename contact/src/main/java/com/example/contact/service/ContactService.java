package com.example.contact.service;

import com.example.contact.exceptions.ApiException;
import com.example.contact.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContactService {

    private ArrayList <Contact>contactArrayList=new ArrayList();

    public ArrayList<Contact> getContact(){
        return contactArrayList;
    }

    public void addContact(Contact contact){
        contactArrayList.add(contact);
    }

    public Contact getContactByName(String name){
        for (int i = 0; i < contactArrayList.size(); i++) {
            if(contactArrayList.get(i).getName().equals(name)){
                return  contactArrayList.get(i);
            }

        }


       throw new ApiException("There is not contact with this name !");
    }

    public Contact getContactByNumber(String number){
        for (int i = 0; i < contactArrayList.size(); i++) {
            if(contactArrayList.get(i).getPhoneNumber().equals(number)){
                return  contactArrayList.get(i);
            }
        }
        throw new ApiException("There is not contact with this number !");
    }


}
