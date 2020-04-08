package com.gp.Generalpractitioner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gp.Generalpractitioner.DAO.OrderingHoursRepository;

@Controller
public class OrderingHoursController {
	
	@Autowired
	OrderingHoursRepository repo;
	
	
	@RequestMapping("/test")
	public String Index() {
		
		return "booking.jsp";
		
		
	}

}
