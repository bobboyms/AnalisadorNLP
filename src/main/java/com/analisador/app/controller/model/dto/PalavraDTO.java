package com.analisador.app.controller.model.dto;

public class PalavraDTO {
	
	private String palavra;
	private Double frequencia;
	private Double similaridade;
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public Double getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}
	public Double getSimilaridade() {
		return similaridade;
	}
	public void setSimilaridade(Double similaridade) {
		this.similaridade = similaridade;
	}
}
