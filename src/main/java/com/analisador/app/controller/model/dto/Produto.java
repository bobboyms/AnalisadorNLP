package com.analisador.app.controller.model.dto;

public class Produto {
	private Long id = 100l;
	private String nome = "Teste";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
