package carlos.robson.easyprice.Controle;

import java.sql.SQLException;
import java.util.List;

import carlos.robson.easyprice.Dominio.Produto;
import carlos.robson.easyprice.Dominio.Supermercado;
import carlos.robson.easyprice.Dominio.Usuario;

public class FachadaController {

    private CadastroController cadastro;
    private BuscaController busca;

    public FachadaController(){
        cadastro = new CadastroController();
        busca = new BuscaController();
    }

    public int cadastrarUsuario(Usuario usuario) throws Exception{
        return cadastro.cadastrarUsuario(usuario);
    }

    public int cadastrarSupermercado(Supermercado supermercado) throws Exception{
        return cadastro.cadastrarSupermercado(supermercado);
    }

    public int cadastrarProduto(Produto produto) throws Exception{
        return cadastro.cadastrarProduto(produto);
    }

    public List<Produto> buscarProdutosPorNome(String nome) throws Exception{
        return busca.buscarProdutosPorNome(nome);
    }

    public List<Produto> buscarProdutosPorCategoria(int codigoCategoria) throws Exception{
        return busca.buscarProdutosPorCategoria(codigoCategoria);
    }

    public List<Produto> buscarProdutosPorPreco(double preco) throws Exception{
        return busca.buscarProdutosPorPreco(preco);
    }
}
