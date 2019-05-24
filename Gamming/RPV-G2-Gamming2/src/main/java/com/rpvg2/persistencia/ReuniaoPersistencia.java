/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.persistencia;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.EncaminhamentoSimples;
import com.rpvg2.model.Usuario;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Reuniao;
import com.rpvg2.model.interfaces.IPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Guilherm Bolfe
 */
public class ReuniaoPersistencia implements IPersistencia<Reuniao> {

    private Conect conect;

    public ReuniaoPersistencia() {
        this.conect = new Conect();
    }

    @Override
    public boolean insert(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String[]> selectTodos() throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `reuniao`";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = rs.getString("descricao_reuniao");
                    val[1] = Boolean.toString(rs.getBoolean("reuniao_aberta"));
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

    @Override
    public String[] selectPorId(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String[]> selectPorDesc(String desc) throws SQLException, ClassNotFoundException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `reuniao` WHERE `descricao_reuniao` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, desc);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = rs.getString("descricao_reuniao");
                    val[1] = Boolean.toString(rs.getBoolean("reuniao_aberta"));
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

    public List<String[]> selectPorMembroEAberta(String nome, boolean aberta) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM `reuniao` AS r INNER JOIN `user_reuniao`ON `user_reuniao`.`id_reuniao` = `r`.`id_reuniao` INNER JOIN `usuario` ON `user_reuniao`.`id_user` = `usuario`.`id_user` WHERE `r`.`reuniao_aberta` = ? AND `usuario`.`nome_user` = ? AND `user_reuniao`.`membro` = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, aberta);
                stmt.setString(2, nome);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = rs.getString("descricao_reuniao");
                    val[1] = Boolean.toString(rs.getBoolean("reuniao_aberta"));
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

    public boolean updateVotacao(Map<Usuario, OpcaoVoto> votosPrimeiroTurno, Map<Usuario, OpcaoVoto> votosSegundoTurno, Encaminhamento enc, String descReuniao) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        Usuario[] keysPrimeiro = null;
        Usuario[] keysSegundo = null;
        String sql = "";
        boolean segundoTurno = false;

        try {
            //Inserção dos Encaminhamentos
            if (conn != null) {
                sql = "INSERT INTO `encaminhamento`(`id_TipoEncaminhamento`, `segundo_Turno`, `item_pauta_id_item_pauta`, `id_reuniao`) VALUES (?,?,?,(SELECT id_reuniao FROM reuniao WHERE descricao_reuniao = ?))";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(3, enc.getItemPauta().getId());
                stmt.setString(4, descReuniao);

                if (enc instanceof EncaminhamentoSimples) {
                    stmt.setInt(1, 1);
                    stmt.setBoolean(2, false);

                } else {
                    EncaminhamentoCustomizado encaminhamento = (EncaminhamentoCustomizado) enc;
                    stmt.setInt(1, 2);
                    stmt.setBoolean(2, encaminhamento.isSegundoturno());
                }
                stmt.executeUpdate();

                int numero = 0;

                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    numero = rs.getInt(1);
                }

                for (OpcaoVoto op : enc.getOpcoesVoto()) {
                    sql = "INSERT INTO `opcao_voto` (id_encaminhamento, desc_opcao_voto) VALUES ( ?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, numero);
                    stmt.setString(2, op.getDescricao());
                    stmt.executeUpdate();
                }

                //Inserção dos Votos
                keysPrimeiro = votosPrimeiroTurno.keySet().stream().toArray(Usuario[]::new);

                if (enc instanceof EncaminhamentoCustomizado) {
                    EncaminhamentoCustomizado enca = (EncaminhamentoCustomizado) enc;
                    segundoTurno = enca.isSegundoturno();
                    if (segundoTurno) {
                        keysSegundo = votosSegundoTurno.keySet().stream().toArray(Usuario[]::new);
                    }

                }

                sql = "SELECT * FROM `opcao_voto` WHERE `id_encaminhamento` = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, numero);
                rs = stmt.executeQuery();

                List<String[]> opcoes = new ArrayList<>();
                while (rs.next()) {
                    String[] valores = new String[3];
                    valores[0] = Integer.toString(rs.getInt("id_opcao_voto"));
                    valores[1] = rs.getString("desc_opcao_voto");
                    opcoes.add(valores);
                }

                for (int i = 0; i < votosPrimeiroTurno.size(); i++) {
                    OpcaoVoto op = votosPrimeiroTurno.get(keysPrimeiro[i]);
                    int idOp = 0;
                    for (int j = 0; j < opcoes.size(); j++) {
                        if (op.getDescricao().equals(opcoes.get(j)[1])) {
                            idOp = Integer.parseInt(opcoes.get(j)[0]);
                        }
                    }
                    sql = "INSERT INTO `voto`(`id_membro`, `id_opcao_voto`, `id_encaminhamento`) VALUES (?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, keysPrimeiro[i].getId());
                    stmt.setInt(2, idOp);
                    stmt.setInt(3, numero);
                    stmt.executeUpdate();
                }

                if (segundoTurno) {
                    for (int i = 0; i < votosSegundoTurno.size(); i++) {
                        OpcaoVoto op = votosSegundoTurno.get(keysPrimeiro[i]);
                        int idOp = 0;
                        for (int j = 0; j < opcoes.size(); j++) {
                            if (op.getDescricao().equals(opcoes.get(j)[1])) {
                                idOp = Integer.parseInt(opcoes.get(j)[0]);
                            }
                        }

                        sql = "INSERT INTO `voto`(`id_membro`, `id_opcao_voto`, `id_encaminhamento`) VALUES (?,?,?)";
                        stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, keysSegundo[i].getId());
                        stmt.setInt(2, idOp);
                        stmt.setInt(3, numero);
                        stmt.executeUpdate();
                    }
                }
                sql = "UPDATE `item_pauta` SET `item_pauta_votada`= ? WHERE `id_item_pauta`= ?";
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, true);
                stmt.setInt(2, enc.getItemPauta().getId());
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

    public boolean updatePresenca(Usuario membro, String reuniao, boolean presente) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                String sql = " UPDATE `user_reuniao` SET `registrado`= ? WHERE `id_user` = ? AND `id_reuniao` = (SELECT `id_reuniao` FROM `reuniao` WHERE `descricao_reuniao` = ?) ";
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, presente);
                stmt.setInt(2, membro.getId());
                stmt.setString(3, reuniao);
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

    public boolean updateAberta(String descReuniao) throws ClassNotFoundException, SQLException {
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        try {
            if (conn != null) {
                String sql = " UPDATE `reuniao` SET `reuniao_aberta`= ? WHERE `descricao_reuniao` = ? ";
                stmt = conn.prepareStatement(sql);
                stmt.setBoolean(1, true);
                stmt.setString(2, descReuniao);
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

    public List<String[]> selectPorSecretario(String secretario) throws ClassNotFoundException, SQLException{
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM reuniao INNER JOIN user_reuniao ON reuniao.id_reuniao = user_reuniao.id_reuniao WHERE user_reuniao.id_user = (SELECT id_user FROM usuario WHERE usuario.nome_user = ?) AND user_reuniao.secretario = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, secretario);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = rs.getString("descricao_reuniao");
                    val[1] = Boolean.toString(rs.getBoolean("reuniao_aberta"));
                    valores.add(val);
                }
                return valores;
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return valores;
    }
    
    public List<String[]> selectPorModerador(String secretario) throws ClassNotFoundException, SQLException{
        Connection conn = this.conect.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> valores = new ArrayList<>();
        try {
            if (conn != null) {
                String sql = "SELECT * FROM reuniao INNER JOIN user_reuniao ON reuniao.id_reuniao = user_reuniao.id_reuniao WHERE user_reuniao.id_user = (SELECT id_user FROM usuario WHERE usuario.nome_user = ?) AND user_reuniao.moderador = 1";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, secretario);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String[] val = new String[2];
                    val[0] = rs.getString("descricao_reuniao");
                    val[1] = Boolean.toString(rs.getBoolean("reuniao_aberta"));
                    valores.add(val);
                }
                return valores;
            }
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return valores;
    }
}
