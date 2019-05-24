package com.rpvg2.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Giliardi Schmidt
 */
public class EncaminhamentoCustomizadoTest {

    /**
     * Teste para verificar se o encaminhamento é criado com a opção de voto
     * abstenção
     */
    @Test
    public void testCriaComAbstencao() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        assertTrue(ec.getOpcoesVoto().contains(new OpcaoVoto("Abstenção")));
    }

    /**
     * Testa se é possível remover a opção de voto Abstenção
     */
    @Test(expected = RuntimeException.class)
    public void testRemoveOpcaoVotoAbstencao() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        OpcaoVoto op = new OpcaoVoto("Abstenção");

        ec.removeOpcaoVoto(op);

        fail("Foi possivel remover a opção de voto abstenção");
    }

    /**
     * Verifica se é possível adicionar duas vezes a mesma opção de voto
     */
    @Test(expected = RuntimeException.class)
    public void testAddOpcaoVotoRepetida() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        OpcaoVoto op1 = new OpcaoVoto("opcao");
        OpcaoVoto op2 = new OpcaoVoto("opcao");

        ec.addOpcaoVoto(op1);
        ec.addOpcaoVoto(op2);

        fail("Foi possivel adicionar a mesma opção de voto duas vezes");
    }

    /**
     * Testa o get e set das opções de voto do primeiro turno
     */
    @Test
    public void testGetOpcoesVotosPrimeiroTurno() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        List<OpcaoVoto> opcoes = new ArrayList();

        OpcaoVoto op1 = new OpcaoVoto("op1");
        opcoes.add(op1);
        OpcaoVoto op2 = new OpcaoVoto("op2");
        opcoes.add(op2);

        ec.setOpcoesVoto(opcoes);

        List<OpcaoVoto> opcaoVotos = ec.getOpcoesVoto();

        for (OpcaoVoto opcaoVoto : opcaoVotos) {
            if (!opcoes.contains(opcaoVoto)) {
                fail("Opção de voto não deveria estar na lista");
            }
        }
    }

    /**
     * Testa se é possível setar a lista de opções de voto do primeiro turno com
     * opções repetidas
     */
    @Test(expected = RuntimeException.class)
    public void testSetOpcoesVotosPrimeiroTurnoRepetida() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        List<OpcaoVoto> opcoes = new ArrayList();

        OpcaoVoto op1 = new OpcaoVoto("op1");
        opcoes.add(op1);
        OpcaoVoto op2 = new OpcaoVoto("op1");
        opcoes.add(op2);

        ec.setOpcoesVoto(opcoes);

        fail("Foi possível adicionar opções de voto repetidas");
    }

    /**
     * Testa o get e set das opções de voto do segundo turno
     */
    @Test
    public void testGetOpcoesVotosSegundoTurno() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        List<OpcaoVoto> opcoes = new ArrayList();

        OpcaoVoto op1 = new OpcaoVoto("op1");
        opcoes.add(op1);
        OpcaoVoto op2 = new OpcaoVoto("op2");
        opcoes.add(op2);

        ec.setOpcoesVotosSegundoTurno(opcoes);

        List<OpcaoVoto> opcoesVotosSegundoTurno = ec.getOpcoesVotosSegundoTurno();

        for (OpcaoVoto opcaoVoto : opcoesVotosSegundoTurno) {
            if (!opcoes.contains(opcaoVoto)) {
                fail("Opção de voto não deveria estar na lista");
            }
        }
    }

    /**
     * Testa se é possível setar a lista de opções de voto do segundo turno com
     * opções repetidas
     */
    @Test(expected = RuntimeException.class)
    public void testSetOpcoesVotosSegundoTurnoRepetida() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        List<OpcaoVoto> opcoes = new ArrayList();

        OpcaoVoto op1 = new OpcaoVoto("opção");
        opcoes.add(op1);
        OpcaoVoto op2 = new OpcaoVoto("opção");
        opcoes.add(op2);

        ec.setOpcoesVotosSegundoTurno(opcoes);

        fail("Foi possível adicionar opções de voto repetidas");
    }

    /**
     * Testa o get e set do boolean isSegundoTurno
     */
    @Test
    public void testIsSegundoTurno() {
        EncaminhamentoCustomizado ec = new EncaminhamentoCustomizado();
        ec.setSegundoturno(true);
        assertEquals(ec.isSegundoturno(), true);

        ec.setSegundoturno(false);
        assertEquals(ec.isSegundoturno(), false);
    }

}
