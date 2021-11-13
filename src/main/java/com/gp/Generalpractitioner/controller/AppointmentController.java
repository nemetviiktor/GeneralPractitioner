package com.gp.Generalpractitioner.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.service.AppointmentService;
import com.gp.Generalpractitioner.service.AppointmentUtil;
import com.gp.Generalpractitioner.service.PatientService;

@Controller
public class AppointmentController {

	private AppointmentService appointmentService;
	private PatientService patientService;

	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	
	
	
	
	//DATET ÁTNÉZNI
	
	
	
	
	
	@RequestMapping(value = "/booking")
	public ModelAndView getAllApointments() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");
		LocalDate date = LocalDate.now();
		System.out.println(date);
		new AppointmentUtil();
		LocalDate endDate = AppointmentUtil.addDaysSkippingWeekends(date, 5);
		mav.addObject("date", date);
		mav.addObject("startDate", date);
		mav.addObject("endDate", endDate);
		mav.addObject("appointmentDTO", new AppointmentDTO());
		return mav;
	}

	@RequestMapping(value = "/appointments")
	public ModelAndView getFreeAppointmentsGivenDay(@RequestParam Date date) throws ParseException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeappointments");

		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String replaceDate = dateString.replace("-", ".");

		mav.addObject("displayDate", replaceDate);
		mav.addObject("date", date);
		mav.addObject("appointments", appointmentService.findByDate(date));
		return mav;
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView reserve(@RequestParam("date") Date date, @RequestParam("time") String time,
			@ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingdetails");

		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String replaceDate = dateString.replace("-", ".");

		appointmentDTO.setDate(date);
		appointmentDTO.setTime(time);
		mav.addObject("displayDate", replaceDate);
		mav.addObject("date", date);
		mav.addObject("time", time);
		mav.addObject("patientDTO", new PatientDTO());
		mav.addObject(appointmentDTO);
		return mav;
	}

	@PostMapping("/reserveAppointment")
	public ModelAndView reserveAppointment(@RequestParam("date") Date date, @RequestParam("time") String time,
			@ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO,
			@ModelAttribute("patientDTO") PatientDTO patientDTO) {

		appointmentDTO.setDate(date);
		appointmentDTO.setCounter(new AppointmentUtil().string2index(time));
		patientDTO.setIdAppointment(new AppointmentUtil().generateIndex(appointmentDTO));

		appointmentService.saveAppointment(appointmentDTO);
		patientService.savePatient(patientDTO);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "admin/adminReservedAppointments")
	public ModelAndView getReservedAppointmentsGivenDay(@RequestParam(required = false) Date date)
			throws ParseException {
		if (date == null) {
			date = new Date(System.currentTimeMillis());
		}

		ModelAndView mav = new ModelAndView();
		// mav.addObject("appointments", appointmentService.listAppointments());
		// mav.addObject("patients", patientService.listPatients());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		mav.addObject("patientDTO", new PatientDTO());
		mav.setViewName("adminReservedAppointments");

		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String displayDate = dateString.replace("-", ".");

		mav.addObject("displayDate", displayDate);
		mav.addObject("appointments", appointmentService.findByDateAdmin(date));
		mav.addObject("patients", patientService.findPatientsByDate(appointmentService.findByDateAdmin(date)));
		// mav.addObject("patient", patientService.findByIdAppointment(202110290));
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		Optional<Appointment> appointment = appointmentService.findById(id);
		if (!appointment.isPresent()) {
			return new ModelAndView("error");
		}
		appointmentService.deleteAppointment(id);
		return new ModelAndView("redirect:admin/adminReservedAppointments");
	}

}
