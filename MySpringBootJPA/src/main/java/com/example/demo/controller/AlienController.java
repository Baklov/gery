package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Alien;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AlienController {
	
	private List<Alien> aliens = createSomeAliens();
	@RequestMapping(value ="/")
	public String home() {
		return "home.jsp";		
	}
	
	@RequestMapping(value ="/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Alien> firstPage()
	{
		return aliens;
	}
	
	public List<Alien> createSomeAliens() {
		Alien al  = new Alien(1, "Ivo",  "English");
        Alien al1 = new Alien(1, "Ivo2", "Deutshe");
		List<Alien> list = new ArrayList<>();
		list.add(al);
		list.add(al1);
		return list ;		
	}

}
