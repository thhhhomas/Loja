package br.com.digitaldevilsaga.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="descricao", nullable=false)
    private String descricao;
    
    @Column(name="preco", nullable=false)
    private double preco;

    @Lob
    @Column(name="imagem", columnDefinition = "MEDIUMBLOB")
    private byte[] imagem;

    public Brinquedo(){}

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

    public void setIdCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    public Categoria getIdCategoria(){
        return categoria;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }
}
