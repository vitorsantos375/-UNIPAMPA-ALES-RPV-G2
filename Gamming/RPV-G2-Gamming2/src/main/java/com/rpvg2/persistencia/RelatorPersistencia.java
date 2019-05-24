/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.interfaces.IPersistencia;
import com.rpvg2.model.Relator;
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
public class RelatorPersistencia implements IPersistencia<Relator> {

    private Conect conect;

    public RelatorPersistencia() {
        this.conect = new Conect();
    }

    @Override
    public boolean insert(Relator object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Relator object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Relator object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `relator` WHERE `id_relator` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[2];
                    valores[0] = Integer.toString(rs.getInt("id_relator"));
                    valores[1] = rs.getString("nome_relator");
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
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `relator` WHERE `nome_relator` =?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = Integer.toString(rs.getInt("id_relator"));
                    val[1] = rs.getString("nome_relator");
                    valores.add(val);
                }
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return valores;
    }

    @Override
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `relator`";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = Integer.toString(rs.getInt("id_relator"));
                    val[1] = rs.getString("nome_relator");
                    valores.add(val);
                }
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return valores;
    }

}
