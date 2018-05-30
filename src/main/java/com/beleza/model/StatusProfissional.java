package com.beleza.model;

public enum StatusProfissional {

	EDITADO("Cadastro editado"), APROVADO("Cadastro Aprovado");

	private String descricao;

	StatusProfissional(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
