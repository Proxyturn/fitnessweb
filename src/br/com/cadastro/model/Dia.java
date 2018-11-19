package br.com.cadastro.model;

import javax.validation.constraints.Size;

public class Dia {
	

	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String identificacao;
	private Long idDiasTreino;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public Long getIdDiasTreino() {
		return idDiasTreino;
	}
	public void setIdDiasTreino(Long idDiasTreino) {
		this.idDiasTreino = idDiasTreino;
	}
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

}
