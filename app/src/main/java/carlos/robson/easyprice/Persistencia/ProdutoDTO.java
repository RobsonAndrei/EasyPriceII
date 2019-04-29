package carlos.robson.easyprice.Persistencia;

import java.sql.Date;

public class ProdutoDTO {

    private String nome;
    private String cpf;
    private int idProduto;
    private int idSupermercado;
    private int idCategoria;
    private double preco;
    private Date ultAtualizacao;
    private Date validade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public Date getValidade() { return validade; }

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

    public void setValidade(Date validade) { this.validade = validade;  }
}
