package com.beleza.model;

public enum StatusAgendamento {

	AGUARDANDO("Aguardando aprovação"), APROVADO("Aprovado"), FINALIZADO("Finalizado"), CANCELADO("Cancelado");

	private String descricao;

	StatusAgendamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
