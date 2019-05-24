package com.rpvg2.model.repository;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.EncaminhamentoSimples;
import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.interfaces.IRepository;
import com.rpvg2.persistencia.EncaminhamentoPersistencia;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class EncaminhamentoRepository implements IRepository<Encaminhamento>, Serializable {

    private EncaminhamentoPersistencia persistencia;
    private ItemPautaRepository itemPautaREP;
    private OpcaoVotoRepository opcaoVotoREP;

    public EncaminhamentoRepository() {
        this.persistencia = new EncaminhamentoPersistencia();
        this.itemPautaREP = new ItemPautaRepository();
        this.opcaoVotoREP = new OpcaoVotoRepository();

    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * Tipo Encaminhamento; valores[1] = Item pauta
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Encaminhamento criarNovoObjeto(String[] valores) throws SQLException, ClassNotFoundException, NumberFormatException {
        int tipoEnc = Integer.parseInt(valores[0]);
        int idPauta = Integer.parseInt(valores[1]);

        if (tipoEnc == 1) {
            EncaminhamentoSimples enc = new EncaminhamentoSimples();
            enc.setItemPauta(this.itemPautaREP.recuperarPorID(idPauta));
            return enc;
        } else {
            EncaminhamentoCustomizado enc = new EncaminhamentoCustomizado();
            enc.setItemPauta(this.itemPautaREP.recuperarPorID(idPauta));
            return enc;
        }
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * ID do Encaminhamento; valores[1] = Tipo Encaminhamento; valores[2] =
     * Segundo Turno; valores[3] = id Item Pauta;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Encaminhamento criarObjetoComId(String[] valores) throws SQLException, ClassNotFoundException, NumberFormatException {
        int id = Integer.parseInt(valores[0]);
        int tipoEnc = Integer.parseInt(valores[1]);
        int idPauta = Integer.parseInt(valores[3]);
        ItemPauta item = this.itemPautaREP.recuperarPorID(idPauta);

        if (tipoEnc == 1) {
            EncaminhamentoSimples enc = new EncaminhamentoSimples();
            enc.setId(id);
            enc.setItemPauta(item);
            return enc;
        } else {
            List<OpcaoVoto> opcoes = this.opcaoVotoREP.recuperarPorIdEncaminhamento(id);
            EncaminhamentoCustomizado enc = new EncaminhamentoCustomizado();
            boolean segundoTurno = Boolean.parseBoolean(valores[2]);
            enc.setId(id);
            enc.setOpcoesVoto(opcoes);
            enc.setSegundoturno(segundoTurno);
            enc.setItemPauta(item);
            return enc;
        }
    }

    @Override
    public boolean inserirObjeto(Encaminhamento object) throws SQLException, ClassNotFoundException {
        System.out.println("Repository");
        return this.persistencia.insert(object);
    }

    @Override
    public boolean editarObjeto(Encaminhamento object) throws SQLException, ClassNotFoundException {
        return this.persistencia.update(object);
    }

    @Override
    public boolean excluirObjeto(Encaminhamento object) throws SQLException, ClassNotFoundException {
        return this.persistencia.remove(object);
    }

    @Override
    public List<Encaminhamento> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Encaminhamento recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorId(id);
        return this.criarObjetoComId(valores);
    }

    @Override
    public List<Encaminhamento> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<Encaminhamento> ecaminhamentos = new ArrayList<>();
        for (String[] ob : valores) {
            ecaminhamentos.add(this.criarObjetoComId(ob));
        }
        return ecaminhamentos;
    }

    public Encaminhamento recuperarPorIdPauta(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorIdPauta(id);
        return this.criarObjetoComId(valores);
    }

}
