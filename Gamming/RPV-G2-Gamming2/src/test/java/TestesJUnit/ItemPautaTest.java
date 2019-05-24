package TestesJUnit;

import com.rpvg2.model.ItemPauta;
import com.rpvg2.model.Relator;
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
public class ItemPautaTest {

    public ItemPautaTest() {
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

    //Testes Negativos
    
    /**
     * Teste falso SetDescricao.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoNull() {
        System.out.println("Test setDescricaoNull");
        String descricao = null;
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        fail("A descrição de um item pauta foi alterada para null");
    }

    /**
     * Teste falso setID.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetIdNull() {
        System.out.println("Test setIdNull");
        int id = 0;
        ItemPauta instance = new ItemPauta();
        instance.setId(id);
        fail("O ID do item pauta foi alterado para null");
    }

    /**
     * Teste falso setID.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRelatorNull() {
        System.out.println("Test setRelatorNull");
        Relator relator = null;
        ItemPauta instance = new ItemPauta();
        instance.setRelator(relator);
        fail("O relator de um item pauta foi alterado para null");
    }

    /**
     * Teste falso SetDescricao.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDescricaoVazia() {
        System.out.println("Test setDescricaoVazia");
        String descricao = "";
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        fail("A descrição de um item pauta foi alterada para vazio");
    }

    //Testes Positivos
    /**
     * Test of getDescricao method, of class ItemPauta.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("Test getDescricao");
        ItemPauta instance = new ItemPauta();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescricao method, of class ItemPauta.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("Test setDescricao");
        String descricao = "";
        ItemPauta instance = new ItemPauta();
        instance.setDescricao(descricao);
        assertEquals(descricao, instance.getDescricao());

    }

    /**
     * Test of getRelator method, of class ItemPauta.
     */
    @Test
    public void testGetRelator() {
        System.out.println("Test getRelator");
        ItemPauta instance = new ItemPauta();
        Relator expResult = new Relator();
        Relator result = instance.getRelator();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRelator method, of class ItemPauta.
     */
    @Test
    public void testSetRelator() {
        System.out.println("Test setRelator");
        Relator relator = new Relator();
        ItemPauta instance = new ItemPauta();
        instance.setRelator(relator);
        assertEquals(relator, instance.getRelator());

    }

    /**
     * Test of getId method, of class ItemPauta.
     */
    @Test
    public void testGetId() {
        System.out.println("Test getId");
        ItemPauta instance = new ItemPauta();
        instance.setId(0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class ItemPauta.
     */
    @Test
    public void testSetId() {
        System.out.println("Test setId");
        int id = 0;
        ItemPauta instance = new ItemPauta();
        instance.setId(id);
        assertEquals(id, instance.getId());

    }

    /**
     * Test of isVotada method, of class ItemPauta.
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
     * Test of setVotada method, of class ItemPauta.
     */
    @Test
    public void testSetVotada() {
        System.out.println("Test setVotada");
        boolean votada = true;
        ItemPauta instance = new ItemPauta();
        boolean result = instance.isVotada();
        assertEquals(votada, result);
    }

}
