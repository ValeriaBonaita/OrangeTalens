package com.vb.controleveiculosclientes.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Controle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long controleId;
	private Cliente clienteId;
	private Veiculo veiculoId;
	private Cliente nome;
	
	public Long getControleId() {
		return controleId;
	}
	
	public void setControleId(Long controleId) {
		this.controleId = controleId;
	}
	public Cliente getClienteId() {
		return clienteId;
	}
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	public Veiculo getVeiculoId() {
		return veiculoId;
	}
	public void setVeiculoId(Veiculo veiculoId) {
		this.veiculoId = veiculoId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controleId == null) ? 0 : controleId.hashCode());
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
		Controle other = (Controle) obj;
		if (controleId == null) {
			if (other.controleId != null)
				return false;
		} else if (!controleId.equals(other.controleId))
			return false;
		return true;
	}

	
}
