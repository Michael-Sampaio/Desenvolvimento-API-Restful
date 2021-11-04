package br.com.serratec.api.projeto01.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/alunos")
	public class AlunoControler{
		private static List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		static {
			listaAlunos.add(new Aluno(1234L, "Ana", "233434", "ana@gmail.com"));
			listaAlunos.add(new Aluno(1364L, "Bia", "233894", "ana@gmail.com"));
			listaAlunos.add(new Aluno(4589L, "Arthur", "253434", "ana@gmail.com"));
			listaAlunos.add(new Aluno(4763L, "Flávio", "233474", "ana@gmail.com"));
		}
		
		@GetMapping
		public List<Aluno> listar() {
			return listaAlunos;
		}
		@GetMapping("/{matricula}")
		public Aluno buscar(@PathVariable Long matricula) {
			for (int i = 0; i < listaAlunos.size(); i++) {
				if (listaAlunos.get(i).getMatricula().equals(matricula)) {
					return listaAlunos.get(i);
				}
			}
			return null;
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Aluno inserir(@RequestBody Aluno aluno){
			listaAlunos.add(aluno);
			return aluno;
		}
		
		
	}