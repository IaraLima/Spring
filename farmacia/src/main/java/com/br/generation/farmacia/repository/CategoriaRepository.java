package com.br.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.generation.farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}