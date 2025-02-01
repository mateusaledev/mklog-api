package com.mktech.mklog.domain.service;

import com.mktech.mklog.domain.model.Entrega;
import org.springframework.stereotype.Service;

import com.mktech.mklog.domain.exception.EntidadeNaoEncontradaException;
import com.mktech.mklog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
