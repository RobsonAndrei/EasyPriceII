package carlos.robson.easyprice.Controle;

import java.sql.SQLException;

import carlos.robson.easyprice.Dominio.Avaliacao;
import carlos.robson.easyprice.Persistencia.AvaliacaoDAO;
import carlos.robson.easyprice.Persistencia.AvaliacaoDAODTO;
import carlos.robson.easyprice.Persistencia.AvaliacaoDTO;

public class AvaliacaoController {

    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoController() {
        avaliacaoDAO = new AvaliacaoDAODTO();
    }

    public int inserirAvaliacao(Avaliacao avaliacao) throws SQLException {
        AvaliacaoDTO avaliacaoDTO = converterParaAvaliacaoDTO(avaliacao);
        return avaliacaoDAO.inserir(avaliacaoDTO);
    }

    private AvaliacaoDTO converterParaAvaliacaoDTO(Avaliacao avaliacao) {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();

        avaliacaoDTO.setIdAvaliacao(avaliacao.getIdAvaliacao());
        avaliacaoDTO.setComentario(avaliacao.getComentario());
        avaliacaoDTO.setNota(avaliacao.getNota());
        avaliacaoDTO.setDataAvaliacao(avaliacao.getDataAvaliacao());
        avaliacaoDTO.setIdProduto(avaliacao.getIdProduto());
        avaliacaoDTO.setIdCategoria(avaliacao.getIdCategoria());
        avaliacaoDTO.setIdSupermercado(avaliacao.getIdSupermercado());
        avaliacaoDTO.setCpf(avaliacao.getCpf());

        return avaliacaoDTO;
    }
}
