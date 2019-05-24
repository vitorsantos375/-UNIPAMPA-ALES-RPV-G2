/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.interfaces.IPersistencia;
import com.rpvg2.model.OpcaoVoto;
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
public class OpcaoVotoPersistencia implements IPersistencia<OpcaoVoto> {

    private Conect conect;

    public OpcaoVotoPersistencia() {
        this.conect = new Conect();
    }

    @Override
    public boolean insert(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(OpcaoVoto object) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                String sql = "DELETE FROM `opcao_voto` WHERE `id_opcao_voto = ? ";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, object.getId());
                stmt.executeUpdate();

            } else {
                return false;
            }
        } finally {
            stmt.close();
            conn.close();
        }
        return true;
    }

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `opcao_voto` WHERE `id_opcao_voto` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[3];
                    valores[0] = Integer.toString(rs.getInt("id_opcao_voto"));
                    valores[1] = rs.getString("desc_opcao_voto");
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

    @Override
    public List<String[]> selectPorDesc(String desc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> opcoes = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `opcao_voto` WHERE `desc_opcao_voto` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[3];
                    valores[0] = Integer.toString(rs.getInt("id_opcao_voto"));
                    valores[1] = rs.getString("desc_opcao_voto");
                    opcoes.add(valores);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }

        return opcoes;
    }

    public List<String[]> selectPorIdEncaminhamento(int idEnc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> opcoes = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `opcao_voto` WHERE `id_encaminhamento` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idEnc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[3];
                    valores[0] = Integer.toString(rs.getInt("id_opcao_voto"));
                    valores[1] = rs.getString("desc_opcao_voto");
                    opcoes.add(valores);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }

        return opcoes;
    }

    @Override
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> opcoes = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `opcao_voto`";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[3];
                    valores[0] = Integer.toString(rs.getInt("id_opcao_voto"));
                    valores[1] = rs.getString("desc_opcao_voto");
                    opcoes.add(valores);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }

        return opcoes;
    }
}
