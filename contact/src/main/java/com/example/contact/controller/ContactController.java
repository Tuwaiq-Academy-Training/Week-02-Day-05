package com.example.contact.controller;

import com.example.contact.model.Api;
import com.example.contact.model.Contact;
import com.example.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService contactService;


    @GetMapping
    public ResponseEntity getContact(){
      return ResponseEntity.status(200).body(  contactService.getContact());
    }

    @PostMapping
    public ResponseEntity addContact(@RequestBody @Valid Contact contact){
        contactService.addContact(contact);
        return ResponseEntity.status(201).body(  new Api("New contact added ",201));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getContactByName(@PathVariable String name){
       Contact contact= contactService.getContactByName(name);
        return ResponseEntity.status(200).body(contact);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity getContactByNumber(@PathVariable String number){
        Contact contact=contactService.getContactByNumber(number);
        return ResponseEntity.status(200).body(contact);

    }

}
