package com.gp.Generalpractitioner.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.AppointmentDTO;
import com.gp.Generalpractitioner.controller.dto.PatientDTO;
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.model.Patient;
import com.gp.Generalpractitioner.service.AppointmentService;
import com.gp.Generalpractitioner.service.AppointmentUtil;
import com.gp.Generalpractitioner.service.DateUtil;
import com.gp.Generalpractitioner.service.PatientService;
import com.gp.Generalpractitioner.service.PatientUtil;

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

	// DATET ÁTNÉZNI

	@RequestMapping(value = "/booking")
	public ModelAndView getAllApointments() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");

		LocalDate date = LocalDate.now();
		LocalDate endDate = DateUtil.addDaysSkippingWeekends(date, 4);
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
		mav.addObject("date", date);
		mav.addObject("appointments", appointmentService.findFreeAppointmentsByDate(date));
		return mav;
	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView reserve(@ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingdetails");
		mav.addObject("date", appointmentDTO.getDate());
		mav.addObject("time", appointmentDTO.getTime());
		mav.addObject("patientDTO", new PatientDTO());
		mav.addObject(appointmentDTO);
		return mav;
	}

	@PostMapping("/reserveAppointment")
	public ModelAndView reserveAppointment(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO,
			BindingResult bindingResult, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {

		if (!bindingResult.hasErrors()) {
			appointmentDTO.setCounter(new AppointmentUtil().string2index(appointmentDTO.getTime()));
			patientDTO.setIdAppointment(new AppointmentUtil().generateIndex(appointmentDTO));
			appointmentService.saveAppointment(appointmentDTO);
			patientService.savePatient(patientDTO);
			return new ModelAndView("redirect:/");
		}

		return new ModelAndView("bookingdetails").addObject(patientDTO).addObject(appointmentDTO)
				.addObject("date", appointmentDTO.getDate()).addObject("time", appointmentDTO.getTime());
	}

	@RequestMapping(value = "admin/adminReservedAppointments")
	public ModelAndView getReservedAppointmentsGivenDay(@RequestParam(required = false) Date date)
			throws ParseException {

		if (date == null) {
			date = new DateUtil().getCurrentDate();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("appointmentDTO", new AppointmentDTO());
		mav.addObject("patientDTO", new PatientDTO());
		mav.addObject("date", date);
		mav.setViewName("adminReservedAppointments");
		mav.addObject("appointments", appointmentService.findReservedAppointmentsByDate(date));
		mav.addObject("patients",
				patientService.findPatientsByDate(appointmentService.findReservedAppointmentsByDate(date)));
		// mav.addObject("patient", patientService.findByIdAppointment(202110290));
		return mav;
	}
	
	@RequestMapping(value = "admin/modify")
	public ModelAndView showSelectedAppointment(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		AppointmentDTO appointmentDTO = new AppointmentUtil().convertAppointmentToAppointmentDTO(appointmentService.findById(id));
		mav.addObject("date", appointmentDTO.getDate());
		mav.addObject("time", appointmentDTO.getTime());
		mav.addObject("appointmentDTO", appointmentDTO);
		Appointment appointment = new Appointment();
		appointment.setIdAppointment(id);
		mav.addObject("patientDTO",
				new PatientUtil().convertPatientToPatientDTO(patientService.findByIdAppointment(appointment)));
		mav.addObject("id", patientService.findByIdAppointment(appointment).getIdPatient());

		mav.setViewName("adminModifyAppointment");
		return mav;
	}
	
	@PostMapping(value = "admin/update")
	public ModelAndView updatePatient(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO,
			BindingResult bindingResult, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO,
			@RequestParam("id") int id) {
		Patient patient = patientService.findById(id);
		if (!bindingResult.hasErrors()) {
			patientService.updatePatient(patientDTO, id);
			return new ModelAndView("redirect:adminReservedAppointments");
		}
		return new ModelAndView("adminModifyAppointment").addObject(patientDTO).addObject(appointmentDTO).addObject("date", appointmentDTO.getDate()).addObject("time", appointmentDTO.getTime()).addObject("id", id);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		Appointment appointment = appointmentService.findById(id);
		if (!appointment.getIdAppointment().equals(id)) {
			return new ModelAndView("error");
		}
		appointmentService.deleteAppointment(id);
		return new ModelAndView("redirect:admin/adminReservedAppointments");
	}

}
