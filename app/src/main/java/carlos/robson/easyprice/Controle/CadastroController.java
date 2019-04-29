package carlos.robson.easyprice.Controle;

import android.content.SearchRecentSuggestionsProvider;

import carlos.robson.easyprice.Dominio.Categoria;
import carlos.robson.easyprice.Dominio.Produto;
import carlos.robson.easyprice.Dominio.Supermercado;
import carlos.robson.easyprice.Dominio.Usuario;
import carlos.robson.easyprice.Persistencia.CategoriaDAO;
import carlos.robson.easyprice.Persistencia.CategoriaDAODTO;
import carlos.robson.easyprice.Persistencia.CategoriaDTO;
import carlos.robson.easyprice.Persistencia.ProdutoDAO;
import carlos.robson.easyprice.Persistencia.ProdutoDTO;
import carlos.robson.easyprice.Persistencia.SupermercadoDAO;
import carlos.robson.easyprice.Persistencia.SupermercadoDAODTO;
import carlos.robson.easyprice.Persistencia.SupermercadoDTO;
import carlos.robson.easyprice.Persistencia.UsuarioDAO;
import carlos.robson.easyprice.Persistencia.UsuarioDAODTO;
import carlos.robson.easyprice.Persistencia.UsuarioDTO;

/**
 * Classe que terá os métodos de cadastro para todos os objetos
 */
public class CadastroController {

    private UsuarioDAO usuarioDAO;
    private SupermercadoDAO supermercadoDAO;
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    public CadastroController(){
         usuarioDAO = new UsuarioDAODTO();
         supermercadoDAO = new SupermercadoDAODTO();
         categoriaDAO = new CategoriaDAODTO();
    }

    int cadastrarUsuario(Usuario usuario) throws Exception {
        UsuarioDTO usuarioDTO = converterParaUsuarioDTO(usuario);
        return usuarioDAO.incluir(usuarioDTO);
    }

    int cadastrarSupermercado(Supermercado supermercado) throws Exception {
        SupermercadoDTO supermercadoDTO = converterParaSupermercadoDTO(supermercado);
        return supermercadoDAO.incluir(supermercadoDTO);
    }

    int cadastrarProduto(Produto produto) throws Exception {
        ProdutoDTO produtoDTO = converterParaProdutoDTO(produto);
        return produtoDAO.incluir(produtoDTO);
    }

    int cadastrarCategoria(Categoria categoria) throws Exception{
        CategoriaDTO categoriaDTO = converterParaCategoriaDTO(categoria);
        return categoriaDAO.incluir(categoriaDTO);
    }

    private Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getCpf(), usuarioDTO.getNome(), usuarioDTO.getLogin(), usuarioDTO.getSenha(), usuarioDTO.getIdade(), usuarioDTO.getSalario());
    }

    private Supermercado converterParaSupermercado(SupermercadoDTO supermercadoDTO) {
        return new Supermercado(supermercadoDTO.getIdSupermercado(), supermercadoDTO.getLatitude(), supermercadoDTO.getLongitude(), supermercadoDTO.getTelefone(), supermercadoDTO.getCpf(), supermercadoDTO.getNome());
    }

    private Produto converterParaProduto(ProdutoDTO produtoDTO){
        return new Produto(produtoDTO.getNome(), produtoDTO.getCpf(), produtoDTO.getIdProduto(), produtoDTO.getIdSupermercado(), produtoDTO.getIdCategoria(), produtoDTO.getPreco(), produtoDTO.getUltAtualizacao(), produtoDTO.getValidade());
    }

    private Categoria converterParaCategoria(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO.getIdCategoria(), categoriaDTO.getNomeCategoria());
    }

    private UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setLogin(usuario.getLogin());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setIdade(usuario.getIdade());
        usuarioDTO.setSalario(usuario.getSalario());

        return usuarioDTO;
    }

    private SupermercadoDTO converterParaSupermercadoDTO(Supermercado supermercado) {
        SupermercadoDTO supermercadoDTO = new SupermercadoDTO();

        supermercadoDTO.setLatitude(supermercado.getLatitude());
        supermercadoDTO.setLongitude(supermercado.getLongitude());
        supermercadoDTO.setTelefone(supermercado.getTelefone());
        supermercadoDTO.setCpf(supermercado.getCpf());
        supermercadoDTO.setNome(supermercado.getNome());

        return supermercadoDTO;
    }

    private ProdutoDTO converterParaProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setNome(produto.getNome());
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setIdSupermercado(produto.getIdSupermercado());
        produtoDTO.setIdCategoria(produto.getIdCategoria());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setUltAtualizacao(produto.getUltAtualizacao());
        produtoDTO.setValidade(produto.getValidade());

        return produtoDTO;
    }

    private CategoriaDTO converterParaCategoriaDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        categoriaDTO.setNomeCategoria(categoria.getNomeCategoria());

        return categoriaDTO;
    }
}
