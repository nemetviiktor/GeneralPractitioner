package com.gp.Generalpractitioner.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.gp.Generalpractitioner.model.Appointment;
import com.gp.Generalpractitioner.service.AppointmentService;


@Controller
public class AppointmentController {
	
	private AppointmentService appointmentService;
	
	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@RequestMapping(value = "/booking")
	public ModelAndView getAllApointments() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking");
		mav.addObject("appointment", appointmentService.listAppointments());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		return mav;
	}

	@RequestMapping(value = "/appointments")
	public ModelAndView getFreeAppointmentsGivenDay(@RequestParam String date) throws ParseException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeappointments");
		DateFormat outputFormat = new SimpleDateFormat("yyyy.MM.dd.");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDate = inputFormat.parse(date);
		String selectedDate = outputFormat.format(dateDate);
		mav.addObject("date", selectedDate);
		mav.addObject("appointments", appointmentService.findByDate(selectedDate));
		//mav.addObject("appointmentDTO", new AppointmentDTO());
		return mav;
	}
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView reserve(@RequestParam("date") String date, @RequestParam("time") String time, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingdetails");
		appointmentDTO.setDate(date);
		appointmentDTO.setTime(time);
		mav.addObject("date", date);
		mav.addObject("time", time);
		mav.addObject(appointmentDTO);
		return mav;
	}
	
	@PostMapping("/reserveAppointment")
	public ModelAndView reserveAppointment(@RequestParam("date") String date, @RequestParam("time") String time, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
		
		appointmentDTO.setDate(date);
		
		switch (time) {
		case "08:00": appointmentDTO.setCounter(0); break;
		case "08:15": appointmentDTO.setCounter(1); break;
		case "08:30": appointmentDTO.setCounter(2); break;
		case "08:45": appointmentDTO.setCounter(3); break;
		case "09:00": appointmentDTO.setCounter(4); break;
		case "09:15": appointmentDTO.setCounter(5); break;
		case "09:30": appointmentDTO.setCounter(6); break;
		case "09:45": appointmentDTO.setCounter(7); break;
		case "10:00": appointmentDTO.setCounter(8); break;
		case "10:15": appointmentDTO.setCounter(9); break;
		case "10:30": appointmentDTO.setCounter(10); break;
		case "10:45": appointmentDTO.setCounter(11); break;
		case "11:00": appointmentDTO.setCounter(12); break;
		case "11:15": appointmentDTO.setCounter(13); break;
		case "11:30": appointmentDTO.setCounter(14); break;
		case "11:45": appointmentDTO.setCounter(15); break;
		default: System.out.println("AppointmentController: reserveAppointment: setCounter fail"); break; }
		
		appointmentService.saveAppointment(appointmentDTO);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("admin/adminAppointments")
	public ModelAndView getFreeAppointmentsGivenDayAdmin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("appointment", appointmentService.listAppointments());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd.");  
		Date today = new Date();
		String dateToday = formatter.format(today);
		mav.setViewName("adminAppointments");
		mav.addObject("date", dateToday);
		mav.addObject("appointments", appointmentService.findByDateAdmin(dateToday));
		//mav.addObject("appointmentDTO", new AppointmentDTO());
		return mav;
	}
	
	@RequestMapping(value = "admin/selectedDayAdmin")
	public ModelAndView getReservedAppointmentsGivenDay(@RequestParam String date) throws ParseException {
		ModelAndView mav = new ModelAndView();
		mav.addObject("appointment", appointmentService.listAppointments());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		mav.setViewName("adminReservedAppointments");
		DateFormat outputFormat = new SimpleDateFormat("yyyy.MM.dd.");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDate = inputFormat.parse(date);
		String selectedDate = outputFormat.format(dateDate);
		mav.addObject("date", selectedDate);
		mav.addObject("appointments", appointmentService.findByDateAdmin(selectedDate));
		//mav.addObject("appointmentDTO", new AppointmentDTO());
		return mav;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		Optional<Appointment> appointment = appointmentService.findById(id);
		if (!appointment.isPresent()) {
			return new ModelAndView("error");
		}
        appointmentService.deleteAppointment(id);
        return new ModelAndView("redirect:admin/adminAppointments");                             //Required String parameter 'date' is not present megoldása java kódban
    }
	
}
