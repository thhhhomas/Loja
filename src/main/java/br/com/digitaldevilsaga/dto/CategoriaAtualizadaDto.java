package br.com.digitaldevilsaga.dto;

public class CategoriaAtualizadaDto {
    private Integer id;
    private String descricao;

    public CategoriaAtualizadaDto(){}

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
