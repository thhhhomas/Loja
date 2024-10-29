package br.com.digitaldevilsaga.dto;
import org.springframework.web.multipart.MultipartFile;

public class BrinquedoAtualizadoDto {
    private int id;
    private String nome;
    private String descricao;
    private Integer idCategoria;
    private double preco;
    private MultipartFile imagem;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double valor) {
        this.preco = valor;
    }

    public MultipartFile getImagem() {
        return imagem;
    }

    public void setImagem(MultipartFile imagem) {
        this.imagem = imagem;
    }
}
