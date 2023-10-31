package com.example.restws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/patientService")
public interface PatientService {
    @Path("/patients")
    @GET
    List<Patient> getPatients();
}
