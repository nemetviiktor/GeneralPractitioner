package com.gp.Generalpractitioner.service;

import java.util.ArrayList;
import java.util.List;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;

public class AppointmentUtil {

	public Integer string2index(String time) {
		return getAllString().indexOf(time);
	}

	public String index2String(int index) {
		return getAllString().get(index);
	}

	public List<String> getAllString() {
		List<String> freeAppointments = new ArrayList<String>();

		freeAppointments.add("08:00");
		freeAppointments.add("08:15");
		freeAppointments.add("08:30");
		freeAppointments.add("08:45");
		freeAppointments.add("09:00");
		freeAppointments.add("09:15");
		freeAppointments.add("09:30");
		freeAppointments.add("09:45");
		freeAppointments.add("10:00");
		freeAppointments.add("10:15");
		freeAppointments.add("10:30");
		freeAppointments.add("10:45");
		freeAppointments.add("11:00");
		freeAppointments.add("11:15");
		freeAppointments.add("11:30");
		freeAppointments.add("11:45");

		return freeAppointments;
	}

	public Integer generateIndex(AppointmentDTO appointmentDTO) {
		String dateString = new DateUtil().removeHyphenFromDate(appointmentDTO.getDate());
		String index = (new StringBuilder().append(Integer.parseInt(dateString)).append(appointmentDTO.getIndex()))
				.toString();
		return Integer.parseInt(index);
	}

	public Appointment convertAppointmentDTOtoAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		Patient patient = new Patient();
		patient.setSocialSecurityNumber(appointmentDTO.getSocialSecurityNumber());
		appointment.setSocialSecurityNumber(patient);
		appointment.setIdAppointment(generateIndex(appointmentDTO));
		appointment.setDate(appointmentDTO.getDate());
		appointment.setIndex(appointmentDTO.getIndex());
		appointment.setTime(appointmentDTO.getTime());
		return appointment;
	}
	
	
	public AppointmentDTO convertAppointmentToAppointmentDTO (Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setIdAppointment(appointment.getIdAppointment());
		appointmentDTO.setDate(appointment.getDate());
		appointmentDTO.setTime(appointment.getTime());
		appointmentDTO.setIndex(appointment.getIndex());
		appointmentDTO.setSocialSecurityNumber(appointment.getSocialSecurityNumber().getSocialSecurityNumber());
		return appointmentDTO;
	}
	
}
