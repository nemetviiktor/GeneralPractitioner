package com.gp.Generalpractitioner.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.controller.dto.PatientDTO;
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
		List<String> freeAppointments = new ArrayList();

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
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(appointmentDTO.getDate());
		String replaceDate = dateString.replace("-", "");
		String append = (new StringBuilder().append(Integer.parseInt(replaceDate)).append(appointmentDTO.getCounter()))
				.toString();
		Integer dateInt = Integer.parseInt(append);
		return dateInt;
	}

	public Appointment convertAppointmentDTOtoAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		appointment.setIdAppointment(generateIndex(appointmentDTO));
		appointment.setDate(appointmentDTO.getDate());
		appointment.setTime(appointmentDTO.getTime());
		appointment.setCounter(appointmentDTO.getCounter());
		return appointment;
	}

	public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}
	/*
	 * public ArrayList<String> AppointmentAndPatient2Object(Date date) {
	 * ArrayList<String> Appointment = new ArrayList<String>();
	 * Appointment.addAll(Appointment) return null;
	 * 
	 * }
	 */
}
