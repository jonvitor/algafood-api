package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		Cozinha cozinha = cozinhaRepository.buscar(1L);
		Restaurante restaurante = restauranteRepository.buscar(1L);
		FormaPagamento formaPagamento = new FormaPagamento();
		
		//formaPagamento.setId(4L);
		formaPagamento.setDescricao("Na Entrega");
		formaPagamentoRepository.salvar(formaPagamento);
		formaPagamentoRepository.remover(formaPagamentoRepository.buscar(2L));
		
		for (FormaPagamento formaPagamento2 : formaPagamentoRepository.listar()) {
			System.out.println(formaPagamento2.getDescricao());
		}
		
		System.out.println(cozinha.getNome() + " || " + restaurante.getNome() + " || " + formaPagamento.getDescricao());
	}
}
