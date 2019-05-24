/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.interfaces.IPersistencia;
import com.rpvg2.model.Encaminhamento;
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
public class EncaminhamentoPersistencia implements IPersistencia<Encaminhamento> {

    private Conect conect;

    public EncaminhamentoPersistencia() {
        this.conect = new Conect();
    }

    @Override
    public boolean insert(Encaminhamento object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Encaminhamento object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Encaminhamento object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT `ip`.*, `r`.`nome_relator`,`enc`.* FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` INNER JOIN `encaminhamento` AS enc ON `enc`.`item_pauta_id_item_pauta` = `ip`.`id_item_pauta` WHERE `enc`.`id_encaminhamento` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_encaminhamento"));
                    valores[1] = Integer.toString(rs.getInt("idTipoEncaminhamento"));
                    valores[2] = Boolean.toString(rs.getBoolean("segundoTurno"));
                    valores[3] = Integer.toString(rs.getInt("item_pauta_id_item_pauta"));

                    return valores;
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return null;

    }

    @Override
    public List<String[]> selectPorDesc(String desc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> encaminhamentos = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT `ip`.*, `r`.`nome_relator`,`enc`.* FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` INNER JOIN `encaminhamento` AS enc ON `enc`.`item_pauta_id_item_pauta` = `ip`.`id_item_pauta`";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_encaminhamento"));
                    valores[1] = Integer.toString(rs.getInt("idTipoEncaminhamento"));
                    valores[2] = Boolean.toString(rs.getBoolean("segundoTurno"));
                    valores[3] = Integer.toString(rs.getInt("item_pauta_id_item_pauta"));

                    encaminhamentos.add(valores);
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return encaminhamentos;

    }

    public String[] selectPorIdPauta(int idPauta) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT `ip`.*, `r`.`nome_relator`,`enc`.* FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` INNER JOIN `encaminhamento` AS enc ON `enc`.`item_pauta_id_item_pauta` = `ip`.`id_item_pauta` WHERE `enc`.`item_pauta_id_item_pauta` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idPauta);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_encaminhamento"));
                    valores[1] = Integer.toString(rs.getInt("idTipoEncaminhamento"));
                    valores[2] = Boolean.toString(rs.getBoolean("segundoTurno"));
                    valores[3] = Integer.toString(rs.getInt("item_pauta_id_item_pauta"));

                    return valores;
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return null;

    }
}
