package com.mktech.mklog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.mktech.mklog.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mktech.mklog.api.model.EntregaModel;
import com.mktech.mklog.api.model.input.EntregaInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
}
