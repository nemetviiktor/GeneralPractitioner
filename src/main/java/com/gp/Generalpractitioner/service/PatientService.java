package com.gp.Generalpractitioner.service;

import java.util.List;

import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;

public interface PatientService {
	
	public Iterable<Patient> listPatients();
	
	public Patient savePatient(PatientDTO patientDTO);
	
	public List<Patient> findPatientsByDate(List<Appointment> appointments);
}
