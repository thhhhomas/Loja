package br.com.digitaldevilsaga.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;
import br.com.digitaldevilsaga.model.repository.CategoriaRepository;

@RestController
@RequestMapping("api/brinquedo")
public class BrinquedoDAO {
    
    @Autowired
    private BrinquedoRepository repository;

    @Autowired
    private CategoriaRepository repositoryCategoria;

    @GetMapping("/{id}")
    public Brinquedo getById(@PathVariable("id") Integer id){
        Brinquedo brinquedo = repository.findById(id).get();
        return brinquedo;
    }

    @PostMapping
    public Brinquedo insert(@RequestBody Brinquedo brinquedo){
        return repository.save(brinquedo);
    }

    @PutMapping("/{id}")
    public Brinquedo update(@RequestBody Brinquedo brinquedo, @PathVariable Integer id){
        Brinquedo brinquedoUpdate = repository.findById(id).get();
        brinquedoUpdate.setNome(brinquedo.getNome());
        brinquedoUpdate.setIdCategoria(brinquedo.getIdCategoria());
        brinquedoUpdate.setDescricao(brinquedo.getDescricao());
        brinquedoUpdate.setImagem(brinquedo.getImagem());
        repository.save(brinquedoUpdate);

        return brinquedoUpdate;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        repository.deleteById(id);
        return "Brinquedo excluído";
    }

    @GetMapping("/nome/{nome}")
    public Brinquedo getByNome(@PathVariable String nome){
        Brinquedo brinquedo = repository.findByNome(nome);
        return brinquedo;
    }

    @GetMapping("/pesquisa1/{pesquisa}")
    public List<Brinquedo> getByPesquisaInicio(@PathVariable String pesquisa){
        List<Brinquedo> resultado = repository.findByNomeStartsWith(pesquisa);
        return resultado;
    }

    @GetMapping("/pesquisa2/{pesquisa}")
    public List<Brinquedo> getByPesquisaFim(@PathVariable String pesquisa){
        List<Brinquedo> resultado = repository.findByNomeEndsWith(pesquisa);
        return resultado;
    }

    @GetMapping("/pesquisa/{pesquisa}")
    public List<Brinquedo> getByPesquisa(@PathVariable String pesquisa){
        List<Brinquedo> resultado = repository.findByNomeContains(pesquisa);
        return resultado;
    }

    @GetMapping
    public List<Brinquedo> listAll(){
        List<Brinquedo> brinquedos = repository.findAll();
        return brinquedos;
    }

    @GetMapping("/pesquisa/categoria/{descricao}")
    public List<Brinquedo> listAllPorCategoria(@PathVariable String descricao){
        Categoria categoria = repositoryCategoria.findByDescricao(descricao);

        List<Brinquedo> brinquedos = repository.findByCategoria(categoria);

        return brinquedos;
    }
}