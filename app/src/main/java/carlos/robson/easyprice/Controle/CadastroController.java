package carlos.robson.easyprice.Controle;

import carlos.robson.easyprice.Dominio.Usuario;
import carlos.robson.easyprice.Persistencia.UsuarioDAO;
import carlos.robson.easyprice.Persistencia.UsuarioDTO;

/**
 * Classe que terá os métodos de cadastro para todos os objetos
 */
public class CadastroController {

    private UsuarioDAO usuarioDAO;

    public CadastroController(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }

    public boolean cadastrarUsuario(Usuario usuario) throws  Exception{
        UsuarioDTO usuarioDTO = converterParaUsuarioDTO(usuario);
        return usuarioDAO.incluir(usuarioDTO);
    }

    private Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getNome(), usuarioDTO.getCpf());
    }

    private UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setCpf(usuario.getCpf());

        return usuarioDTO;
    }
}
