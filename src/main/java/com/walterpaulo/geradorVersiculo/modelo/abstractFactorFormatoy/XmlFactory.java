package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

public class XmlFactory implements GUIFactory {

	@Override
	public FormatoArquivo criarFormato() {
		return new XmlFormato();
	}

}
