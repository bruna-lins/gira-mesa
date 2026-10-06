package com.gira_mesa.gira_mesa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gira_mesa.gira_mesa.model.ItemCardapio;
import com.gira_mesa.gira_mesa.repository.ItemCardapioRepository;

@Service
public class ItemCardapioService {

	private final ItemCardapioRepository repository;
	
	public ItemCardapioService(ItemCardapioRepository repository) { 
		this.repository = repository;
	}
	
	public List<ItemCardapio> listarTodos() { 
		return repository.findAll();
	}
	
	public Optional<ItemCardapio> buscarPorId(Long id) { 
		return repository.findById(id);
	}
	
	public ItemCardapio criar(ItemCardapio novoItem) { 
		return repository.save(novoItem);
	}
	
	public Optional<ItemCardapio> atualizar(Long id, ItemCardapio itemAtualizado) { 
		
		if (!repository.existsById(id)) { 
			return Optional.empty();
		}
		
		itemAtualizado.setId(id);
		
		return Optional.of(repository.save(itemAtualizado));
	}
	
	public boolean apagar(Long id) { 
		
		if (!repository.existsById(id)) { 
			return false;
		}
		
		repository.deleteById(id);
		return true;
	}
}
