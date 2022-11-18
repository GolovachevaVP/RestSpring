package com.example.restspring.service;

import java.util.List;

public interface PatientsService {
    void create(Patients patient);

    List<Patients> readAll();

    Patients read(long id);

    boolean update(Patients patients, long id);

    boolean delete(long id);
}
