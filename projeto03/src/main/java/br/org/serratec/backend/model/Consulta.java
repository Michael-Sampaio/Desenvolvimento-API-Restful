package br.org.serratec.backend.model;

import org.springframework.stereotype.Component;

@Component
public class Consulta {
	
	public Double calcularConsulta(Double valor) {
		return valor = valor * 1.10;
	}

}
