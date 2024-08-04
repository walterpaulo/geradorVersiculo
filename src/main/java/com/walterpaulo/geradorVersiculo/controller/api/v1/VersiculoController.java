package com.walterpaulo.geradorVersiculo.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walterpaulo.geradorVersiculo.modelo.FormatoArquivo;
import com.walterpaulo.geradorVersiculo.service.VersiculoService;

@RestController
@RequestMapping("/api/v1/versiculo")
public class VersiculoController {

	@Autowired
	private VersiculoService versiculoService;

	@GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public String geradorVersiculoJson() {
		return versiculoService.geradorVersiculoPorFormato(FormatoArquivo.JSON);
	}

	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public String geradorVersiculoXml() {
		return versiculoService.geradorVersiculoPorFormato(FormatoArquivo.XML);
	}

}
