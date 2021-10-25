package com.gp.Generalpractitioner.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public ModelAndView reserve(@RequestParam("date") Date date, @RequestParam("time") String time, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
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
		mav.addObject(appointmentDTO);
		return mav;
	}

	@PostMapping("/reserveAppointment")
	public ModelAndView reserveAppointment(@RequestParam("date") Date date, @RequestParam("time") String time, @ModelAttribute("appointmentDTO") AppointmentDTO appointmentDTO) {
		
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
	public ModelAndView getFreeAppointmentsGivenDayAdmin() throws ParseException {
		ModelAndView mav = new ModelAndView();
		mav.addObject("appointment", appointmentService.listAppointments());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy.MM.dd."); 
		java.util.Date today = new java.util.Date();
		String dateString1 = formatter.format(today);
		Date date = Date.valueOf(dateString1);
		String displayDate = formatter2.format(today);
		mav.setViewName("adminAppointments");
		mav.addObject("displayDate", displayDate);
		mav.addObject("appointments", appointmentService.findByDateAdmin(date));
		return mav;
	}
	
	@RequestMapping(value = "admin/selectedDayAdmin")
	public ModelAndView getReservedAppointmentsGivenDay(@RequestParam Date date) throws ParseException {
		ModelAndView mav = new ModelAndView();
		mav.addObject("appointment", appointmentService.listAppointments());
		mav.addObject("appointmentDTO", new AppointmentDTO());
		mav.setViewName("adminReservedAppointments");
		
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = inputFormat.format(date);
		String displayDate = dateString.replace("-", ".");
		
		mav.addObject("displayDate", displayDate);
		mav.addObject("appointments", appointmentService.findByDateAdmin(date));
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
