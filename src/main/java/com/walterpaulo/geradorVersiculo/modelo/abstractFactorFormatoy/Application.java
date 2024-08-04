package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

import com.walterpaulo.geradorVersiculo.modelo.VersiculoResponse;

public class Application {
	private FormatoArquivo arquivoArquivo;

	public Application(GUIFactory factory) {
		arquivoArquivo = factory.criarFormato();
	}

	public String retornarAquivo(VersiculoResponse versiculoResponse) {
		return arquivoArquivo.retornarAquivo(versiculoResponse);
	}
}
