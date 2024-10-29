package br.com.digitaldevilsaga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Query;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer>{
    
    Brinquedo findByNome(String nome);

    List<Brinquedo> findByNomeStartsWith(String nome);

    List<Brinquedo> findByNomeEndsWith(String nome);

    List<Brinquedo> findByNomeContains(String nome);

    List<Brinquedo> findByCategoria(Categoria categoria);

    @Query(value = "SELECT * FROM brinquedo WHERE id_categoria = :idCategoria  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Brinquedo brinquedoAleatorioByIdCategoria(@Param("idCategoria") int idCategoria);
}
