package com.walterpaulo.geradorVersiculo.service;

import java.net.URI;
import java.util.Objects;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walterpaulo.geradorVersiculo.modelo.VersiculoRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VersiculoService {

	private Environment environment;
	private ObjectMapper objectMapper;

	public VersiculoRequest buscarVersiculo() {
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
			return new VersiculoRequest(nome, capitulo, versiculo, verso, versao);

		} catch (Exception e) {
			log.error("Não foi possível ler arquivo", e);
		}
		return null;
	}

}
