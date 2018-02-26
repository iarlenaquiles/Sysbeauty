package com.beleza.model;

public enum TipoEnvio {

	CLIENTES("CLIENTES"), PROFISSIONAIS("PROFISSIONAIS"), AMBOS("AMBOS");

	private String descricao;

	TipoEnvio(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
