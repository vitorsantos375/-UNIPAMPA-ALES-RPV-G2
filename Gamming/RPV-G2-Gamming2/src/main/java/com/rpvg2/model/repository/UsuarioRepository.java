/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model.repository;

import com.rpvg2.model.Usuario;
import com.rpvg2.model.interfaces.IRepository;
import com.rpvg2.persistencia.UsuarioPersistencia;
import com.rpvg2.excecoes.UserNotFound;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherm Bolfe
 */
public class UsuarioRepository implements IRepository<Usuario>, Serializable {

    private UsuarioPersistencia persistencia;

    public UsuarioRepository() {
        this.persistencia = new UsuarioPersistencia();
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * Nome do Usuario;
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Usuario criarNovoObjeto(String[] valores) {
        if (valores != null) {
            Usuario usuario = new Usuario();
            String nome = valores[0];
            usuario.setNome(nome);
            usuario.setMembro(false);
            usuario.setModerador(false);
            usuario.setSecretario(false);
            return usuario;
        }
        throw new IllegalArgumentException("Os valores estão Nulos");
    }

    /**
     * Cria um objeto com as informações passadas como parametro; valores[0] =
     * ID do Usuario; valores[1] = Nome do Usuario; valores[2] = boolean membro;
     * valores[3] = boolean moderador; valores[4]= secretario
     *
     * @param valores Os valores para atribuir no Objeto;
     * @return Retorna o Objeto com as informações passadas;
     */
    @Override
    public Usuario criarObjetoComId(String[] valores) {
        if (valores != null) {
            Usuario usuario = new Usuario();
            int id = Integer.parseInt(valores[0]);
            String nome = valores[1];
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setMembro(Boolean.valueOf(valores[2]));
            usuario.setModerador(Boolean.valueOf(valores[3]));
            usuario.setSecretario(Boolean.valueOf(valores[4]));

            return usuario;
        }
        throw new IllegalArgumentException("Os valores estão Nulos");
    }

    @Override
    public boolean inserirObjeto(Usuario object) throws SQLException, ClassNotFoundException, NumberFormatException {
        return this.persistencia.insert(object);
    }

    @Override
    public boolean editarObjeto(Usuario object) throws SQLException, ClassNotFoundException {
        return this.persistencia.update(object);
    }

    @Override
    public boolean excluirObjeto(Usuario object) throws SQLException, ClassNotFoundException {
        return this.persistencia.remove(object);
    }

    @Override
    public List<Usuario> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorDesc(desc);
        List<Usuario> usuarios = new ArrayList<>();
        for (String[] ob : valores) {
            usuarios.add(this.criarObjetoComId(ob));
        }
        return usuarios;
    }

    @Override
    public Usuario recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.selectPorId(id);
        return this.criarObjetoComId(valores);
    }

    @Override
    public List<Usuario> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<Usuario> usuarios = new ArrayList<>();
        for (String[] ob : valores) {
            usuarios.add(this.criarObjetoComId(ob));
        }
        return usuarios;
    }

    public List<Usuario> recuperarPorReuniaoCadastrados(String descReuniao) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorReuniaoCadastrado(descReuniao);
        List<Usuario> usuarios = new ArrayList<>();
        for (String[] ob : valores) {
            usuarios.add(this.criarObjetoComId(ob));
        }
        return usuarios;
    }

    public List<Usuario> recuperarPorReuniaoRegistrados(String descReuniao) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorReuniaoRegistrado(descReuniao);
        List<Usuario> usuarios = new ArrayList<>();
        for (String[] ob : valores) {
            usuarios.add(this.criarObjetoComId(ob));
        }
        return usuarios;
    }

    public Usuario verificalogin(String user, String pass) throws SQLException, ClassNotFoundException, UserNotFound {
        this.persistencia.verificaLogin(user, pass);
        return this.verificaFuncoes(user);
    }

    public Usuario verificaFuncoes(String user) throws SQLException, ClassNotFoundException {
        String[] valores = this.persistencia.verificaFuncoes(user);
        return this.criarObjetoComId(valores);
    }

}
