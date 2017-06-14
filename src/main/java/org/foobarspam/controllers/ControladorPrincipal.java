package org.foobarspam.controllers;

import org.foobarspam.model.Carrera;
import org.foobarspam.model.CotxoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorPrincipal {
	
	private Carrera carrera;
	
	@Autowired
	private CotxoxService cotxoxService;
	
	@ModelAttribute(name="carrera")
	public Carrera getCarrera(){
		return this.carrera;
	}
	
	
	@RequestMapping(path="/home")
	public String setPickUp(){
		this.carrera = new Carrera("123456");
		this.cotxoxService.addCarrera(this.carrera);
		return "1AskCotxox";
	}
	
	@RequestMapping(path="/estimatedCost")
	public String estimatedCost(@RequestParam(name="dist", defaultValue = "Magaluf") String dist, Model model){
		this.carrera.setDistancia(this.cotxoxService.getMapa(dist).getDistancia());
		this.carrera.setTiempoEsperado(this.cotxoxService.getMapa(dist).getTiempo());
		
		Double coste = this.carrera.getCosteEsperado();
		model.addAttribute("precio", coste.toString());
		return "2EstimatedCost";
	}
	
	
	
	@RequestMapping(path="/getRide")
	public String getRide(Model model){
		this.carrera.setConductor(this.cotxoxService.getADriver());
		
		model.addAttribute("nameConductor", this.carrera.getNombre());
		model.addAttribute("marcaMoto", this.carrera.getModelo());
		model.addAttribute("valoracion", this.carrera.getValoracion());
		model.addAttribute("imgConductor", this.carrera.getCareto());
		
		return "3driverInformation";
	}
	
	
	
	@RequestMapping(path="/pay")
	public String payRide(Model model){
		
		Double coste = this.carrera.getCosteEsperado();
		model.addAttribute("precio", coste.toString());
		return "4payDriver";
	}
	
	
	
	@RequestMapping(path="/rate")
	public String rateDriver(){
		return "5rateDriver";
	}

}
