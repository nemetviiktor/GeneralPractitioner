package com.gp.Generalpractitioner.service;

import java.util.List;
import java.util.Optional;

import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;

public interface PatientService {
	
	public Iterable<Patient> listPatients();
	
	
	public Patient findBySocialSecurityNumber(String socialSecurityNumber);
	
	public Patient savePatient(PatientDTO patientDTO);
	
	public List<Patient> findPatientsByDate(List<Appointment> appointments);
		
	public Patient updatePatient(PatientDTO patientDTO);
	
	public void deletePatient(String id);
}
