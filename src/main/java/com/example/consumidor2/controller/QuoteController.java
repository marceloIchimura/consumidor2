package com.example.consumidor2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.consumidor2.dto.CitacaoRecord;
import com.example.consumidor2.dto.Quote;



@RestController 
public class QuoteController {

	private RestTemplate restTemplate = new RestTemplate();	
	
	@GetMapping ("/citacao/aleatoria")
	public ResponseEntity<Object> getQuoteFromApi(){
		
		//Chama a api e mapea os valores pro quote
		Quote quote = restTemplate.getForObject("http://localhost:8081/api/random", Quote.class);

		CitacaoRecord citacaoRecord = criarCitacaoAjustada(quote);
		
		//Retorno o qualquerCoisa, objeto com os campos no formato que eu quero
		return ResponseEntity.status(HttpStatus.OK).body(citacaoRecord);
	}
	
	@GetMapping ("/citacao")
	public ResponseEntity<Object> getAllQuote(){
		
		//Chama a api e mapea os valores pro quote
		ResponseEntity<List<Quote>> rateResponse =
		        restTemplate.exchange("http://localhost:8081/api",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Quote>>() {
		            });
		List<Quote> quotes = rateResponse.getBody();
		
		List<CitacaoRecord> citacoes = new ArrayList<>();
		for (Quote quote : quotes) {
			citacoes.add(criarCitacaoAjustada(quote));
		}
		
		//Retorno o qualquerCoisa, objeto com os campos no formato que eu quero
		return ResponseEntity.status(HttpStatus.OK).body(citacoes);
	}
	
	private CitacaoRecord criarCitacaoAjustada(Quote quote) {
		String value = "";
		
		if (isPar(quote.value().id())) {
			value = quote.value().quote().replace(" ", "");
		} else {
			value = quote.value().quote().concat("impar");
		}
		
		if (isMaiorQueDez(quote.value().id())) {
			value = value.concat("grande");
		}
		
		return new CitacaoRecord(value);
	}
	
	private boolean isPar(Long valor) {
		if(valor % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isMaiorQueDez(Long valor) {
		if (10L > valor) {
			return true;
		} else {
			return false;
		}
	}
	

	
	
}
