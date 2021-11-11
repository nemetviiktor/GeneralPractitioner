package com.gp.Generalpractitioner.service;

import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Patient;

public class PatientUtil {
	
	public Patient convertPatientDTOtoPatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		patient.setLastName(patientDTO.getLastName());
		patient.setFirstName(patientDTO.getFirstName());
		patient.setSocialSecurityNumber(patientDTO.getSocialSecurityNumber());
		patient.setIdAppointment(patientDTO.getIdAppointment());
		return patient;
	}
}
