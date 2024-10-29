package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.repository.CategoriaRepository;

import java.util.List;

import br.com.digitaldevilsaga.dto.CategoriaAtualizadaDto;
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

        categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }

    public void atualizarcategoria(CategoriaAtualizadaDto categoriaAtualizadaDto){
        Categoria categoria = this.getCategoriaById(categoriaAtualizadaDto.getId());

        categoria.setDescricao(categoriaAtualizadaDto.getDescricao());

        categoriaRepository.save(categoria);
    }
}
