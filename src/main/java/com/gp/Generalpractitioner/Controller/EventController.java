package com.gp.Generalpractitioner.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.DAO.EventRepository;
import com.gp.Generalpractitioner.DAO.OrderingHoursRepository;
import com.gp.Generalpractitioner.Model.Event;
import com.gp.Generalpractitioner.Model.OrderingHours;


@Controller
public class EventController {
	
	@Autowired
	EventRepository repo;
	
	@Autowired
	OrderingHoursRepository ohrepo;
	
	
	@RequestMapping("/")
	public String Index() {
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/back")
	public String Back() {
		
		return "index.jsp";
	}
	
	
	//Rendelési nap törlés
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        ohrepo.deleteById(id);
        return "/";
    }
	
	//Módosítás
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(Model model){
		model.addAttribute("ohours", getOHours());
		return "edit";	
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAllItem2(Model model){
		model.addAttribute("items",getItems());
		return "add.jsp";
	}
	
	@RequestMapping("/addItem")
	public String addItem(Event item){
		
		repo.save(item);
		
		return "add.jsp";
	}
	
	@RequestMapping(value="/showItems",method=RequestMethod.GET)
	public String getAllItem(Model model){
	model.addAttribute("items",getItems());
	model.addAttribute("ohours", getOHours());
	return "booking.jsp";	
	
	}
	
	public List<Event> getItems(){
		List<Event> items = repo.findAll();
		
		return items;
		
	}
	
	public List<OrderingHours> getOHours() {
		List<OrderingHours> ohours = ohrepo.findAll();
		
		return ohours;
	}
	
	

	public List<Event> getItemsByDate(){
		java.util.Date date = null;
		List<Event> items = repo.findAllByDate(date);
		return items;
	}
	
	@RequestMapping(value="/showSelected", method=RequestMethod.GET )
	public ModelAndView getEvent(@RequestParam int eventid){
		
		ModelAndView mv = new ModelAndView("showSelected.jsp");
		Event event = repo.findById(eventid).orElse(new Event());
		mv.addObject(event);
		
		return mv;
	}
	
	@RequestMapping(value="/selectedDate", method=RequestMethod.GET )
	public ModelAndView getDate(@RequestParam Date date){
		ModelAndView mv = new ModelAndView("selectedDate.jsp");
		List<Event> event = repo.findAllByDate(date);
		mv.addObject("event", event);
		return mv;
	}
	
	/*
	@RequestMapping(value="/selected", method=RequestMethod.GET )
	public ModelAndView getItem(@RequestParam String description){
		
		ModelAndView mv = new ModelAndView("selected.jsp");
		Event event = repo.findByDescription(description);
		mv.addObject(event);
		
		return mv;
	}
	*/
}
