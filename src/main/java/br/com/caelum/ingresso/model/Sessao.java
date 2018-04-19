package br.com.caelum.ingresso.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDateTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	public Sessao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @dprecated hibernate only	
	 */
	public Sessao(LocalDateTime horario, Filme filme, Sala sala){
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
	}
	public LocalDateTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
}
