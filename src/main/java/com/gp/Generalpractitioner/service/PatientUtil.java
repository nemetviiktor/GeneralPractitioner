package com.gp.Generalpractitioner.service;

import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;

public class PatientUtil {
	
	public Patient convertPatientDTOtoPatient(PatientDTO patientDTO) {
		Patient patient = new Patient();
		patient.setLastName(patientDTO.getLastName());
		patient.setFirstName(patientDTO.getFirstName());
		patient.setSocialSecurityNumber(patientDTO.getSocialSecurityNumber());
		patient.setDateOfBirth(patientDTO.getDateOfBirth());
		patient.setPhoneNumber(patientDTO.getPhoneNumber());
		return patient;
	}
	
	public PatientDTO convertPatientToPatientDTO(Patient patient) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setLastName(patient.getLastName());
		patientDTO.setFirstName(patient.getFirstName());
		patientDTO.setSocialSecurityNumber(patient.getSocialSecurityNumber());
		patientDTO.setDateOfBirth(patient.getDateOfBirth());
		patientDTO.setPhoneNumber(patient.getPhoneNumber());
		return patientDTO;
	}
}
