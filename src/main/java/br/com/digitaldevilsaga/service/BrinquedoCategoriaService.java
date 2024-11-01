package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Base64;
import java.util.stream.Collectors;
import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.dto.CategoriaDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.dto.NovoBrinquedoDto;
import br.com.digitaldevilsaga.dto.BrinquedoAtualizadoDto;

@Service
public class BrinquedoCategoriaService {

    private final BrinquedoService brinquedoService;
    private final CategoriaService categoriaService;
    private final ImagemService imagemService;

    @Autowired
    public BrinquedoCategoriaService(BrinquedoService brinquedoService, CategoriaService categoriaService, ImagemService imagemService){
        this.brinquedoService = brinquedoService;
        this.categoriaService = categoriaService;
        this.imagemService = imagemService;
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
        Long quantidadeBrinquedos = categoriaService.contarBrinquedosById(categoria.getId());
        return new CategoriaDto(categoria, imagemBase64, quantidadeBrinquedos);
    }

    public List<CategoriaDto> listarCategorias(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        List<CategoriaDto> categoriasComImagens = categorias.stream().map(categoria -> {
            String imagemBase64 = "";
            if(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()) == null){
                try{
                    imagemBase64 = imagemService.imagemPadraoBase64();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                imagemBase64 = Base64.getEncoder().encodeToString(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()).getImagem());
            }
            Long quantidadebrinquedos = categoriaService.contarBrinquedosById(categoria.getId());
            return new CategoriaDto(categoria, imagemBase64, quantidadebrinquedos);
        }).collect(Collectors.toList());
        return categoriasComImagens;
    }

    public List<CategoriaDto> listarCategorias(String pesquisa){
        List<Categoria> categorias = categoriaService.listaCategorias(pesquisa);
        List<CategoriaDto> categoriasComImagens = categorias.stream().map(categoria -> {
            String imagemBase64 = "";
            if(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()) == null){
                try{
                    imagemBase64 = imagemService.imagemPadraoBase64();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                imagemBase64 = Base64.getEncoder().encodeToString(brinquedoService.randomBrinquedoByCategoriaId(categoria.getId()).getImagem());
            }
            Long quantidadebrinquedos = categoriaService.contarBrinquedosById(categoria.getId());
            return new CategoriaDto(categoria, imagemBase64, quantidadebrinquedos);
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

    public void atualizarBrinquedo(BrinquedoAtualizadoDto brinquedoAtualizadoDto){
        Brinquedo brinquedo = brinquedoService.getBrinquedoByIdSemImagem(brinquedoAtualizadoDto.getId());

        brinquedo.setCategoria(categoriaService.getCategoriaById(brinquedoAtualizadoDto.getIdCategoria()));
        brinquedo.setNome(brinquedoAtualizadoDto.getNome());
        brinquedo.setDescricao(brinquedoAtualizadoDto.getDescricao());
        brinquedo.setPreco(brinquedoAtualizadoDto.getPreco());
        if(!brinquedoAtualizadoDto.getImagem().isEmpty()){
            try{
                brinquedo.setImagem(brinquedoAtualizadoDto.getImagem().getBytes());
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        brinquedoService.salvarBrinquedo(brinquedo);
    }
}
