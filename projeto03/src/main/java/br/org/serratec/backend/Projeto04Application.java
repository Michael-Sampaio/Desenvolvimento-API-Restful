package br.org.serratec.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.org.serratec.backend.model.Pagamento;

@SpringBootApplication
public class Projeto04Application implements CommandLineRunner {

	@Autowired
	private Pagamento pagamento1;

	public static void main(String[] args) {
		SpringApplication.run(Projeto04Application.class, args);
		}
	
		@Override
		public void run (String... args) throws Exception{

			System.out.println("Total a pagar: "+ pagamento1.calcularPagamento(200., 50.));
	}

}
