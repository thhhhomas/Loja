package br.com.digitaldevilsaga.dto;

import br.com.digitaldevilsaga.model.entity.Categoria;

public class CategoriaDto {
    private Categoria categoria;
    private String imagem;
    private Long quantidadeBrinquedos;

    public CategoriaDto(Categoria categoria, String imagem, Long quantidadeBrinquedos){
        this.categoria = categoria;
        this.imagem = imagem;
        this.quantidadeBrinquedos = quantidadeBrinquedos;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public String getImagem(){
        return imagem;
    }

    public Long getQuantidadeBrinquedos(){
        return quantidadeBrinquedos;
    }
}
