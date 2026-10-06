package com.gira_mesa.gira_mesa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gira_mesa.gira_mesa.model.ItemCardapio;
import com.gira_mesa.gira_mesa.service.ItemCardapioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cardapio")
public class CardapioController {

	private final ItemCardapioService service;
	
	public CardapioController(ItemCardapioService service) { 
		this.service = service;
	}
	
	@GetMapping
	public List<ItemCardapio> listar() { 
		return service.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemCardapio> buscarPorId(@PathVariable Long id) { 
		Optional<ItemCardapio> item = service.buscarPorId(id);
		
		if (item.isEmpty()) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(item.get());
	}
	
	@PostMapping
	public ResponseEntity<ItemCardapio> criar(@Valid @RequestBody ItemCardapio novoItem) { 
		ItemCardapio salvo = service.criar(novoItem);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemCardapio> atualizar(@PathVariable Long id, @Valid @RequestBody ItemCardapio novoItem) { 
		
		Optional<ItemCardapio> salvo = service.atualizar(id, novoItem);
		
		if (salvo.isEmpty()) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(salvo.get());
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) { 
		boolean apagou = service.apagar(id);
		
		if(!apagou) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
}
