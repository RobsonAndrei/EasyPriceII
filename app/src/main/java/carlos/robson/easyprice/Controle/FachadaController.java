package carlos.robson.easyprice.Controle;

import java.util.List;

import carlos.robson.easyprice.Dominio.Avaliacao;
import carlos.robson.easyprice.Dominio.Produto;
import carlos.robson.easyprice.Dominio.Supermercado;
import carlos.robson.easyprice.Dominio.Usuario;

public class FachadaController {

    private CadastroController cadastroController;
    private BuscaController buscaController;
    private AvaliacaoController avaliacaoController;

    public FachadaController(){
        cadastroController = new CadastroController();
        buscaController = new BuscaController();
        avaliacaoController = new AvaliacaoController();
    }

    public int cadastrarUsuario(Usuario usuario) throws Exception{
        return cadastroController.cadastrarUsuario(usuario);
    }

    public int cadastrarSupermercado(Supermercado supermercado) throws Exception{
        return cadastroController.cadastrarSupermercado(supermercado);
    }

    public int cadastrarProduto(Produto produto) throws Exception{
        return cadastroController.cadastrarProduto(produto);
    }

    public List<Produto> buscarProdutosPorNome(String nome) throws Exception{
        return buscaController.buscarProdutosPorNome(nome);
    }

    public List<Produto> buscarProdutosPorCategoria(int codigoCategoria) throws Exception{
        return buscaController.buscarProdutosPorCategoria(codigoCategoria);
    }

    public List<Produto> buscarProdutosPorPreco(double preco) throws Exception{
        return buscaController.buscarProdutosPorPreco(preco);
    }

    public int inserirAvaliacao(Avaliacao avaliacao) throws Exception{
        return avaliacaoController.inserirAvaliacao(avaliacao);
    }
}
