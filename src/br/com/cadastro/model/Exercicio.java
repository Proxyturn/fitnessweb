package br.com.cadastro.model;

public class Exercicio {
	

	private Long id;
	private String repeticoes;
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
	public void setRepeticoes(String repeticoes) {
		this.repeticoes = repeticoes;
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
