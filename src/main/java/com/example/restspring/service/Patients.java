package com.example.restspring.service;

import lombok.Data;

@Data
public class Patients {
    private long id;
    private String name;
    private String type;
    private String status;

}
