/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherm Bolfe
 */
public class ItemPautaTest {

    public ItemPautaTest() {
    }

    /**
     * Teste Positivo: Testa se a descrição retornada do objeto item pauta está
     * correta.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("Test getDescricao");
        ItemPauta instance = new ItemPauta();
        String expResult = "Teste01";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se a descrição do objeto item pauta é alterada.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("Test setDescricao");
        String descricao = "Descrição";
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        String result = instance.getDescricao();
        assertEquals(descricao, result);

    }

    /**
     * Teste Neagativo: Testa se a descrição do objeto item pauta é alterada
     * para vazia.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoVazia() {
        System.out.println("Test setDescricaoVazia");
        String descricao = "";
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        fail("Foi possivel mudar a descrição de um item pauta para vazia");
    }

    /**
     * Teste Neagativo: Testa se a descrição do objeto item pauta é alterada
     * para null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoNull() {
        System.out.println("Test setDescricaoNull");
        String descricao = null;
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        fail("Foi possivel mudar a descrição de um item pauta para null");
    }

    /**
     * Teste Positivo: Testa se o objeto realator retornado do objeto item pauta
     * está correto.
     */
    @Test
    public void testGetRelator() {
        System.out.println("Test getRelator");
        ItemPauta instance = new ItemPauta();
        Relator expResult = new Relator();
        instance.setRelator(expResult);
        Relator result = instance.getRelator();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o objeto realator do objeto item pauta é
     * alterado.
     */
    @Test
    public void testSetRelator() {
        System.out.println("Test setRelator");
        Relator relator = new Relator();
        ItemPauta instance = new ItemPauta();
        instance.setRelator(relator);
        Relator result = instance.getRelator();
        assertEquals(relator, result);
    }

    /**
     * Teste Negativo: Testa se o objeto realator do objeto item pauta é
     * alterado para null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRelatorNull() {
        System.out.println("Test setRelatorNull");
        Relator relator = null;
        ItemPauta instance = new ItemPauta();
        instance.setRelator(relator);
        fail("Foi possivel mudar o relator de um item pauta para null");
    }

    /**
     * Teste Positivo: Testa se o id retornado do objeto item pauta está
     * correto.
     */
    @Test
    public void testGetId() {
        System.out.println("Test getId");
        ItemPauta instance = new ItemPauta();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o id do objeto item pauta é alterado.
     */
    @Test
    public void testSetId() {
        System.out.println("Test setId");
        int id = 0;
        ItemPauta instance = new ItemPauta();
        instance.setId(id);
        int result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Teste Positivo: Testa se o objeto item pauta já foi votado.
     */
    @Test
    public void testIsVotada() {
        System.out.println("Test isVotada");
        ItemPauta instance = new ItemPauta();
        boolean expResult = false;
        boolean result = instance.isVotada();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o valor de votado do objeto item pauta é
     * alterado.
     */
    @Test
    public void testSetVotada() {
        System.out.println("Test setVotada");
        boolean votada = true;
        ItemPauta instance = new ItemPauta();
        instance.setVotada(votada);
        boolean result = instance.isVotada();
        assertEquals(votada, result);
    }

}
