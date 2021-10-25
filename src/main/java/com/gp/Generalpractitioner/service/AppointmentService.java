package com.gp.Generalpractitioner.service;

import java.util.List;
import java.util.Optional;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;


public interface AppointmentService {
	
	public List<Appointment> listAppointments();
	
	public List<String> findByDate(String date);
	
	public Appointment saveAppointment(AppointmentDTO appointmentDTO);
	
	public List<Appointment> findByDateAdmin(String date);
	
	public Optional<Appointment> findById(int id);
	
	public String deleteAppointment(int id);
	
	

}
