package br.com.digitaldevilsaga.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Integer>{
    
    Brinquedo findByNome(String nome);

    List<Brinquedo> findByNomeStartsWith(String nome);

    List<Brinquedo> findByNomeEndsWith(String nome);

    List<Brinquedo> findByNomeContains(String nome);

    List<Brinquedo> findByCategoria(Categoria categoria);
}
