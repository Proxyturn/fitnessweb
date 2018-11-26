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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFim;
	private Long status;
	private Long idTreinoUsuario;
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
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getIdTreinoUsuario() {
		return idTreinoUsuario;
	}
	public void setIdTreinoUsuario(Long idTreinoUsuario) {
		this.idTreinoUsuario = idTreinoUsuario;
	}


}
