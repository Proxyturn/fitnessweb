package br.com.cadastro.model;

import javax.validation.constraints.Size;

public class Catalogo {
	

	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String identificacao;
	@Size(min=1 , message="Preencher Campo")
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
