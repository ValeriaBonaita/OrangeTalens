package com.vb.controleveiculosclientes.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.controleveiculosclientes.domain.exception.NegocioException;
import com.vb.controleveiculosclientes.domain.model.Cliente;
import com.vb.controleveiculosclientes.domain.repository.ClienteRepository;

@Service
public class CadrastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		Cliente clienteExistentecpf =clienteRepository.findByCpf(cliente.getCpf());
		
		if((clienteExistente != null && !clienteExistente.equals(cliente)) ||(clienteExistentecpf != null && !clienteExistentecpf.equals(cliente)) ) {
			throw new NegocioException ("ja existe um cliente cadastrado com estes CPF ou E-mail. Verifique");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}

