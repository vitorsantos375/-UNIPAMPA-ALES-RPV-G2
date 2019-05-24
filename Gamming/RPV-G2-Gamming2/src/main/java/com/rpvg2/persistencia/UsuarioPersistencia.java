/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.interfaces.IPersistencia;
import com.rpvg2.model.Usuario;
import com.rpvg2.excecoes.UserNotFound;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherm Bolfe
 */
public class UsuarioPersistencia implements IPersistencia<Usuario> {

    private Conect conect;

    public UsuarioPersistencia() {
        this.conect = new Conect();
    }

    @Override
    public boolean insert(Usuario object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Usuario object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Usuario object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String[]> selectPorDesc(String desc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> usuarios = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `usuario` WHERE `nome_user` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[5];
                    valores[0] = Integer.toString(rs.getInt("id_user"));
                    valores[1] = rs.getString("nome_user");
                    valores[2] = Boolean.toString(rs.getBoolean("membro"));
                    valores[3] = Boolean.toString(rs.getBoolean("moderador"));
                    valores[4] = Boolean.toString(rs.getBoolean("secretario"));
                    usuarios.add(valores);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return usuarios;
    }

    @Override
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String[]> selectPorReuniaoRegistrado(String descReuniao) throws ClassNotFoundException, SQLException {
        return selectPorReuniao(descReuniao, true);
    }

    public List<String[]> selectPorReuniaoCadastrado(String descReuniao) throws ClassNotFoundException, SQLException {
        return selectPorReuniao(descReuniao, false);
    }

    public List<String[]> selectPorReuniao(String descReuniao, boolean registrado) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> usuarios = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM usuario INNER JOIN user_reuniao ON usuario.id_user = user_reuniao.id_user WHERE user_reuniao.id_reuniao = (SELECT id_reuniao FROM reuniao WHERE descricao_reuniao = ? ) AND  user_reuniao.registrado = ? AND user_reuniao.membro = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, descReuniao);
                stmt.setBoolean(2, registrado);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[5];
                    valores[0] = Integer.toString(rs.getInt("id_user"));
                    valores[1] = rs.getString("nome_user");
                    valores[2] = Boolean.toString(rs.getBoolean("membro"));
                    valores[3] = Boolean.toString(rs.getBoolean("moderador"));
                    valores[4] = Boolean.toString(rs.getBoolean("secretario"));
                    usuarios.add(valores);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return usuarios;
    }

    public String[] verificaLogin(String user, String pass) throws ClassNotFoundException, SQLException, UserNotFound {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `usuario` WHERE `nome_user` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[5];
                    valores[0] = Integer.toString(rs.getInt("id_user"));
                    valores[1] = rs.getString("nome_user");
                    valores[2] = Boolean.toString(this.isMembro(user));
                    valores[3] = Boolean.toString(this.isModerador(user));
                    valores[4] = Boolean.toString(this.isSecretario(user));
                    return valores;
                }
                throw new UserNotFound();
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return null;
    }

    public String[] verificaFuncoes(String user) throws ClassNotFoundException, SQLException {

        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `usuario` WHERE `nome_user` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[5];
                    valores[0] = Integer.toString(rs.getInt("id_user"));
                    valores[1] = rs.getString("nome_user");
                    valores[2] = Boolean.toString(this.isMembro(user));
                    valores[3] = Boolean.toString(this.isModerador(user));
                    valores[4] = Boolean.toString(this.isSecretario(user));
                    return valores;
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return null;

    }

    public boolean isSecretario(String user) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT`user_reuniao`.`secretario`,`user_reuniao`.`moderador`,`user_reuniao`.`membro`FROM `usuario` INNER JOIN `user_reuniao` ON `usuario`.`id_user` = `user_reuniao`.`id_user` WHERE `usuario`.id_user = (SELECT `id_user` FROM `usuario` WHERE `nome_user` = ?) AND `user_reuniao`.`secretario` = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    return true;
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return false;
    }

    public boolean isModerador(String user) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT`user_reuniao`.`secretario`,`user_reuniao`.`moderador`,`user_reuniao`.`membro`FROM `usuario` INNER JOIN `user_reuniao` ON `usuario`.`id_user` = `user_reuniao`.`id_user` WHERE `usuario`.id_user = (SELECT `id_user` FROM `usuario` WHERE `nome_user` = ?) AND `user_reuniao`.`moderador` = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    return true;
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return false;
    }

    public boolean isMembro(String user) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT`user_reuniao`.`secretario`,`user_reuniao`.`moderador`,`user_reuniao`.`membro`FROM `usuario` INNER JOIN `user_reuniao` ON `usuario`.`id_user` = `user_reuniao`.`id_user` WHERE `usuario`.id_user = (SELECT `id_user` FROM `usuario` WHERE `nome_user` = ?) AND `user_reuniao`.`membro` = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    return true;
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return false;
    }

}
