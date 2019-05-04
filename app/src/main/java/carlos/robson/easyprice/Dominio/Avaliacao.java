package carlos.robson.easyprice.Dominio;

import java.sql.Date;

public class Avaliacao {

    private int idAvaliacao;
    private String comentario;
    private double nota;
    private Date dataAvaliacao;
    private int idProduto;
    private int idCategoria;
    private int idSupermercado;
    private String cpf;

    public Avaliacao(int idAvaliacao, String comentario, double nota, Date dataAvaliacao, int idProduto, int idCategoria, int idSupermercado, String cpf) {
        this.idAvaliacao = idAvaliacao;
        this.comentario = comentario;
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
        this.idSupermercado = idSupermercado;
        this.cpf = cpf;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(int idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
