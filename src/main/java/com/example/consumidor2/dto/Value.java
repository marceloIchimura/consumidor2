package com.example.consumidor2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar campos que não estão mapeados no objeto (para não lançar erros quando ocorrer de ter mais algum campo que não foi mapeado na classe) 
@JsonInclude(Include.NON_NULL)              // Para quando alguma outra aplicação estiver consumindo daqui, não enviar valores nulos.
public record Value(Long id, String quote) { } 