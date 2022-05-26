package com.example.schoolmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
@AllArgsConstructor @Data
public class Student {
    @NotEmpty(message = "ID is required")
    @Size(min = 2,message = "Your id must be more then 2 char")
    private String id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "age is required")
    private  Integer age;
    @NotEmpty(message = "classList is required")
    private ArrayList classList;
    @NotEmpty(message = "advisorName is required")
    private String advisorName;
    @NotEmpty(message = "major is required")
    private String major;
}
