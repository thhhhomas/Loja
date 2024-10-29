package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.model.repository.CategoriaRepository;

import br.com.digitaldevilsaga.dto.CategoriaDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import java.util.List;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.Optional;
import br.com.digitaldevilsaga.dto.NovaCategoriaDto;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaByDescricao(String desc){
        Categoria categoria = categoriaRepository.findByDescricao(desc);

        return categoria;
    }

    public Categoria getCategoriaById(Integer id){
        return categoriaRepository.findById(id).get();
    }

    public Long contarBrinquedosById(Integer id){
        return categoriaRepository.countBrinquedosByCategoriaId(id);
    }

    public void salvarCategoria(NovaCategoriaDto novaCategoria){
        Categoria categoria = new Categoria();

        categoria.setDescricao(novaCategoria.getDescricao());
    }
}
