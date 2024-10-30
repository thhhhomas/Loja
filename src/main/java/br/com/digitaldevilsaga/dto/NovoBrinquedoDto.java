package br.com.digitaldevilsaga.dto;
import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class NovoBrinquedoDto{

    private String nome;
    private String descricao;
    private Integer idCategoria;
    private BigDecimal preco;
    private MultipartFile imagem;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal valor) {
        this.preco = valor;
    }

    public MultipartFile getImagem() {
        return imagem;
    }

    public void setImagem(MultipartFile imagem) {
        this.imagem = imagem;
    }
}