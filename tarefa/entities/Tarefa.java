package com.tarefa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarefa")
public
class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@NotBlank
	@Column(name = "dataFinalExecucao")
	private String dataFinalExecucao;
	
	@NotNull
	@NotBlank
	@Column(name = "descricaoTarefa")
	private String descricaoTarefa;
	
	@NotNull
	@NotBlank
	@Column(name = "statusTarefa")
	private String statusTarefa;
	
}

