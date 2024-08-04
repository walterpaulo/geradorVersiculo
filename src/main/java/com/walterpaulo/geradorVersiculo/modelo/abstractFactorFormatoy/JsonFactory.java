package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

public class JsonFactory implements GUIFactory {

	@Override
	public FormatoArquivo criarFormato() {
		return new JsonFormato();
	}

}
