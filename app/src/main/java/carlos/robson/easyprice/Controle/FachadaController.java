package carlos.robson.easyprice.Controle;

import java.sql.SQLException;

import carlos.robson.easyprice.Dominio.Produto;
import carlos.robson.easyprice.Dominio.Supermercado;
import carlos.robson.easyprice.Dominio.Usuario;

public class FachadaController {

    private CadastroController cadastro;

    public int cadastrarUsuario(Usuario usuario) throws Exception{
        return cadastro.cadastrarUsuario(usuario);
    }

    public int cadastrarSupermercado(Supermercado supermercado) throws Exception{
        return cadastro.cadastrarSupermercado(supermercado);
    }

    public int cadastrarProduto(Produto produto) throws Exception{
        return cadastro.cadastrarProduto(produto);
    }
}
