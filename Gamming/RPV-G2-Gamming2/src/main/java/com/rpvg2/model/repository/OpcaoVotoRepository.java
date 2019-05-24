package com.rpvg2.model.repository;

import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.persistencia.OpcaoVotoPersistencia;
import java.sql.SQLException;
import com.rpvg2.model.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class OpcaoVotoRepository implements IRepository<OpcaoVoto> {

    private OpcaoVotoPersistencia persistencia;

    public OpcaoVotoRepository() {
        this.persistencia = new OpcaoVotoPersistencia();
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * Descricao da Opcao de Voto; valores[1] = ID do Encaminhamento;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public OpcaoVoto criarNovoObjeto(String[] valores) {
        if (valores != null) {
            OpcaoVoto opcao = new OpcaoVoto();
            String desc = valores[0];
            opcao.setDescricao(desc);

            return opcao;
        }
        throw new IllegalArgumentException("Os valores estão Nulos");
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * ID da Opcao de Voto; valores[1] = Descricao da Opcao de Voto;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public OpcaoVoto criarObjetoComId(String[] valores) throws NumberFormatException {
        if (valores != null) {
            OpcaoVoto opcao = new OpcaoVoto();
            int id = Integer.parseInt(valores[0]);
            String desc = valores[1];
            opcao.setId(id);
            opcao.setDescricao(desc);

            return opcao;
        }
        throw new IllegalArgumentException("Os valores estão Nulos");
    }

    @Override
    public boolean inserirObjeto(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        return this.persistencia.insert(object);
    }

    @Override
    public boolean editarObjeto(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        return this.persistencia.update(object);
    }

    @Override
    public boolean excluirObjeto(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        return this.persistencia.remove(object);
    }

    @Override
    public List<OpcaoVoto> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorDesc(desc);
        List<OpcaoVoto> opcoes = new ArrayList<>();
        for (String[] ob : valores) {
            opcoes.add(this.criarObjetoComId(ob));
        }
        return opcoes;
    }

    @Override
    public OpcaoVoto recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorId(id);
        return this.criarObjetoComId(valores);

    }

    @Override
    public List<OpcaoVoto> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<OpcaoVoto> opcoes = new ArrayList<>();
        for (String[] ob : valores) {
            opcoes.add(this.criarObjetoComId(ob));
        }
        return opcoes;
    }

    public List<OpcaoVoto> recuperarPorIdEncaminhamento(int id) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorIdEncaminhamento(id);
        List<OpcaoVoto> opcoes = new ArrayList<>();
        for (String[] ob : valores) {
            opcoes.add(this.criarObjetoComId(ob));
        }
        return opcoes;
    }

}
