package br.com.digitaldevilsaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.digitaldevilsaga.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    Categoria findByDescricao(String descricao);

    @Query("SELECT COUNT(b) FROM Brinquedo b WHERE b.categoria.id = :idCategoria")
    Long countBrinquedosByCategoriaId(@Param("idCategoria") Integer idCategoria);
}
