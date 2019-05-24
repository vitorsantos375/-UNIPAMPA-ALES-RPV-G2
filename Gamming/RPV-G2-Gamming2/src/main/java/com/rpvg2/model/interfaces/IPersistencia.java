package com.rpvg2.model.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Giliardi Schmidt
 */
public interface IPersistencia<T> {

    /**
     * Insere no Banco de Dados o Objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean insert(T object) throws SQLException, ClassNotFoundException;

    /**
     * Edita no Banco de Dados o Objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean update(T object) throws SQLException, ClassNotFoundException;

    /**
     * Exclui no Banco de Dados o Objeto passado como parametro;
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public boolean remove(T object) throws SQLException, ClassNotFoundException;

    /**
     * Busca todas as informações sobre todos os objetos;
     *
     * @return ResultSet com todas as informações dos objetos
     * @throws SQLException
     */
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException;

    /**
     * Busca as informações sobre o objeto com o id passado como parametro
     *
     * @param id
     * @return ResultSet com as informações do objeto
     * @throws SQLException
     */
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException;

    /**
     * Busca todas as informações sobre todos os objetos qeu possuem a String
     * passada como parametro;
     *
     * @param desc
     * @return ResultSet com todas as informações dos objetos
     * @throws SQLException
     */
    public List<String[]> selectPorDesc(String desc) throws SQLException, ClassNotFoundException;

}
