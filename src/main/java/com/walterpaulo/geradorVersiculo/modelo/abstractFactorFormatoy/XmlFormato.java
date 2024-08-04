package com.walterpaulo.geradorVersiculo.modelo.abstractFactorFormatoy;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.walterpaulo.geradorVersiculo.modelo.VersiculoResponse;

public class XmlFormato implements FormatoArquivo {

	@Override
	public String retornarAquivo(VersiculoResponse versiculoResponse) {

		XStream xstream = new XStream(new StaxDriver());

		xstream.processAnnotations(VersiculoResponse.class);
//		xstream.alias("versiculo", VersiculoResponse.class);

		return xstream.toXML(versiculoResponse);

	}

}
