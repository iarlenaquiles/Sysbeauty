package com.beleza.model;

public enum Atendimento {

	DOMICILIO("DOMICILIO"), SALAO("SALAO"), AMBOS("AMBOS");

	private String descricao;

	Atendimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
