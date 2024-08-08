package com.walterpaulo.geradorVersiculo.service;

import java.net.URI;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walterpaulo.geradorVersiculo.exeption.advice.VersiculoNotFoundExcpetion;
import com.walterpaulo.geradorVersiculo.modelo.VersiculoResponse;
import com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy.Application;
import com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy.GUIFactory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VersiculoService {

	private Environment environment;
	private ObjectMapper objectMapper;
	private final Map<String, GUIFactory> tiposArquivos;

	public VersiculoResponse buscarVersiculo() {
		try {
			String versao = "acf";
			var uri = URI.create(
					Objects.requireNonNull(environment.getProperty("app.onbibles.url") + "?bibleSlug=" + versao));
			JsonNode jsonNode = objectMapper.readTree(uri.toURL());
			JsonNode bibleNode = jsonNode.get("item").get("bible");
			String nome = bibleNode.get("book").get("name").asText();
			int capitulo = bibleNode.get("book").get("chapter").get("number").asInt();
			int versiculo = bibleNode.get("book").get("chapter").get("verses").get(0).get("number").asInt();
			String verso = bibleNode.get("book").get("chapter").get("verses").get(0).get("text").asText();
			return new VersiculoResponse(nome, capitulo, versiculo, verso, versao);

		} catch (Exception e) {
			log.error("Não foi possível ler arquivo", e);
		}
		return null;
	}

	public String geradorVersiculoPorFormato(String formato) {
		Application app;
		GUIFactory fabrica = null;

		VersiculoResponse versiculo = this.buscarVersiculo();

		Optional.of(versiculo).orElseThrow(() -> new VersiculoNotFoundExcpetion());

		fabrica = criarFormato(formato);
		app = new Application(fabrica);

		return app.retornarAquivo(versiculo);
	}

	public GUIFactory criarFormato(String formato) {
		GUIFactory tipoArquivo = tiposArquivos.get(formato);
		if (Objects.isNull(tipoArquivo)) {
			throw new IllegalArgumentException("Formato não suportado");
		}
		return tipoArquivo;
	}

}
