package com.example.consumidor2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public record Quote(@JsonProperty("type") String typeComNomeDiferente, Value value // a notação @JsonProperty é para quando na minha classe de mapeamento o objeto estiver com nome diferente do Json, 
																				   // ele reconhecer pelo nome que esta entre parenteses 
	) { }