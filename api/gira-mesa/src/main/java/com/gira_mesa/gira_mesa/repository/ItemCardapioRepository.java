package com.gira_mesa.gira_mesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gira_mesa.gira_mesa.model.ItemCardapio;

@Repository
public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long>{

}
