package com.rpvg2.model.repository;

import com.rpvg2.model.interfaces.IRepository;
import com.rpvg2.model.Relator;
import com.rpvg2.persistencia.RelatorPersistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filipe
 */
public class RelatorRepository implements IRepository<Relator> {

    private RelatorPersistencia persistencia;

    public RelatorRepository() {
        this.persistencia = new RelatorPersistencia();

    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * Nome do Relator;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Relator criarNovoObjeto(String[] valores) {
        Relator relator = new Relator();
        String nome = valores[0];
        relator.setNome(nome);

        return relator;
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * ID do Relator; valores[1] = Nome do Relator;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Relator criarObjetoComId(String[] valores) throws  NumberFormatException{
        Relator relator = new Relator();
        int id = Integer.parseInt(valores[0]);
        String nome = (String) valores[1];
        relator.setId(id);
        relator.setNome(nome);

        return relator;
    }

    @Override
    public boolean inserirObjeto(Relator object) throws SQLException, ClassNotFoundException {
        return this.persistencia.insert(object);
    }

    @Override
    public boolean editarObjeto(Relator object) throws SQLException, ClassNotFoundException {
        return this.persistencia.update(object);
    }

    @Override
    public boolean excluirObjeto(Relator object) throws SQLException, ClassNotFoundException {
        return this.persistencia.remove(object);
    }

    @Override
    public List<Relator> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorDesc(desc);
        List<Relator> relatores = new ArrayList<>();
        for (String[] ob : valores) {
            relatores.add(this.criarObjetoComId(ob));
        }
        return relatores;
    }

    @Override
    public Relator recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorId(id);
        return this.criarObjetoComId(valores);
    }

    @Override
    public List<Relator> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<Relator> relatores = new ArrayList<>();
        for (String[] ob : valores) {
            relatores.add(this.criarObjetoComId(ob));
        }
        return relatores;
    }

}
