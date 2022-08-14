package com.example.contact.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Contact {

    @NotNull(message = "Id can't be null")

    private int id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @NotEmpty(message = "Phone number can't be empty")
    @Size(min = 10,max = 11,message = "Please enter valid phone number")
    private String phoneNumber;
}
