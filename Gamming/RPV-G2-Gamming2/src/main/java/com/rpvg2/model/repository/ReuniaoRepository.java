/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model.repository;

import com.rpvg2.model.Encaminhamento;
import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.Usuario;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Reuniao;
import com.rpvg2.model.interfaces.IRepository;
import com.rpvg2.persistencia.ReuniaoPersistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Guilherm Bolfe
 */
public class ReuniaoRepository implements IRepository<Reuniao> {

    private ReuniaoPersistencia persistencia;
    private ItemPautaRepository itemPautaREP;
    private UsuarioRepository membroREP;

    public ReuniaoRepository() {
        this.persistencia = new ReuniaoPersistencia();
        this.itemPautaREP = new ItemPautaRepository();
        this.membroREP = new UsuarioRepository();
    }

    @Override
    public Reuniao criarNovoObjeto(String[] valores) throws NumberFormatException, SQLException, ClassNotFoundException {
        String descricao = valores[0];
        boolean aberta = Boolean.parseBoolean(valores[1]);
        return new Reuniao(descricao, aberta, new ArrayList<ItemPauta>(), new ArrayList<Usuario>());
    }

    @Override
    public Reuniao criarObjetoComId(String[] valores) throws SQLException, ClassNotFoundException, NumberFormatException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserirObjeto(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarObjeto(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirObjeto(Reuniao object) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reuniao> recuperarPorDescricao(String desc) throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectPorDesc(desc);
        List<Reuniao> reunioes = new ArrayList<>();
        for (String[] ob : valores) {
            reunioes.add(this.criarNovoObjeto(ob));
        }

        for (Reuniao reuniao : reunioes) {
            reuniao.setItensPauta(this.itemPautaREP.recuperarPorReuniao(reuniao.getDescricao()));
            reuniao.setMembrosCadastrados(this.membroREP.recuperarPorReuniaoCadastrados(reuniao.getDescricao()));
            reuniao.setMembrosRegistrados(this.membroREP.recuperarPorReuniaoRegistrados(reuniao.getDescricao()));
        }

        return reunioes;
    }

    @Override
    public Reuniao recuperarPorID(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reuniao> recuperarTodosObjetos() throws SQLException, ClassNotFoundException {
        List<String[]> valores = this.persistencia.selectTodos();
        List<Reuniao> reunioes = new ArrayList<>();
        for (String[] ob : valores) {
            reunioes.add(this.criarNovoObjeto(ob));
        }

        for (Reuniao reuniao : reunioes) {
            reuniao.setItensPauta(this.itemPautaREP.recuperarPorReuniao(reuniao.getDescricao()));
            reuniao.setMembrosCadastrados(this.membroREP.recuperarPorReuniaoCadastrados(reuniao.getDescricao()));
            reuniao.setMembrosRegistrados(this.membroREP.recuperarPorReuniaoRegistrados(reuniao.getDescricao()));
        }

        return reunioes;
    }

    public List<Reuniao> recuperaPorMembroEAberta(Usuario membro, boolean aberta) throws ClassNotFoundException, SQLException {
        List<String[]> valores = this.persistencia.selectPorMembroEAberta(membro.getNome(), aberta);
        List<Reuniao> reunioes = new ArrayList<>();
        for (String[] ob : valores) {
            reunioes.add(this.criarNovoObjeto(ob));
        }
        for (Reuniao reuniao : reunioes) {
            reuniao.setItensPauta(this.itemPautaREP.recuperarPorReuniao(reuniao.getDescricao()));
            reuniao.setMembrosCadastrados(this.membroREP.recuperarPorReuniaoCadastrados(reuniao.getDescricao()));
            reuniao.setMembrosRegistrados(this.membroREP.recuperarPorReuniaoRegistrados(reuniao.getDescricao()));
        }
        return reunioes;
    }

    public boolean editaVotacao(Map<Usuario, OpcaoVoto> votosPrimeiroTurno, Map<Usuario, OpcaoVoto> votosSegundoTurno, Encaminhamento enc, String descReuniao) throws SQLException, ClassNotFoundException {
        return this.persistencia.updateVotacao(votosPrimeiroTurno, votosSegundoTurno, enc, descReuniao);
    }

    public boolean editaPreseca(Usuario membro, String reuniao, boolean presente) throws SQLException, ClassNotFoundException {
        return this.persistencia.updatePresenca(membro, reuniao, presente);
    }

    public boolean editaAberta(String descReuniao) throws ClassNotFoundException, SQLException {
        return this.persistencia.updateAberta(descReuniao);
    }

    public List<Reuniao> recuperaPorSecretario(String secretario) throws ClassNotFoundException, SQLException {
        List<String[]> valores = this.persistencia.selectPorSecretario(secretario);
        List<Reuniao> reunioes = new ArrayList<>();
        for (String[] ob : valores) {
            reunioes.add(this.criarNovoObjeto(ob));
        }
        for (Reuniao reuniao : reunioes) {
            reuniao.setItensPauta(this.itemPautaREP.recuperarPorReuniao(reuniao.getDescricao()));
            reuniao.setMembrosCadastrados(this.membroREP.recuperarPorReuniaoCadastrados(reuniao.getDescricao()));
            reuniao.setMembrosRegistrados(this.membroREP.recuperarPorReuniaoRegistrados(reuniao.getDescricao()));
        }
        return reunioes;
    }

    public List<Reuniao> recuperaPorMod(String moderador) throws ClassNotFoundException, SQLException {
        List<String[]> valores = this.persistencia.selectPorModerador(moderador);
        List<Reuniao> reunioes = new ArrayList<>();
        for (String[] ob : valores) {
            reunioes.add(this.criarNovoObjeto(ob));
        }
        for (Reuniao reuniao : reunioes) {
            reuniao.setItensPauta(this.itemPautaREP.recuperarPorReuniao(reuniao.getDescricao()));
            reuniao.setMembrosCadastrados(this.membroREP.recuperarPorReuniaoCadastrados(reuniao.getDescricao()));
            reuniao.setMembrosRegistrados(this.membroREP.recuperarPorReuniaoRegistrados(reuniao.getDescricao()));
        }
        return reunioes;
    }
}
