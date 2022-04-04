package com.gp.Generalpractitioner.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.sql.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.gp.Generalpractitioner.service.DocumentService;
import com.gp.Generalpractitioner.service.PatientService;
import com.gp.Generalpractitioner.service.PatientUtil;

@Controller
public class AppointmentController {

	private AppointmentService appointmentService;
	private PatientService patientService;
	private DocumentService documentService;

	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@Autowired
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(value = "/booking")
	public ModelAndView getAllApointments() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");

		LocalDate today = LocalDate.now();
		LocalDate endDate = DateUtil.addDaysSkippingWeekends(today, 8);
		mav.addObject("date", today);
		mav.addObject("startDate", today.plusDays(1));
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
		mav.addObject("maxDate", LocalDate.now());
		mav.addObject("patientDTO", new PatientDTO());
		mav.addObject(appointmentDTO);
		return mav;
	}

	@PostMapping("/reserveAppointment")
	public ModelAndView reserveAppointment(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO,
			BindingResult bindingResult, @Valid @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO, BindingResult bindingResult2) {

		if (!bindingResult.hasErrors() && !bindingResult2.hasErrors()) {
			appointmentDTO.setIndex(new AppointmentUtil().string2index(appointmentDTO.getTime()));
			appointmentDTO.setIdAppointment(new AppointmentUtil().generateIndex(appointmentDTO));
			patientService.savePatient(patientDTO);
			appointmentDTO.setSocialSecurityNumber(patientService.findBySocialSecurityNumber(patientDTO.getSocialSecurityNumber()).getSocialSecurityNumber());
			appointmentService.saveAppointment(appointmentDTO);
			return new ModelAndView("successfulReserving");
		}

		return new ModelAndView("bookingdetails").addObject(patientDTO).addObject(appointmentDTO)
				.addObject("date", appointmentDTO.getDate()).addObject("time", appointmentDTO.getTime()).addObject("dateOfBirth", appointmentDTO.getDate());
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
		mav.addObject("appointments", appointmentService.findReservedAppointmentsByDate(date));
		mav.addObject("patients",
				patientService.findPatientsByDate(appointmentService.findReservedAppointmentsByDate(date)));
		mav.setViewName("adminReservedAppointments");
		return mav;
	}
	
	@RequestMapping(value = "admin/modify")
	public ModelAndView showSelectedAppointment(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		AppointmentDTO appointmentDTO = new AppointmentUtil()
				.convertAppointmentToAppointmentDTO(appointmentService.findById(id));
		mav.addObject("date", appointmentDTO.getDate());
		mav.addObject("time", appointmentDTO.getTime());
		mav.addObject("maxDate", LocalDate.now());
		mav.addObject("appointmentDTO", appointmentDTO);
		Patient patient = appointmentService.findById(id).getSocialSecurityNumber();
		mav.addObject("patientDTO", new PatientUtil().convertPatientToPatientDTO(patient));

		mav.setViewName("adminModifyAppointment");
		return mav;
	}
	
	@PostMapping(value = "admin/update")
	public ModelAndView updatePatient(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO,
			BindingResult bindingResult, @Valid @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO, BindingResult bindingResult2) {
		if (!bindingResult.hasErrors() && !bindingResult2.hasErrors()) {
			patientService.updatePatient(patientDTO);
			appointmentDTO.setSocialSecurityNumber(patientDTO.getSocialSecurityNumber());
			appointmentDTO.setIndex(new AppointmentUtil().string2index(appointmentDTO.getTime()));
			appointmentService.saveAppointment(appointmentDTO);
			return new ModelAndView("redirect:adminReservedAppointments");
		}
		
		return new ModelAndView("adminModifyAppointment").addObject(patientDTO).addObject(appointmentDTO)
				.addObject("date", appointmentDTO.getDate()).addObject("time", appointmentDTO.getTime());
	}

	@Transactional
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		Appointment appointment = appointmentService.findById(id);
		if (!appointment.getIdAppointment().equals(id)) {
			return new ModelAndView("error");
		}
		appointmentService.deleteAppointment(appointment.getSocialSecurityNumber());
		documentService.deleteDocument(appointment.getSocialSecurityNumber());
		return new ModelAndView("redirect:admin/adminReservedAppointments");
	}
}
