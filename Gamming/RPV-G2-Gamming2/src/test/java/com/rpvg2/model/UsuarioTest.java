/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherm Bolfe
 */
public class UsuarioTest {

    public UsuarioTest() {
    }

    /**
     * Teste Positivo: Testa se um usuario é secretario.
     */
    @Test
    public void testIsSecretario() {
        System.out.println("Test isSecretario");
        Usuario instance = new Usuario();
        instance.setSecretario(true);
        boolean result = instance.isSecretario();
        assertTrue(result);
    }

    /**
     * Teste Positivo: Testa se um usuario não é secretario.
     */
    @Test
    public void testNoIsSecretario() {
        System.out.println("Test NoisSecretario");
        Usuario instance = new Usuario();
        instance.setSecretario(false);
        boolean result = instance.isSecretario();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o atributo secretario pode ser alterado
     */
    @Test
    public void testSetSecretario() {
        System.out.println("Test setSecretario");
        Usuario instance = new Usuario();
        instance.setSecretario(false);
        boolean result = instance.isSecretario();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o usuario é membro.
     */
    @Test
    public void testIsMembro() {
        System.out.println("Test isMembro");
        Usuario instance = new Usuario();
        instance.setMembro(true);
        boolean result = instance.isMembro();
        assertTrue(result);
    }

    /**
     * Teste Positivo: Testa se o usuario não é membro.
     */
    @Test
    public void testNoIsMembro() {
        System.out.println("Test isMembro");
        Usuario instance = new Usuario();
        instance.setMembro(false);
        boolean result = instance.isMembro();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o atributo membro pode ser alterado.
     */
    @Test
    public void testSetMembro() {
        System.out.println("Test setMembro");
        boolean membro = false;
        Usuario instance = new Usuario();
        instance.setMembro(membro);
        boolean result = instance.isMembro();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o usuario é moderador.
     */
    @Test
    public void testIsModerador() {
        System.out.println("Test isModerador");
        Usuario instance = new Usuario();
        instance.setModerador(true);
        boolean result = instance.isModerador();
        assertTrue(result);
    }

    /**
     * Teste Positivo: Testa se o usuario não é moderador.
     */
    @Test
    public void testNoIsModerador() {
        System.out.println("Test isModerador");
        Usuario instance = new Usuario();
        instance.setModerador(false);
        boolean result = instance.isModerador();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o atributo moderador pode ser alterado.
     */
    @Test
    public void testSetModerador() {
        System.out.println("Test setModerador");
        boolean moderador = false;
        Usuario instance = new Usuario();
        instance.setModerador(moderador);
        boolean result = instance.isModerador();
        assertFalse(result);
    }

    /**
     * Teste Positivo: Testa se o nome correto é retornado.
     */
    @Test
    public void testGetNome() {
        System.out.println("Test getNome");
        Usuario instance = new Usuario();
        String expResult = "Guilherme Bolfe";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o nome pode ser alterado.
     */
    @Test
    public void testSetNome() {
        System.out.println("Test setNome");
        Usuario instance = new Usuario();
        String expResult = "Guilherme Bolfe";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste Negativo: Testa se o nome pode ser alterado.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNomeNeg() {
        System.out.println("Test setNomeNeg");
        Usuario instance = new Usuario();
        String expResult = "";
        instance.setNome(expResult);
    }

    /**
     * Teste Negativo: Testa se o nome pode ser alterado.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNomeNull() {
        System.out.println("Test setNomeNull");
        Usuario instance = new Usuario();
        String expResult = null;
        instance.setNome(expResult);
    }

    /**
     * Teste Positivo: Testa se o metodo retorna o id correto.
     */
    @Test
    public void testGetId() {
        System.out.println("Test getId");
        Usuario instance = new Usuario();
        int expResult = 0;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o metodo altera o id.
     */
    @Test
    public void testSetId() {
        System.out.println("Test setId");
        Usuario instance = new Usuario();
        int expResult = 0;
        instance.setId(expResult);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Teste Positivo: Testa se o metodo equals retorna o resultado correto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Usuario obj = new Usuario();
        obj.setNome("Guilherme Bolfe");
        Usuario instance = new Usuario();
        instance.setNome("Guilherme Bolfe");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
