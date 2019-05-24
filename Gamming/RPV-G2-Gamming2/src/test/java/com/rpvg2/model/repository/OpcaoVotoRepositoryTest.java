/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model.repository;

import com.rpvg2.model.OpcaoVoto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherm Bolfe
 */
public class OpcaoVotoRepositoryTest {

    public OpcaoVotoRepositoryTest() {
    }

    /**
     * Test Negativo: Criar Objeto sem Id com valor Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoNULL() {
        System.out.println("Tesr criarNovoObjetoNULL");
        String[] valores = null;
        OpcaoVotoRepository instance = new OpcaoVotoRepository();
        instance.criarNovoObjeto(valores);
    }

    /**
     * Test Negativo: Criar Objeto sem Id com valores Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoValNull() {
        System.out.println("Test criarNovoObjetoVaNull");
        String[] valores = new String[1];
        valores[0] = null;
        OpcaoVotoRepository instance = new OpcaoVotoRepository();
        instance.criarNovoObjeto(valores);
    }

    /**
     * Test Negativo: Criar Objeto com Id com valor Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoIDNULL() {
        System.out.println("Tesr criarNovoObjetoIDNULL");
        String[] valores = null;
        OpcaoVotoRepository instance = new OpcaoVotoRepository();
        instance.criarObjetoComId(valores);
    }

    /**
     * Test Negativo: Criar Objeto com Id com valores Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoIDValNull() {
        System.out.println("Test criarNovoObjetoIDVaNull");
        String[] valores = new String[2];
        valores[0] = null;
        valores[1] = null;
        OpcaoVotoRepository instance = new OpcaoVotoRepository();
        instance.criarObjetoComId(valores);
    }
}
