package com.dio_class.devweek.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FaixaEtaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	private Integer Faixa_i;
	private Integer Faixa_n;
	private String Descricao;

	public FaixaEtaria() {
	}

	public FaixaEtaria(Long id, Integer faixa_i, Integer faixa_n, String descricao) {
		this.id = id;
		Faixa_i = faixa_i;
		Faixa_n = faixa_n;
		Descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFaixa_i() {
		return Faixa_i;
	}

	public void setFaixa_i(Integer faixa_i) {
		Faixa_i = faixa_i;
	}

	public Integer getFaixa_n() {
		return Faixa_n;
	}

	public void setFaixa_n(Integer faixa_n) {
		Faixa_n = faixa_n;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

}
