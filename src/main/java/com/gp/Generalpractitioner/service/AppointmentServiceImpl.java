package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public Iterable<Appointment> listAppointments() {
		return appointmentRepository.findAll();
	}
	

	@Override
	public List<String> findByDate(Date date) {
		List<String> reservedAppointments = appointmentRepository.findByDate(date).stream()
				.map(appointment -> appointment.getTime())
				.collect(Collectors.toList());
		
		List<String> availableAppointments = new AppointmentUtil().getAllString();
		availableAppointments.removeAll(reservedAppointments);
		
		return availableAppointments;

	}
	
	@Override
	public Appointment saveAppointment(AppointmentDTO appointmentDTO) {
		return appointmentRepository.save(new AppointmentUtil().convertAppointmentDTOtoAppointment(appointmentDTO));
	}
	

	/*
	private User saveUser(AppointmentDTO appointmentDTO) {
		User user = new User();
		user.setAppointmentid(appointmentDTO.get);
		return null;
	}
	*/
	@Override
	public List<Appointment> findByDateAdmin(Date date) {
		List<Appointment> reservedAppointments = new ArrayList<Appointment>();
		reservedAppointments.addAll(appointmentRepository.findByDate(date));
		return reservedAppointments;
	}
	
	@Override
	public Optional<Appointment> findById(int id) {
		return appointmentRepository.findById(id);
	}
	
	@Override
	public String deleteAppointment(int id) {
		appointmentRepository.deleteById(id);
		return id + " appointment deleted";
	}
	
}
