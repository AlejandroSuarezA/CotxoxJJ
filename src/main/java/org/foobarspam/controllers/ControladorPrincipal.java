package org.foobarspam.controllers;

import org.foobarspam.model.Carrera;
import org.foobarspam.model.CotxoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorPrincipal {
	
	private Carrera carrera;
	
	@ModelAttribute(name="carrera")
	public Carrera getCarrera(){
		return this.carrera;
	}
	
	
	@RequestMapping(path="/home")
	public String setPickUp(){
		this.carrera = new Carrera("123456");
		return "1AskCotxox";
	}
	
	@RequestMapping(path="/estimatedCost")
	public String estimatedCost(Model model){
		model.addAttribute("precio", this.carrera.getCosteTotal());
		return "2EstimatedCost";
	}
	
	@RequestMapping(path="/getRide")
	public String getRide(Model model){
		model.addAttribute("nameConductor", this.carrera.getNombre());
		model.addAttribute("marcaMoto", this.carrera.getModelo());
		model.addAttribute("valoracion", this.carrera.getValoracion());
		model.addAttribute("imgConductor", this.carrera.getCareto());
		return "3driverInformation";
	}
	
	@RequestMapping(path="/pay")
	public String payRide(){
		return "4payDriver";
	}
	
	@RequestMapping(path="/rate")
	public String rateDriver(){
		return "5rateDriver";
	}

}
