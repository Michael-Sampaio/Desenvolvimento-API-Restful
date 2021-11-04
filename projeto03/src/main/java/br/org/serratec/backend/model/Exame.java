package br.org.serratec.backend.model;

import org.springframework.stereotype.Component;

@Component
public class Exame {
	
	public Double calcularExame(Double valor) {
		return valor = valor * 1.05;
	}

}
