package carlos.robson.easyprice.Controle;

import carlos.robson.easyprice.Dominio.Supermercado;
import carlos.robson.easyprice.Dominio.Usuario;
import carlos.robson.easyprice.Persistencia.SupermercadoDAO;
import carlos.robson.easyprice.Persistencia.SupermercadoDTO;
import carlos.robson.easyprice.Persistencia.UsuarioDAO;
import carlos.robson.easyprice.Persistencia.UsuarioDTO;

/**
 * Classe que terá os métodos de cadastro para todos os objetos
 */
public class CadastroController {

    private UsuarioDAO usuarioDAO;
    private SupermercadoDAO supermercadoDAO;

    public CadastroController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    int cadastrarUsuario(Usuario usuario) throws Exception {
        UsuarioDTO usuarioDTO = converterParaUsuarioDTO(usuario);
        return usuarioDAO.incluir(usuarioDTO);
    }

    int cadastrarSupermercado(Supermercado supermercado) throws Exception {
        SupermercadoDTO supermercadoDTO = converterParaSupermercadoDTO(supermercado);
        return supermercadoDAO.incluir(supermercadoDTO);
    }

    private Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getCpf(), usuarioDTO.getNome(), usuarioDTO.getLogin(), usuarioDTO.getSenha(), usuarioDTO.getIdade(), usuarioDTO.getSalario());
    }

    private Supermercado converterParaSupermercado(SupermercadoDTO supermercadoDTO) {
        return new Supermercado(supermercadoDTO.getIdSupermercado(), supermercadoDTO.getLatitude(), supermercadoDTO.getLongitude(), supermercadoDTO.getTelefone(), supermercadoDTO.getCpf(), supermercadoDTO.getNome());
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
}
