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
		//patient.setIdAppointment(patientDTO.getIdAppointment());
		Appointment appointment = new Appointment();
		appointment.setIdAppointment(patientDTO.getIdAppointment());
		patient.setIdAppointment(appointment);
		return patient;
	}
	
	public PatientDTO convertPatientToPatientDTO(Patient patient) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setLastName(patient.getLastName());
		patientDTO.setFirstName(patient.getFirstName());
		patientDTO.setSocialSecurityNumber(patient.getSocialSecurityNumber());
		patientDTO.setIdAppointment(patient.getIdAppointment().getIdAppointment());
		return patientDTO;
	}
}
