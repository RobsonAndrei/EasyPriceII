package carlos.robson.easyprice.Dominio;

public class Categoria {

    private int idCategoria;
    private String nomeCategoria;

    public int getCodigoCategoria(){
        return this.idCategoria;
    }

    public String getNomeCategoria(){
        return this.nomeCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria){
        this.idCategoria = codigoCategoria;
    }
}
