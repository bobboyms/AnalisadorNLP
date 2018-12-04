package com.analisador.app.controller.model.dto;

import java.util.List;

public class AnaliseDTO {

	private Double densidadeMedia = 1.2;
	private Double distanciaMedia = 0.6;
	private Long quantidadeDePalavras = 1500l;
	private Double similaridadeMedia = 0.48;
	
	private List<SitesDTO> sitesDto;
	
	public AnaliseDTO analiseDTOGenerator() {
		return new AnaliseDTO();
	}
	
	public Double getDensidadeMedia() {
		return densidadeMedia;
	}
	public void setDensidadeMedia(Double densidadeMedia) {
		this.densidadeMedia = densidadeMedia;
	}
	public Double getDistanciaMedia() {
		return distanciaMedia;
	}
	public void setDistanciaMedia(Double distanciaMedia) {
		this.distanciaMedia = distanciaMedia;
	}
	public Long getQuantidadeDePalavras() {
		return quantidadeDePalavras;
	}
	public void setQuantidadeDePalavras(Long quantidadeDePalavras) {
		this.quantidadeDePalavras = quantidadeDePalavras;
	}
	public Double getSimilaridadeMedia() {
		return similaridadeMedia;
	}
	public void setSimilaridadeMedia(Double similaridadeMedia) {
		this.similaridadeMedia = similaridadeMedia;
	}

	public List<SitesDTO> getSitesDto() {
		return sitesDto;
	}

	public void setSitesDto(List<SitesDTO> sitesDto) {
		this.sitesDto = sitesDto;
	}
	
}
