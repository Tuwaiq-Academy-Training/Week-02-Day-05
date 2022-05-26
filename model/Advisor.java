package com.example.schoolmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
@AllArgsConstructor @Data
public class Advisor {
    @NotEmpty(message = "ID is required")
    private String id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "age is required")
    private  Integer age;
}
