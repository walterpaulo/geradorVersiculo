package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

import org.springframework.stereotype.Service;

@Service(TipoArquivo.JSON)
public class JsonFactory implements GUIFactory {

	@Override
	public FormatoArquivo criarFormato() {
		return new JsonFormato();
	}

}
