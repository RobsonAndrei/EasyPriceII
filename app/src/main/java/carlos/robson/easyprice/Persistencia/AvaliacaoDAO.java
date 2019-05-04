package carlos.robson.easyprice.Persistencia;

import java.sql.SQLException;
import java.util.List;

public interface AvaliacaoDAO {

    int inserir(AvaliacaoDTO avaliacaoDTO) throws SQLException;

    List<AvaliacaoDTO> buscarAvaliacoes(String cpf) throws  SQLException;
}
