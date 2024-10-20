package br.com.digitaldevilsaga.dto;

import br.com.digitaldevilsaga.model.entity.Brinquedo;

public class BrinquedoDto {
    private Brinquedo brinquedo;
    private String imagemBase64;

    public BrinquedoDto(Brinquedo brinquedo, String imagemBase64){
        this.brinquedo = brinquedo;
        this.imagemBase64 = imagemBase64;
    }

    public Brinquedo getBrinquedo(){
        return brinquedo;
    }
    
    public String getImagemBase64(){
        return imagemBase64;
    }
}
