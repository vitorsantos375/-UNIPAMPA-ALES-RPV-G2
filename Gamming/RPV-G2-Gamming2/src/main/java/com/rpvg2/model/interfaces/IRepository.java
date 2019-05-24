package com.rpvg2.model.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Giliardi Schmidt
 */
public interface IRepository<T> {

    /**
     * Cria um objeto com as informações passadas como parametro;
     *
     * @param valores
     * @return
     */
    public T criarNovoObjeto(String[] valores) throws NumberFormatException, SQLException, ClassNotFoundException;

    /**
     * Cria um objeto com as informações passadas como parametro;
     *
     * @param valores
     * @return
     */
    public T criarObjetoComId(String[] valores) throws SQLException, ClassNotFoundException, NumberFormatException;

    /**
     * Insere o objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean inserirObjeto(T object) throws SQLException, ClassNotFoundException;

    /**
     * Edita o objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean editarObjeto(T object) throws SQLException, ClassNotFoundException;

    /**
     * Exclui o objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean excluirObjeto(T object) throws SQLException, ClassNotFoundException;

    /**
     * Recupera todos os objetos que possuirem a String informada.
     *
     * @throws SQLException
     * @param des String com o valor a ser buscado.
     * @return Lista dos objetos encontrados
     */
    public List<T> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException;

    /**
     * Recupera um objeto (o primeiro a ser encontrado) que possui os dados
     * informados.
     *
     * @throws SQLException
     * @param id Integer para a busca do objeto (ID);
     * @return O objeto que possuia o Id informado
     */
    public T recuperarPorID(int id) throws SQLException, ClassNotFoundException;

    /**
     * Recupera todos os objetos do banco;
     *
     * @return Lista com todos os objetos criados;
     * @throws SQLException
     */
    public List<T> recuperarTodosObjetos() throws SQLException, ClassNotFoundException;
}
