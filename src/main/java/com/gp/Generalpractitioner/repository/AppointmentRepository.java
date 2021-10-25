package com.gp.Generalpractitioner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	public List<Appointment> findAll();
	
	public List<Appointment> findByDate(String date);
	
}
