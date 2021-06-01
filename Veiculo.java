package com.vb.controleveiculosclientes.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Veiculo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long veiculoId;
	
	@Size(max = 20)
	@NotBlank
	private String marca;
	
	@NotBlank
	@NotNull
	@Size(max = 20)
	private String modelo;
	
	@NotBlank
	@Size(max = 4)
	private String ano;


	public Long getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veiculoId == null) ? 0 : veiculoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (veiculoId == null) {
			if (other.veiculoId != null)
				return false;
		} else if (!veiculoId.equals(other.veiculoId))
			return false;
		return true;
	}


	
}
