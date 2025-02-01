package com.mktech.mklog.domain.service;

import java.time.OffsetDateTime;

import com.mktech.mklog.domain.model.Cliente;
import com.mktech.mklog.domain.model.Entrega;
import com.mktech.mklog.domain.model.StatusEntrega;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mktech.mklog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
}
