package br.com.digitaldevilsaga.dto;

public class NovoAdministradorDto {

    private String nome;
    private String senha;

    public NovoAdministradorDto(){}

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }
}
