package br.com.cadastro.model;

import javax.validation.constraints.Size;

public class Exercicio {
	

	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String repeticoes;
	@Size(min=1 , message="Preencher Campo")
	private Long idExerciciosDias;
	private Long idExerciciosCatalogos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRepeticoes() {
		return repeticoes;
	}
	public void setRepeticoes(String identificacao) {
		this.repeticoes = identificacao;
	}
	public Long getIdExerciciosDias() {
		return idExerciciosDias;
	}
	public void setIdExerciciosDias(Long idExerciciosDias) {
		this.idExerciciosDias = idExerciciosDias;
	}
	public Long getIdExerciciosCatalogos() {
		return idExerciciosCatalogos;
	}
	public void setIdExerciciosCatalogos(Long idExerciciosCatalogos) {
		this.idExerciciosCatalogos = idExerciciosCatalogos;
	}



}
