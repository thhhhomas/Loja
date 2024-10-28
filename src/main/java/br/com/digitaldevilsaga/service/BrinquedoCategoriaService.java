package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.service.BrinquedoService;
import br.com.digitaldevilsaga.service.CategoriaService;

import java.util.List;
import java.util.Base64;
import java.util.stream.Collectors;
import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.dto.CategoriaDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.model.repository.CategoriaRepository;
import br.com.digitaldevilsaga.dto.NovoBrinquedoDto;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BrinquedoCategoriaService {

    private final BrinquedoService brinquedoService;
    private final CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    public BrinquedoCategoriaService(BrinquedoService brinquedoService, CategoriaService categoriaService){
        this.brinquedoService = brinquedoService;
        this.categoriaService = categoriaService;
    }

    public List<BrinquedoDto> listarBrinquedoByCategoriaDescricao(String desc){
        List<Brinquedo> brinquedos = brinquedoService.listarBrinquedosByCategoria(categoriaService.getCategoriaByDescricao(desc));

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        return brinquedosComImagens;
    }

    public CategoriaDto getCategoriaById(Integer id){
        Categoria categoria = categoriaService.getCategoriaById(id);
        String imagemBase64 = Base64.getEncoder().encodeToString(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()).getImagem());

        return new CategoriaDto(categoria, imagemBase64);
    }

    public List<CategoriaDto> listarCategorias(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        List<CategoriaDto> categoriasComImagens = categorias.stream().map(categoria -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()).getImagem());
        
            return new CategoriaDto(categoria, imagemBase64);
        }).collect(Collectors.toList());
        return categoriasComImagens;
    }

    public void salvarBrinquedo(NovoBrinquedoDto novoBrinquedoDto){
        Brinquedo brinquedo = new Brinquedo();

        brinquedo.setCategoria(categoriaService.getCategoriaById(novoBrinquedoDto.getIdCategoria()));
        brinquedo.setNome(novoBrinquedoDto.getNome());
        brinquedo.setDescricao(novoBrinquedoDto.getDescricao());
        brinquedo.setPreco(novoBrinquedoDto.getPreco());
        try{
            brinquedo.setImagem(novoBrinquedoDto.getImagem().getBytes());
        } catch(Exception e){
            e.printStackTrace();
        }

        brinquedoService.salvarBrinquedo(brinquedo);
    }
}
