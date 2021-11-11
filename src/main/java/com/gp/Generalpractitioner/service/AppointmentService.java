package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;


public interface AppointmentService {
	
	public Iterable<Appointment> listAppointments();
	
	public List<String> findByDate(Date date);
	
	public Appointment saveAppointment(AppointmentDTO appointmentDTO);
	
	public List<Appointment> findByDateAdmin(Date date);
	
	public Optional<Appointment> findById(int id);
	
	public String deleteAppointment(int id);	
}
