package br.com.digitaldevilsaga.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name="descricao", nullable=false)
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade=CascadeType.ALL)
    private List<Brinquedo> brinquedos;

    public Categoria(){}

    public void setId(int idCategoria){
        this.idCategoria = idCategoria;
    }

    public int getId(){
        return idCategoria;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setBrinquedos(List<Brinquedo> brinquedos){
        this.brinquedos = brinquedos;
    }

    public List<Brinquedo> getBrinquedos(){
        return brinquedos;
    }
}
