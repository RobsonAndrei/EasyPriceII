package carlos.robson.easyprice.Controle;

import java.util.ArrayList;
import java.util.List;

import carlos.robson.easyprice.Dominio.Produto;
import carlos.robson.easyprice.Persistencia.ProdutoDAO;
import carlos.robson.easyprice.Persistencia.ProdutoDAODTO;
import carlos.robson.easyprice.Persistencia.ProdutoDTO;

public class BuscaController {

    private ProdutoDAO produtoDAO;

    public BuscaController() {
        produtoDAO = new ProdutoDAODTO();
    }

    /**
     * Método que busca produtos através do nome
     * @param nome do produto a ser buscado
     * @return produtos que conténham o nome informado
     * @throws Exception
     */
    List<Produto> buscarProdutosPorNome(String nome) throws Exception {
        List<ProdutoDTO> resultado = produtoDAO.buscarPorNome(nome);

        List<Produto> produtos =  renderizarResultado(resultado);

        return produtos;
    }

    /**
     * Método que busca produtos de acordo com a sua categoria
     * @param codigoCategoria código da categoria usado como filtro
     * @return produtos pertencentes a categoria informado
     * @throws Exception
     */
    List<Produto> buscarProdutosPorCategoria(int codigoCategoria) throws Exception{
        List<ProdutoDTO> resultado = produtoDAO.buscarPorCategoria(codigoCategoria);

        List<Produto> produtos =  renderizarResultado(resultado);

        return produtos;
    }

    /**
     * Método que busca produtos de acordo com o preço informado
     * @param preco pretendido na busca
     * @return produtos que estejam no preco informado
     * @throws Exception
     */
    List<Produto> buscarProdutosPorPreco(double preco) throws Exception{
        List<ProdutoDTO> resultado = produtoDAO.buscarPorPreco(preco);

        List<Produto> produtos =  renderizarResultado(resultado);

        return produtos;
    }

    /**
     * Método privado que renderiza os resultados após a busca no banco de dados
     * @param produtos
     * @return
     */
    private List<Produto> renderizarResultado(List<ProdutoDTO> produtos){
        List<Produto> renderizada = new ArrayList<>();

        for (ProdutoDTO produto: produtos) {
            renderizada.add(converterParaProduto(produto));
        }
        return renderizada;
    }

    private Produto converterParaProduto(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getNome(), produtoDTO.getCpf(), produtoDTO.getIdProduto(), produtoDTO.getIdSupermercado(), produtoDTO.getIdCategoria(), produtoDTO.getPreco(), produtoDTO.getUltAtualizacao(), produtoDTO.getValidade());
    }
}
