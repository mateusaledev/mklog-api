package com.mktech.mklog.domain.service;

import com.mktech.mklog.domain.model.Entrega;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mktech.mklog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
	
}
