package com.example.restws;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService{
    Map<Integer,Patient> patients = new HashMap<>();

    int currentId = 123;
    public PatientServiceImpl() {
        init();
    }
    void init(){
        Patient p = new Patient();
        p.setId(currentId);
        p.setName("John");
        patients.put(p.getId(),p);
    }

    @Override
    public List<Patient> getPatients() {
        Collection<Patient> values = patients.values();
        ArrayList<Patient> lst = new ArrayList<>(values);
        return  lst;
    }
}
