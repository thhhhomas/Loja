package br.com.digitaldevilsaga.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.dto.BrinquedoDto;
import br.com.digitaldevilsaga.model.entity.Brinquedo;
import br.com.digitaldevilsaga.model.entity.Categoria;
import br.com.digitaldevilsaga.model.repository.BrinquedoRepository;

@Service
public class BrinquedoService {
    @Autowired
    private BrinquedoRepository brinquedoRepository;

    public List<BrinquedoDto> listarBrinquedos(){

        List<Brinquedo> brinquedos = brinquedoRepository.findAll();

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        return brinquedosComImagens;
    }

    public List<BrinquedoDto> listarBrinquedos(String pesquisa){

        List<Brinquedo> brinquedos = brinquedoRepository.findByNomeContains(pesquisa);

        List<BrinquedoDto> brinquedosComImagens = brinquedos.stream().map(brinquedo -> {
            String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
            return new BrinquedoDto(brinquedo, imagemBase64);
        }).collect(Collectors.toList());

        return brinquedosComImagens;
    }

    public BrinquedoDto getBrinquedoById(Integer id){
        Brinquedo brinquedo = brinquedoRepository.findById(id).get();

        String imagemBase64 = Base64.getEncoder().encodeToString(brinquedo.getImagem());
        BrinquedoDto brinquedoDto = new BrinquedoDto(brinquedo, imagemBase64);

        return brinquedoDto;
    }

    public Brinquedo randomBrinquedoByCategoriaId(int id){
        return brinquedoRepository.brinquedoAleatorioByIdCategoria(id);
    }

    public List<Brinquedo> listarBrinquedosByCategoria(Categoria categoria){
        return brinquedoRepository.findByCategoria(categoria);
    }

    public void atualizarBrinquedo(Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
    }

    public List<Brinquedo> listarBrinquedosNoImages(){
        return brinquedoRepository.findAll();
    }

    public void salvarBrinquedo(Brinquedo brinquedo) {
        // System.out.println("Salvando o brinquedo: " + brinquedo.getDescricao());
        brinquedoRepository.save(brinquedo);
        // System.out.println("Brinquedo salvo com sucesso no banco de dados.");
    }
}
