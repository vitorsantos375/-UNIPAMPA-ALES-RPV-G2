/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model.repository;

import com.rpvg2.model.Relator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherm Bolfe
 */
public class RelatorRepositoryTest {

    public RelatorRepositoryTest() {
    }

    /**
     * Teste Positivo: Testa se o objeto relator é criado corretamente sem o id.
     */
    @Test
    public void testCriarNovoObjeto() {
        System.out.println("Test criarNovoObjeto");
        String[] valores = new String[1];
        valores[0] = "Guilherme Bolfe";
        RelatorRepository instance = new RelatorRepository();
        Relator result = instance.criarNovoObjeto(valores);
        assertEquals(valores[0], result.getNome());
    }

    /**
     * Teste Negativo: Testa se o objeto relator é criado corretamente sem o id,
     * com valores null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoValoresNull() {
        System.out.println("Test criarNovoObjetoValoresNull");
        String[] valores = new String[1];
        valores[0] = null;
        RelatorRepository instance = new RelatorRepository();
        instance.criarNovoObjeto(valores);
        fail("Foi possivel criar um objeto com valores null");
    }

    /**
     * Teste Negativo: Testa se o objeto relator é criado sem o id, com valor
     * null.
     */
    @Test(expected = RuntimeException.class)
    public void testCriarNovoObjetoValorNull() {
        System.out.println("Test criarNovoObjetoValorNull");
        String[] valores = null;
        RelatorRepository instance = new RelatorRepository();
        instance.criarNovoObjeto(valores);
        fail("Foi possivel criar um objeto com valor null");
    }

    /**
     * Teste Positivo: Testa se o objeto relator é criado corretamente com id.
     */
    @Test
    public void testCriarObjetoComId() {
        System.out.println("Test criarObjetoComId");
        String[] valores = new String[2];
        valores[0] = "0";
        valores[1] = "Guilherme Bolfe";
        RelatorRepository instance = new RelatorRepository();
        Relator result = instance.criarObjetoComId(valores);
        assertEquals(Integer.parseInt(valores[0]), result.getId());
        assertEquals(valores[1], result.getNome());
    }

    /**
     * Teste Negativo: Testa se o objeto relator com valores null é criado.
     */
    @Test(expected = RuntimeException.class)
    public void testCriarObjetoComIdValoresNull() {
        System.out.println("Test criarObjetoComIdValoresNull");
        String[] valores = new String[2];
        valores[0] = null;
        valores[1] = null;
        RelatorRepository instance = new RelatorRepository();
        instance.criarObjetoComId(valores);
        fail("Foi possivel criar um objeto com valores null");
    }

    /**
     * Teste Negativo: Testa se o objeto relator com valor null é criado.
     */
    @Test(expected = RuntimeException.class)
    public void testCriarObjetoComIdValorNull() {
        System.out.println("Test criarObjetoComIdValorNull");
        String[] valores = null;
        RelatorRepository instance = new RelatorRepository();
        instance.criarObjetoComId(valores);
        fail("Foi possivel criar um objeto com valor null");
    }
}
