package com.pogeku.estabelecimento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estabelecimento")
public class Estabelecimento {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@Column(unique = true)
	private String cnpj;

	private String endereço;

	private String telefone;

	private int vagasMotos;

	private int vagasCarros;
}
