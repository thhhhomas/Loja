package br.com.digitaldevilsaga.dto;

import br.com.digitaldevilsaga.model.entity.Categoria;

public class CategoriaDto {
    private Categoria categoria;
    private String imagem;

    public CategoriaDto(Categoria categoria, String imagem){
        this.categoria = categoria;
        this.imagem = imagem;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public String getImagem(){
        return imagem;
    }
}
