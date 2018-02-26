package com.beleza.model;

public enum TipoPublicacao {

	WEB("WEB"), APP("APP");

	private String descricao;

	TipoPublicacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
