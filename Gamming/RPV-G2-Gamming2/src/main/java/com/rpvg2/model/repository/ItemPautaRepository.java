package com.rpvg2.model.repository;

import com.rpvg2.model.interfaces.IRepository;
import com.rpvg2.model.ItemPauta;
import com.rpvg2.persistencia.ItemPautaPersistencia;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class ItemPautaRepository implements IRepository<ItemPauta>, Serializable{

    private ItemPautaPersistencia persistencia;
    private RelatorRepository relatorREP;

    public ItemPautaRepository() {
        this.persistencia = new ItemPautaPersistencia();
        this.relatorREP = new RelatorRepository();
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * Descricao do Item Pauta; valores[1] = Relator; valores[2] = Possui
     * encaminhamento; valores[3] = Foi votada;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public ItemPauta criarNovoObjeto(String[] valores) throws SQLException, ClassNotFoundException {
        ItemPauta item = new ItemPauta();
        String desc = valores[0];
        int idRelator = Integer.parseInt(valores[1]);
        boolean votada = Boolean.parseBoolean(valores[2]);

        item.setDescricao(desc);
        item.setRelator(this.relatorREP.recuperarPorID(idRelator));
        item.setVotada(votada);

        return item;
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * ID do Item Pauta; valores[1] = Descricao do Item Pauta; valores[2] = ID
     * Relator; valores[3] = Possui encaminhamento; valores[4] = Foi votada;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public ItemPauta criarObjetoComId(String[] valores) throws SQLException, ClassNotFoundException, NumberFormatException {
        ItemPauta item = new ItemPauta();
        int id = Integer.parseInt(valores[0]);
        String desc = valores[1];
        int idRelator = Integer.parseInt(valores[2]);
        boolean votada = Boolean.parseBoolean(valores[3]);

        item.setId(id);
        item.setDescricao(desc);
        item.setRelator(this.relatorREP.recuperarPorID(idRelator));
        item.setVotada(votada);

        return item;
    }

    public ItemPauta inserirObjetoItemPauta(String descItemPauta, String relator, String descReuniao) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.insertItemPauta(descItemPauta, relator, descReuniao);
        return this.criarObjetoComId(valores);
    }

    public boolean editarObjetoItemPauta(ItemPauta object, String descReuniao) throws SQLException, ClassNotFoundException {
        return this.persistencia.updateItemPauta(object, descReuniao);
    }
    
    @Override
    public List<ItemPauta> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorDesc(desc);
        List<ItemPauta> itens = new ArrayList<>();
        for (String[] ob : valores) {
            itens.add(this.criarObjetoComId(ob));
        }
        return itens;
    }

    @Override
    public ItemPauta recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorId(id);
        return this.criarObjetoComId(valores);
    }

    @Override
    public List<ItemPauta> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<ItemPauta> itens = new ArrayList<>();
        for (String[] ob : valores) {
            itens.add(this.criarObjetoComId(ob));
        }
        return itens;
    }

    public List<ItemPauta> recuperarObjetosSemVotacao(boolean votada) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorNaoVotadas(votada);
        List<ItemPauta> itens = new ArrayList<>();
        for (String[] ob : valores) {
            itens.add(this.criarObjetoComId(ob));
        }
        return itens;
    }

    public List<ItemPauta> recuperarPorReuniao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorReuniao(desc);
        List<ItemPauta> itens = new ArrayList<>();
        for (String[] ob : valores) {
            itens.add(this.criarObjetoComId(ob));
        }
        return itens;
    }

    @Override
    public boolean inserirObjeto(ItemPauta object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirObjeto(ItemPauta object) throws SQLException, ClassNotFoundException {
        return this.persistencia.remove(object);
    }

    @Override
    public boolean editarObjeto(ItemPauta object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
