package com.pogeku.veiculo.mapper;

import org.springframework.stereotype.Service;

import com.pogeku.veiculo.model.Veiculo;
import com.pogeku.veiculo.request.VeiculoRequest;
import com.pogeku.veiculo.request.VeiculoResponse;

@Service
public class VeiculoMapper {

	public Veiculo toVeiculo(VeiculoRequest request) {
		if(request == null) {
			return null;
		}
		
		return Veiculo.builder()
				.marca(request.marca())
				.modelo(request.modelo())
				.cor(request.cor())
				.placa(request.placa())
				.tipo(request.tipo())
				.build();
	}
	
	public VeiculoResponse fromVeiculo(Veiculo request) {
		return new VeiculoResponse(
				request.getMarca(),
				request.getModelo(),
				request.getCor(),
				request.getPlaca(),
				request.getPlaca()
				);
	}
	
	public void mergeVeiculo(Veiculo vei, VeiculoRequest request) {
		vei.setMarca(request.marca());
		vei.setModelo(request.modelo());
		vei.setCor(request.cor());
		vei.setPlaca(request.placa());
		vei.setTipo(request.tipo());
	}
}
