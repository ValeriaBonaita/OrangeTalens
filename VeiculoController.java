package com.vb.controleveiculosclientes.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vb.controleveiculosclientes.domain.model.Veiculo;
import com.vb.controleveiculosclientes.domain.repository.VeiculoRepository;
import com.vb.controleveiculosclientes.domain.service.CadastroVeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

@Autowired
private VeiculoRepository veiculoRepository;

@Autowired
private CadastroVeiculoService cadastroVeiculo;

@GetMapping
public List<Veiculo> listar(){
 return veiculoRepository.findAll();
}	

@GetMapping("/{veiculoId}")
public	ResponseEntity<Veiculo> buscar(@PathVariable Long veiculoId) {
	Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
	
	if(veiculo.isPresent()) {
		return ResponseEntity.ok(veiculo.get());
	}
	return ResponseEntity.notFound().build();
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Veiculo adicionar (@Valid @RequestBody Veiculo veiculo) {
	return cadastroVeiculo.salvar(veiculo);
}

@PutMapping("/{veiculoId}")
public ResponseEntity<Veiculo> atualizar(@Valid @PathVariable Long veiculoId,
		@RequestBody Veiculo veiculo){
	
	if(!veiculoRepository.existsById(veiculoId)) {
		return ResponseEntity.notFound().build();
	}
	
	veiculo.setVeiculoId(veiculoId);
	veiculo = cadastroVeiculo.salvar(veiculo);
	
	return ResponseEntity.ok(veiculo);
}

public ResponseEntity<Void> remover (@PathVariable Long veiculoId){
	if(!veiculoRepository.existsById(veiculoId)) {
		return ResponseEntity.notFound().build();	
	}
	
	cadastroVeiculo.excluir(veiculoId);
	return ResponseEntity.noContent().build();
}

	
}
