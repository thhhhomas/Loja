package br.com.digitaldevilsaga.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="brinquedo")
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @Column(name="nome", nullable=true)
    private String nome;

    @Column(name="descricao", nullable=true)
    private String descricao;
    
    @Column(name="preco", nullable=true, precision=10, scale=2)
    private BigDecimal preco;

    @Lob
    @Column(name="imagem", columnDefinition = "LONGBLOB")
    private byte[] imagem;

    public Brinquedo(){}

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setImagem(byte[] imagem){
        this.imagem = imagem;
    }

    public byte[] getImagem(){
        return imagem;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    public Categoria getCategoria(){
        return categoria;
    }

    public void setPreco(BigDecimal preco){
        this.preco = preco;
    }

    public BigDecimal getPreco(){
        return preco;
    }
}
