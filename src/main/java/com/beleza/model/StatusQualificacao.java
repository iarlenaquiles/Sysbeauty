package com.beleza.model;

public enum StatusQualificacao {

	NAOQUALIFICADO("Aguardando qualificação"), QUALIFICADO("Qualificado");

	private String descricao;

	StatusQualificacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
