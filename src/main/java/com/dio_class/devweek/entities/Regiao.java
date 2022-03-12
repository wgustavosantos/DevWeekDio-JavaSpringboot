package com.dio_class.devweek.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	private String regiao;
	private Integer total_exames;

	public Regiao() {
	}

	public Regiao(Long id, String regiao, Integer total_exames) {
		this.id = id;
		this.regiao = regiao;
		this.total_exames = total_exames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Integer getTotal_exames() {
		return total_exames;
	}

	public void setTotal_exames(Integer total_exames) {
		this.total_exames = total_exames;
	}

}
