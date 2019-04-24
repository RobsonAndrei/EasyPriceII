package carlos.robson.easyprice.Dominio;

import java.sql.Date;

public class Produto {

    private String nome;
    private long cpf;
    private int idProduto;
    private int idSupermercado;
    private int idCategoria;
    private double preco;
    private Date ultAtualizacao;

    public Produto(String nome, long cpf, int idProduto, int idSupermercado, int idCategoria, double preco, Date ultAtualizacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idProduto = idProduto;
        this.idSupermercado = idSupermercado;
        this.idCategoria = idCategoria;
        this.preco = preco;
        this.ultAtualizacao = ultAtualizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(int idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getUltAtualizacao() {
        return ultAtualizacao;
    }

    public void setUltAtualizacao(Date ultAtualizacao) {
        this.ultAtualizacao = ultAtualizacao;
    }
}
