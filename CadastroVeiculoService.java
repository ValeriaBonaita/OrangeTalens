package com.vb.controleveiculosclientes.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.controleveiculosclientes.domain.exception.NegocioException;
import com.vb.controleveiculosclientes.domain.model.Veiculo;
import com.vb.controleveiculosclientes.domain.repository.VeiculoRepository;

@Service
public class CadastroVeiculoService {

	
@Autowired
private VeiculoRepository veiculoRepository;

public Veiculo salvar(Veiculo veiculo) {
	Optional<Veiculo> veiculoExistente =  veiculoRepository.findById(veiculo.getVeiculoId());
	if(veiculoExistente != null && !veiculoExistente.equals(veiculo) ) {
		throw new NegocioException ("ja existe um veiculo com estes dados. Verifique");
	}
	
	return veiculoRepository.save(veiculo);
}

public void excluir(Long veiculoId) {
	veiculoRepository.deleteById(veiculoId);
}

}