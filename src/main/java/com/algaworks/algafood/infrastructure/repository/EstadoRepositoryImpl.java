package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}
	
	@Transactional
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional
	public void remover(Long estadoId) {
		Estado estado = buscar(estadoId);
		
		if (estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(estado);
	}
	
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}

}