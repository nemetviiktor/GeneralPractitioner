package com.gp.Generalpractitioner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;
import com.gp.Generalpractitioner.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public Patient findById(int id) {
		return patientRepository.findById(id).get();
	}
	
	@Override
	public Iterable<Patient> listPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(PatientDTO patientDTO) {
		return patientRepository.save(new PatientUtil().convertPatientDTOtoPatient(patientDTO));
	}

	@Override
	public List<Patient> findPatientsByDate(List<Appointment> appointments) {
		List<Patient> patients = new ArrayList<Patient>();
		for (int i = 0; i < appointments.size(); i++) {
			patients.add(patientRepository.findByIdAppointment(appointments.get(i)));
		}
		return patients;
	}
	
	@Override
	public Patient updatePatient(PatientDTO patientDTO, int id) {
		Patient patient = new PatientUtil().convertPatientDTOtoPatient(patientDTO);
		patient.setIdPatient(id);
		return patientRepository.save(patient);
		
	}

	@Override
	public Patient findByIdAppointment(Appointment idAppointment) {
		return patientRepository.findByIdAppointment(idAppointment);
	}

	@Override
	public void deletePatient(Appointment idAppointment) {
		patientRepository.deleteByIdAppointment(idAppointment);
	}
}
