package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;


public interface AppointmentService {
	
	public Iterable<Appointment> listAppointments();
	
	public List<String> findFreeAppointmentsByDate(Date date);
	
	public Appointment saveAppointment(AppointmentDTO appointmentDTO);
	
	public List<Appointment> findReservedAppointmentsByDate(Date date);
	
	public Appointment findById(int id);
	
	public void deleteAppointment(int id);	
}
