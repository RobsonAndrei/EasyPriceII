package carlos.robson.easyprice.Dominio;

public class Categoria {

    private int idCategoria;
    private String nomeCategoria;

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria(){
        return this.idCategoria;
    }

    public String getNomeCategoria(){
        return this.nomeCategoria;
    }

    public void setIdCategoria(int codigoCategoria){
        this.idCategoria     = codigoCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
