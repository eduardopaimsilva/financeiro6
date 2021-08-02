package br.com.financeiro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "financeiro")
public class Financeiro {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "indicador")
	private String indicador;
	@Column
	private String data;
	@Column
	private String datareferencia;
	@Column
	private String media;
	@Column
	private String mediana;
	@Column
	private String desviopadrao;
	@Column
	private String coeficientevariacao;
	@Column
	private String minimo;
	@Column
	private String maximo;
	@Column
	private String numerorespondentes;
	@Column
	private String basecalculo;

	
	}