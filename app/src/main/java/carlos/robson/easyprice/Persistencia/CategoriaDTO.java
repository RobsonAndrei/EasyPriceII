package carlos.robson.easyprice.Persistencia;

public class CategoriaDTO {

    private int idCategoria;
    private String nomeCategoria;

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
