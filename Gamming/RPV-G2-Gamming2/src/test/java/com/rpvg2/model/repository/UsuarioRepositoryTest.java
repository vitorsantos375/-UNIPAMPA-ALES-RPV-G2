/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpvg2.model.repository;

import com.rpvg2.model.Usuario;
import java.util.List;
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
public class UsuarioRepositoryTest {

    public UsuarioRepositoryTest() {
    }

    /**
     * Test Negativo: Criar Objeto sem Id com valor Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoNULL() {
        System.out.println("Tesr criarNovoObjetoNULL");
        String[] valores = null;
        UsuarioRepository instance = new UsuarioRepository();
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
        UsuarioRepository instance = new UsuarioRepository();
        instance.criarNovoObjeto(valores);
    }

    /**
     * Test Negativo: Criar Objeto com Id com valor Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoIDNULL() {
        System.out.println("Tesr criarNovoObjetoIDNULL");
        String[] valores = null;
        UsuarioRepository instance = new UsuarioRepository();
        instance.criarObjetoComId(valores);
    }

    /**
     * Test Negativo: Criar Objeto com Id com valores Null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriarNovoObjetoIDValNull() {
        System.out.println("Test criarNovoObjetoIDVaNull");
        String[] valores = new String[5];
        valores[0] = null;
        valores[1] = null;
        valores[2] = null;
        valores[3] = null;
        valores[4] = null;
        UsuarioRepository instance = new UsuarioRepository();
        instance.criarObjetoComId(valores);
    }
}
