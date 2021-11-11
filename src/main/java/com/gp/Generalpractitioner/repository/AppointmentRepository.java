package com.gp.Generalpractitioner.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	
	public List<Appointment> findByDate(Date date);
	
}
