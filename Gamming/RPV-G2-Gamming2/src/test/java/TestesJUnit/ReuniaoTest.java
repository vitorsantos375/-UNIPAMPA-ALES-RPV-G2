/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesJUnit;

import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.Reuniao;
import com.rpvg2.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Filipe
 */
@Ignore
public class ReuniaoTest {

    public ReuniaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDescricao method, of class Reuniao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("Test getDescricao");
        Reuniao instance = new Reuniao("Reuniao RP", true, null, null);
        String expResult = "Reuniao RP";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class Reuniao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("Test setDescricao");
        String descricao = "Reuniao RP";
        Reuniao instance = new Reuniao("", true, null, null);
        instance.setDescricao(descricao);
        assertEquals("Reuniao RP", instance.getDescricao());
    }

    /**
     * Test of isAberta method, of class Reuniao.
     */
    @Test
    public void testIsAberta() {
        System.out.println("Test isAberta");
        Reuniao instance = new Reuniao("", true, null, null);
        assertTrue(instance.isAberta());
    }

    /**
     * Test of setAberta method, of class Reuniao.
     */
    @Test
    public void testSetAberta() {
        System.out.println("Test setAberta");
        boolean aberta = true;
        Reuniao instance = new Reuniao("", false, null, null);
        instance.setAberta(aberta);
        assertTrue(instance.isAberta());
    }

    /**
     * Test of getEncaminhamentos method, of class Reuniao.
     */
    @Test
    public void testGetEncaminhamentos() {
        System.out.println("Test getEncaminhamentos");
        List<ItemPauta> expResult = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, expResult, null);
        assertEquals(expResult, instance.getEncaminhamentos());
    }

    /**
     * Test of getMembrosCadastrados method, of class Reuniao.
     */
    @Test
    public void testGetMembrosCadastrados() {
        System.out.println("Test getMembrosCadastrados");
        List<Usuario> expResult = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, null, expResult);
        assertEquals(expResult, instance.getMembrosCadastrados());
    }

    /**
     * Test of setItensPauta method, of class Reuniao.
     */
    @Test
    public void testSetItensPauta() {
        System.out.println("Test setItensPauta");
        List<ItemPauta> itensPauta = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, null, null);
        instance.setItensPauta(itensPauta);
        assertEquals(itensPauta, instance.getEncaminhamentos());
    }

    /**
     * Test of setMembrosCadastrados method, of class Reuniao.
     */
    @Test
    public void testSetMembrosCadastrados() {
        System.out.println("Test setMembrosCadastrados");
        List<Usuario> membros = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, null, null);
        instance.setMembrosCadastrados(membros);
        assertEquals(membros, instance.getMembrosCadastrados());
    }

    /**
     * Test of getMembrosRegistrados method, of class Reuniao.
     */
    @Test
    public void testGetMembrosRegistrados() {
        System.out.println("Test getMembrosRegistrados");
        List<Usuario> membros = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, null, membros);
        assertEquals(membros, instance.getMembrosRegistrados());
    }

    /**
     * Test of setMembrosRegistrados method, of class Reuniao.
     */
    @Test
    public void testSetMembrosRegistrados() {
        System.out.println("Test setMembrosRegistrados");
        List<Usuario> membros = new ArrayList<>();
        Reuniao instance = new Reuniao("", false, null, null);
        instance.setMembrosCadastrados(membros);
        assertEquals(membros, instance.getMembrosRegistrados());

    }

}
