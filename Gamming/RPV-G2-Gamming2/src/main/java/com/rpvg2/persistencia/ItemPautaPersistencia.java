/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.interfaces.IPersistencia;
import com.rpvg2.model.ItemPauta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherm Bolfe
 */
public class ItemPautaPersistencia implements IPersistencia<ItemPauta> {

    private Conect conect;

    public ItemPautaPersistencia() {
        this.conect = new Conect();
    }

    public String[] insertItemPauta(String descItemPauta, String relator, String descReuniao) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        String[] valores = new String[4];
        ResultSet rs = null;
        int id = 0;
        try {
            if (conn != null) {
                String sql = "INSERT INTO `item_pauta`(`desc_item_pauta`, `relator_id_relator`, `item_pauta_votada`, `id_reuniao`) VALUES (?,(SELECT `id_relator` FROM `relator` WHERE `nome_relator` = ?),?,(SELECT `id_reuniao` FROM `reuniao` WHERE `descricao_reuniao` = ?))";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, descItemPauta);
                stmt.setString(2, relator);
                stmt.setBoolean(3, false);
                stmt.setString(4, descReuniao);
                stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                
                while (rs.next()) { 
                    id = rs.getInt(1);
                }
                
                valores[0] = Integer.toString(id);
                
                sql = "SELECT `id_relator` FROM `relator` WHERE `nome_relator` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, relator);
                rs = stmt.executeQuery();
                
                while (rs.next()) { 
                     
                    valores[1] = descItemPauta;
                    valores[2] = Integer.toString(rs.getInt("id_relator"));
                    valores[3] = Boolean.toString(false);
                }
            }
        } finally {
            stmt.close();
            conn.close();
        }
        return valores;
    }

    public boolean updateItemPauta(ItemPauta object, String descReuniao) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                String sql = "UPDATE `item_pauta` SET `desc_item_pauta`= ?,`relator_id_relator`= ?,`item_pauta_votada`= ?,`id_reuniao`= (SELECT `id_reuniao` FROM `reuniao` WHERE `descricao_reuniao` = ?) WHERE `id_item_pauta`= ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, object.getDescricao());
                stmt.setInt(2, object.getRelator().getId());
                stmt.setBoolean(3, object.isVotada());
                stmt.setString(4, descReuniao);
                stmt.setInt(5, object.getId());
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
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> itens = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT ip.*, `r`.`nome_relator` FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator`";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_item_pauta"));
                    valores[1] = rs.getString("desc_item_pauta");
                    valores[2] = Integer.toString(rs.getInt("relator_id_relator"));
                    valores[3] = Boolean.toString(rs.getBoolean("item_pauta_votada"));

                    itens.add(valores);
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return itens;

    }

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            if (conn != null) {
                String sql = "SELECT `ip`.*, `r`.`nome_relator` FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` WHERE `ip`.`id_item_pauta` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_item_pauta"));
                    valores[1] = rs.getString("desc_item_pauta");
                    valores[2] = Integer.toString(rs.getInt("relator_id_relator"));
                    valores[3] = Boolean.toString(rs.getBoolean("item_pauta_votada"));

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
    public List<String[]> selectPorDesc(String desc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> itens = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT `ip`.*, `r`.`nome_relator` FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` WHERE `ip`.`desc_item_pauta` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_item_pauta"));
                    valores[1] = rs.getString("desc_item_pauta");
                    valores[2] = Integer.toString(rs.getInt("relator_id_relator"));
                    valores[3] = Boolean.toString(rs.getBoolean("item_pauta_votada"));

                    itens.add(valores);
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return itens;
    }

    public List<String[]> selectPorNaoVotadas(boolean votada) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> itens = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT ip.*, `r`.`nome_relator` FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` WHERE `ip`.`item_pauta_votada` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, votada);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_item_pauta"));
                    valores[1] = rs.getString("desc_item_pauta");
                    valores[2] = Integer.toString(rs.getInt("relator_id_relator"));
                    valores[3] = Boolean.toString(rs.getBoolean("item_pauta_votada"));

                    itens.add(valores);
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return itens;
    }

    public List<String[]> selectPorReuniao(String desc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> itens = new ArrayList<>();
        int idReuniao = 0;
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `reuniao` WHERE `descricao_reuniao` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    idReuniao = rs.getInt("id_reuniao");
                    break;
                }

                sql = "SELECT ip.*, `r`.`nome_relator` FROM `item_pauta` AS ip INNER JOIN `relator` AS r ON `ip`.`relator_id_relator` = `r`.`id_relator` WHERE `ip`.`id_reuniao` = ? AND `item_pauta_votada` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idReuniao);
                stmt.setBoolean(2, false);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] valores = new String[4];
                    valores[0] = Integer.toString(rs.getInt("id_item_pauta"));
                    valores[1] = rs.getString("desc_item_pauta");
                    valores[2] = Integer.toString(rs.getInt("relator_id_relator"));
                    valores[3] = Boolean.toString(rs.getBoolean("item_pauta_votada"));

                    itens.add(valores);
                }
            }
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
        return itens;
    }

    @Override
    public boolean insert(ItemPauta object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ItemPauta object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(ItemPauta object) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                String sql = "DELETE FROM `item_pauta` WHERE `id_item_pauta` = ?";
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

}
