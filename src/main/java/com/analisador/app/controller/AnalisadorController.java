package com.analisador.app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.analisador.app.controller.model.dto.AnaliseDTO;
import com.analisador.app.controller.model.dto.PalavraDTO;
import com.analisador.app.controller.model.dto.Produto;
import com.analisador.app.controller.model.dto.SitesDTO;
import com.analisador.app.controller.model.dto.UrlsDTO;

import br.com.nlp.models.Corpus;
import br.com.nlp.models.Documento;
import br.com.nlp.models.Termo;
import br.com.nlp.utils.Utils;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:1234")
public class AnalisadorController {

	@PostMapping("/analise-media-concorrentes")
	public AnaliseDTO analiseMediaConcorrentes(@RequestBody UrlsDTO urlsdto) {

		String palavraChave = urlsdto.getPalavraChave();

		Corpus corpus = new Corpus();
		AnaliseDTO dto = new AnaliseDTO();
		dto.setSitesDto(new ArrayList<>());

		for (String url : urlsdto.getUrls()) {

			Document doc;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				continue;
//				e.printStackTrace();
			}

			Documento documento = new Documento(doc.getElementsByTag("body").text(), url,
					doc.getElementsByTag("h1").text());
			corpus.adicionarDocumento(documento);

			SitesDTO sitesDTO = new SitesDTO();
			sitesDTO.setTitulo(documento.getTituloH1());
			sitesDTO.setUrl(documento.getUrl());

			sitesDTO.setPalavraDtos(new ArrayList<>());

			Map<Termo, Double> resultados = null;
			try {
				resultados = documento.getFrequenciaComMaiorSimilaridade(palavraChave);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Set<Termo> termos = resultados.keySet();

			for (Termo termo : termos) {

				Double similaridade = resultados.get(termo);

				if (similaridade >= 0.58) {
					PalavraDTO palavraDTO = new PalavraDTO();
					palavraDTO.setPalavra(termo.getTermo());
					palavraDTO.setFrequencia(Utils.truncar(termo.getFrequenciaDoTermoTF(), 5));
					palavraDTO.setSimilaridade(similaridade);

					sitesDTO.getPalavraDtos().add(palavraDTO);
				}

			}

			dto.getSitesDto().add(sitesDTO);

		}
		corpus.atualizarTF_IDF();

		dto.setDensidadeMedia(corpus.getDensidadeMediaDaPalavraNoCorpus(palavraChave) * 100);
		dto.setDistanciaMedia(corpus.getDistanciaMediaDaPalavraNoCorpus(palavraChave));
		dto.setQuantidadeDePalavras(corpus.getQuantidadeMediaDaPalavraNoCorpus());
		dto.setSimilaridadeMedia(0.0);

		return dto;

	}

	@PostMapping("/analise-produto")
	public Produto analiseProduto(@RequestBody Produto produto) {

		System.out.println(produto.getNome());

		return new Produto();

	}
}
