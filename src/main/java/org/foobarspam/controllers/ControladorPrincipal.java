package org.foobarspam.controllers;

import org.foobarspam.model.CotxoxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorPrincipal {
	
	@RequestMapping(path="/home")
	public String maineo(){
		return "1AskCotxox";
	}
	

}
