package com.walterpaulo.geradorVersiculo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.walterpaulo.geradorVersiculo.service.VersiculoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HomeController {

	private VersiculoService versiculoService;

	@RequestMapping("/")
	public ModelAndView home() {
		final var modelAndView = new ModelAndView();
		modelAndView.setViewName("home.html");
		final var versiculo = versiculoService.buscarVersiculo();
		modelAndView.getModel().put("versiculo", versiculo == null ? null : versiculo);
		return modelAndView;
	}
}
