package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;
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
	public List<String> findFreeAppointmentsByDate(Date date) {
		List<String> reservedAppointments = appointmentRepository.findByDate(date).stream()
				.map(appointment -> appointment.getTime()).collect(Collectors.toList());

		List<String> availableAppointments = new AppointmentUtil().getAllString();
		availableAppointments.removeAll(reservedAppointments);

		return availableAppointments;
	}

	@Override
	public Appointment saveAppointment(AppointmentDTO appointmentDTO) {
		return appointmentRepository.save(new AppointmentUtil().convertAppointmentDTOtoAppointment(appointmentDTO));
	}

	@Override
	public List<Appointment> findReservedAppointmentsByDate(Date date) {
		List<Appointment> reservedAppointments = new ArrayList<Appointment>();
		reservedAppointments.addAll(appointmentRepository.findByDate(date));
		return reservedAppointments;
	}

	@Override
	public Appointment findById(int id) {
		return appointmentRepository.findById(id).get();
	}

	@Override
	public void deleteAppointment(Patient socialSecurityNumber) {
		appointmentRepository.deleteBySocialSecurityNumber(socialSecurityNumber);
	}

	@Override
	public Appointment findBySocialSecurityNumber(Patient socialSecurityNumber) {
		return appointmentRepository.findBySocialSecurityNumber(socialSecurityNumber);
	}

	@Override
	public Appointment updateAppointment(AppointmentDTO appointmentDTO) {
		return appointmentRepository.save(new AppointmentUtil().convertAppointmentDTOtoAppointment(appointmentDTO));
	}
}
