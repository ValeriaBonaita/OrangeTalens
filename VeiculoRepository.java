package com.vb.controleveiculosclientes.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.controleveiculosclientes.domain.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	List<Veiculo> findByMarca(String marca);
	//List<Veiculo> findById(Long veiculoId);
}
