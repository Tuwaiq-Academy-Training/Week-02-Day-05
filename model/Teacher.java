package com.example.schoolmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@AllArgsConstructor @Data
public class Teacher {
    @NotEmpty(message = "ID is required")
    private String id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "classList is required")
    private ArrayList classList;
}
