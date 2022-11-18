package com.example.restspring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class PatientsServiceImpl implements PatientsService{
    private static final Map<Long, Patients> PATIENT_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicLong PATIENT_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Patients patient) {
        final long clientId = PATIENT_ID_HOLDER.incrementAndGet();
        patient.setId(clientId);
        PATIENT_REPOSITORY_MAP.put(clientId, patient);
    }

    @Override
    public List<Patients> readAll() {
        return new ArrayList<>(PATIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Patients read(long id) {
        return PATIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Patients client, long id) {
        if (PATIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            PATIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(long id) {
        return PATIENT_REPOSITORY_MAP.remove(id) != null;
    }
}

