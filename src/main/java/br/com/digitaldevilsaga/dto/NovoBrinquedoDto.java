package br.com.digitaldevilsaga.dto;
import org.springframework.web.multipart.MultipartFile;

public class NovoBrinquedoDto{

    private String nome;
    private String descricao;
    private int idCategoria;
    private double preco;
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

    public void setNome(String descricao) {
        this.nome = nome;
    }
    // Getter e Setter para 'categoriaId'
    public int getCategoriaId() {
        return idCategoria;
    }

    public void setCategoriaId(int categoriaId) {
        this.idCategoria = idCategoria;
    }

    // Getter e Setter para 'valor'
    public double getPreco() {
        return preco;
    }

    public void setPreco(double valor) {
        this.preco = valor;
    }

    // Getter e Setter para 'imagem'
    public MultipartFile getImagem() {
        return imagem;
    }

    public void setImagem(MultipartFile imagem) {
        this.imagem = imagem;
    }
}