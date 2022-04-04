package com.gp.Generalpractitioner.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String> {
	
	public Patient findBySocialSecurityNumber(String socialSecurityNumber);
}
