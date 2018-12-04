package com.analisador.app.controller.model.dto;

import java.util.List;

public class UrlsDTO {

	private List<String> urls;

	private String palavraChave = "nenhuma";
	
	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	
}
