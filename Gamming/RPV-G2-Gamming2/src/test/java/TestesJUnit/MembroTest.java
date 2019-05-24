/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesJUnit;

import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Usuario;
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
public class MembroTest {

    public MembroTest() {
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
     * Test of getNome method, of class Usuario.
     */
    @Test
    public void testGetNome() {
        System.out.println("Test getNome");
        Usuario instance = new Usuario();
        instance.setNome("Filipe Garcia");
        String expResult = "Filipe Garcia";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Usuario.
     */
    @Test
    public void testSetNome() {
        System.out.println("Test setNome");
        String nome = "Guilherme Bolfe";
        Usuario instance = new Usuario();
        instance.setNome(nome);
        assertEquals(instance.getNome(), nome);
    }

    /**
     * Teste setNome invalido (null)
     */
    @Test(expected = RuntimeException.class)
    public void testSetNomeInvalidoNull() {
        Usuario instance = new Usuario();
        instance.setNome(null);

        fail("Foi possivel setar o nome do usuario como null");
    }

    /**
     * Test do set descrição com valor invalido (string vazia)
     */
    @Test(expected = RuntimeException.class)
    public void testSetNomeInvalidoStringVazia() {
        OpcaoVoto op = new OpcaoVoto();
        String aux = "";

        op.setDescricao(aux);
    }

    /**
     * Teste setNome invalido (somente espaços em branco)
     */
    @Test(expected = RuntimeException.class)
    public void testSetNomeInvalidoSomenteEspacos() {
        String nome = "       ";
        Usuario instance = new Usuario();
        instance.setNome(nome);

        fail("Foi possivel setar o nome do usuario como somente espaços em branco");
    }

    /**
     * Test of getId method, of class Usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("Test getId");
        Usuario instance = new Usuario();
        instance.setId(0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("Test setId");
        int id = 0;
        Usuario instance = new Usuario();
        instance.setId(id);
        int expResult = 0;
        assertEquals(expResult, instance.getId());
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("Test equals null");
        Usuario obj = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsClass() {
        System.out.println("Test equals class");
        Object obj = new Object();
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsNome() {
        System.out.println("Test equals nome");
        Usuario obj = new Usuario();
        obj.setNome("Guilherme Bolfe");
        Usuario instance = new Usuario();
        instance.setNome("Filipe Garcia");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEqualsNomeIgual() {
        System.out.println("Test equals nome igual");
        Usuario obj = new Usuario();
        obj.setNome("Filipe Garcia");
        Usuario instance = new Usuario();
        instance.setNome("Filipe Garcia");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
