package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

import org.springframework.stereotype.Service;

@Service(TipoArquivo.XML)
public class XmlFactory implements GUIFactory {

	@Override
	public FormatoArquivo criarFormato() {
		return new XmlFormato();
	}

}
