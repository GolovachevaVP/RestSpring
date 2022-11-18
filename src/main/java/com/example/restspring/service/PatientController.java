package com.example.restspring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
class PatientController {
    private final PatientsService patientsService;


    @Autowired
    PatientController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Patients patient) {
        patientsService.create(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Patients> findAll() {
        return ResponseEntity.ok().body(patientsService.readAll()).getBody();
    }

    @GetMapping(value = "/{id}")
    public Patients findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(patientsService.read(id)).getBody();
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Patients patient) {
        ResponseEntity.ok().body(patientsService.update(patient,id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        ResponseEntity.ok().body(patientsService.delete(id));
    }

}
