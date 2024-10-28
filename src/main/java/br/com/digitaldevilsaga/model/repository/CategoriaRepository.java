package br.com.digitaldevilsaga.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitaldevilsaga.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    Categoria findByDescricao(String descricao);
}
