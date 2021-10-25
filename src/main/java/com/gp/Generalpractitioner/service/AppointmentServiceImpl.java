package com.gp.Generalpractitioner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List<Appointment> listAppointments() {
		return appointmentRepository.findAll();
	}
	
	@Override
	public List<String> findByDate(String date) {
		
		ArrayList<Appointment> reservedAppointments = new ArrayList<Appointment>();
		reservedAppointments.addAll(appointmentRepository.findByDate(date));
		
		int[] free = new int[16];
		for (int i = 0; i < 16; i++) free[i] = 1;
		for (int i = 0; i < reservedAppointments.size(); i++) {
			free[reservedAppointments.get(i).getCounter()] = 0;
		}
		
		List<String> freeAppointments = new ArrayList<String>();
		
		for (int i = 0; i < free.length; i++) {
			switch (free[i]) {
			case 1:
				switch (i) {
				case 0: freeAppointments.add("08:00"); break;
				case 1: freeAppointments.add("08:15"); break;
				case 2: freeAppointments.add("08:30"); break;
				case 3: freeAppointments.add("08:45"); break;
				case 4: freeAppointments.add("09:00"); break;
				case 5: freeAppointments.add("09:15"); break;
				case 6: freeAppointments.add("09:30"); break;
				case 7: freeAppointments.add("09:45"); break;
				case 8: freeAppointments.add("10:00"); break;
				case 9: freeAppointments.add("10:15"); break;
				case 10: freeAppointments.add("10:30"); break;
				case 11: freeAppointments.add("10:45"); break;
				case 12: freeAppointments.add("11:00"); break;
				case 13: freeAppointments.add("11:15"); break;
				case 14: freeAppointments.add("11:30"); break;
				case 15: freeAppointments.add("11:45"); break;
					
				default: System.out.println("something went wrong"); break;
				}
				break;
			default: System.out.println(i+": reserved"); break;
			}
		}
		return freeAppointments;
	}

	@Override
	public Appointment saveAppointment(AppointmentDTO appointmentDTO) {
		return appointmentRepository.save(convertAppointmentDTOtoAppointment(appointmentDTO));
	}
	
	private Appointment convertAppointmentDTOtoAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		appointment.setLast_name(appointmentDTO.getLast_name());
		appointment.setFirst_name(appointmentDTO.getFirst_name());
		appointment.setTaj(appointmentDTO.getTaj());
		appointment.setDate(appointmentDTO.getDate().replaceAll("-", "."));
		appointment.setTime(appointmentDTO.getTime());
		appointment.setCounter(appointmentDTO.getCounter());
		return appointment;
	}

	@Override
	public List<Appointment> findByDateAdmin(String date) {
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
