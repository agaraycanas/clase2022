package org.agaray.clase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebasController {
	@GetMapping("/prueba")
	public String index(
			ModelMap m
			) {
		m.put("view", "prueba/index");
		return "_t/frame";
	}
}
