package com.analisador.app.controller.model.dto;

import java.util.List;

public class SitesDTO {
	
	private String titulo;
	private String url;
	
	private List<PalavraDTO> palavraDtos;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<PalavraDTO> getPalavraDtos() {
		return palavraDtos;
	}
	public void setPalavraDtos(List<PalavraDTO> palavraDtos) {
		this.palavraDtos = palavraDtos;
	}

}
