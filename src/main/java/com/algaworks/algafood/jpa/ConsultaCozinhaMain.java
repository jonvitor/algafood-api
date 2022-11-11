package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

		/*
		 * cozinhaRepository.listar().stream().map(Cozinha::getNome).forEach(System.out:
		 * :println);
		 * restauranteRepository.listar().stream().map(Restaurante::getNome).forEach(
		 * System.out::println);
		 */
		for (Restaurante restaurante : restauranteRepository.listar()) {
			System.out.println(restaurante.getNome() + " || " + restaurante.getCozinha().getNome() + " || " + restaurante.getTaxaFrete());
		}
		
		for (Cidade cidade : cidadeRepository.listar()) {
			System.out.println(cidade.getNome() + " || " + cidade.getEstado().getNome());
		}

	}
}
