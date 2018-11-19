package br.com.cadastro.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Treino {
	

	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String identificacao;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataInicio;
	@NotNull(message="Campo em Branco")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFim;
	@NotNull(message="Campo em Branco")
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
	



}
