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
 * @author Guilherm Bolfe
 */
public class EncaminhamentoTest {

    public EncaminhamentoTest() {
    }

    /**
     * Teste Positivo: Testa se um objeto item pauta é setato no objeto
     * encaminhamento.
     */
    @Test
    public void testSetItemPauta() {
        System.out.println("Test setItemPauta");
        ItemPauta itemPauta = new ItemPauta();
        Encaminhamento instance = new EncaminhamentoImpl();
        instance.setItemPauta(itemPauta);
        assertEquals(itemPauta, instance.getItemPauta());
    }

    /**
     * Teste Negativo: Testa se um objeto item pauta é alterado para null no
     * objeto encaminhamento.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetItemPautaNull() {
        System.out.println("Test setItemPautaNull");
        ItemPauta itemPauta = null;
        Encaminhamento instance = new EncaminhamentoImpl();
        instance.setItemPauta(itemPauta);
        fail("Foi possivel mudar o item pauta para null");
    }

    /**
     * Teste Positivo: Testa se retorna as opções de voto corretas do objeto
     * encaminhamento.
     */
    @Test
    public void testGetOpcoesVoto() {
        System.out.println("Test getOpcoesVoto");
        Encaminhamento instance = new EncaminhamentoImpl();
        List<OpcaoVoto> expResult = new ArrayList<>();
        List<OpcaoVoto> result = instance.getOpcoesVoto();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se retorna o item pauta do objeto encaminhamento.
     */
    @Test
    public void testGetItemPauta() {
        System.out.println("Test getItemPauta");
        Encaminhamento instance = new EncaminhamentoImpl();
        ItemPauta expResult = new ItemPauta();
        instance.setItemPauta(expResult);
        ItemPauta result = instance.getItemPauta();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se retorna o id do objeto encaminhamento.
     */
    @Test
    public void testGetId() {
        System.out.println("Test getId");
        Encaminhamento instance = new EncaminhamentoImpl();
        instance.setId(0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se altera o id do objeto encaminhamento.
     */
    @Test
    public void testSetId() {
        System.out.println("Test setId");
        int id = 0;
        Encaminhamento instance = new EncaminhamentoImpl();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    public class EncaminhamentoImpl extends Encaminhamento {
    }

}
