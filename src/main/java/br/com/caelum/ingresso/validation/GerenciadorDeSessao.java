package br.com.caelum.ingresso.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova){
		LocalDate hoje = LocalDate.now();
		
		LocalDateTime horarioSessaoExistente = sessaoExistente.getHorario().atDate(hoje);
		LocalDateTime horarioSessaoNova = sessaoNova.getHorario().atDate(hoje);
		
		boolean terminaAntes = sessaoNova.getHorarioTermino()
								.isBefore(horarioSessaoExistente);
		
		boolean comecaDepois = sessaoExistente.getHorarioTermino()
								.isBefore(horarioSessaoNova);
		
		if(terminaAntes || comecaDepois){
			return false;
		}
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova){
		Stream<Sessao> stream = sessoesDaSala.stream();
		return sessoesDaSala.stream().noneMatch(sessaoExistente ->
										horarioIsConflitante(sessaoExistente, sessaoNova)
										);
	}
		
	
}
