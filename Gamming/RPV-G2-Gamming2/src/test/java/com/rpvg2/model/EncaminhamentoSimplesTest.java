/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilis
 */
public class EncaminhamentoSimplesTest {

    /**
     * Testa se o encaminhamento simples é criado com as opções de voto:
     * Favoravel, Contrario e Abstenção
     */
    @Test
    public void testEncaminhamentoPossuiOpcoesCorretas() {
        EncaminhamentoSimples encaminhamentoSimples = new EncaminhamentoSimples();

        if (encaminhamentoSimples.getOpcoesVoto().size() > 3) {
            fail("Há mais de 3 opções de voto");
        }

        List<OpcaoVoto> opcoes = new ArrayList();
        opcoes.add(new OpcaoVoto("Favorável"));
        opcoes.add(new OpcaoVoto("Contrário"));
        opcoes.add(new OpcaoVoto("Abstenção"));

        assertTrue(encaminhamentoSimples.getOpcoesVoto().containsAll(opcoes));
    }
}
