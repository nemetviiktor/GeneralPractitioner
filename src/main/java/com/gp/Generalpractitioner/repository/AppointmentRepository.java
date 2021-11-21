package com.gp.Generalpractitioner.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	
	public List<Appointment> findByDate(Date date);
	
	public Appointment findBySocialSecurityNumber(Patient socialSecurityNumber);
	
	public void deleteBySocialSecurityNumber(Patient socialSecurityNumber);
}
