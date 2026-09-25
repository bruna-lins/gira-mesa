package com.gira_mesa.gira_mesa.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:5173")
public class HealthController {
	
	private final DataSource dataSource;
	
	public HealthController(DataSource dataSource) { 
		this.dataSource = dataSource;
	}

	@GetMapping("/api/health")
	public ResponseEntity<String> health() { 
		boolean bancoConectado = testarConexao();
		
		String mensagem = bancoConectado ? "200 - OK: Conexão ativa." : "503 - Conexão Indisponível.";
		
		HttpStatus status = bancoConectado ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;
		
		return ResponseEntity.status(status).body(mensagem);
	}
	
	private boolean testarConexao() { 
		try (Connection conexao = dataSource.getConnection()) { 
			return conexao.isValid(2);
		} catch (SQLException erro) { 
			return false;
		}
	}
	
}
