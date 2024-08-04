package com.walterpaulo.geradorVersiculo.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("versiculo")
public record VersiculoResponse(String nome, Integer capitulo, Integer versiculo, String verso, String versao) {

}
