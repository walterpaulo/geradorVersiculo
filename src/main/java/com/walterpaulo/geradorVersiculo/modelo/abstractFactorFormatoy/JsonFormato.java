package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.walterpaulo.geradorVersiculo.modelo.VersiculoResponse;

public class JsonFormato implements FormatoArquivo {

	@Override
	public String retornarAquivo(VersiculoResponse versiculoResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = objectMapper.writeValueAsString(versiculoResponse);
			return jsonString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;

	}

}
