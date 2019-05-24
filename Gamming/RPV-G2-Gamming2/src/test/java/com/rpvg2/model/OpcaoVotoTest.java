package com.rpvg2.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilis
 */
public class OpcaoVotoTest {

    /**
     * Test do get e set descrição com valor válido
     */
    @Test
    public void testGetSetDescricaoValido() {
        OpcaoVoto op = new OpcaoVoto();
        String aux = "descrição legal";

        op.setDescricao(aux);

        assertEquals(aux, op.getDescricao());
    }

    /**
     * Test do set descrição com valor invalido (null)
     */
    @Test(expected = RuntimeException.class)
    public void testSetDescricaoInvalidoNull() {
        OpcaoVoto op = new OpcaoVoto();

        op.setDescricao(null);
    }

    /**
     * Test do set descrição com valor invalido (somente com espaços em branco)
     */
    @Test(expected = RuntimeException.class)
    public void testSetDescricaoInvalidoSomenteEspacos() {
        OpcaoVoto op = new OpcaoVoto();
        String aux = "      ";

        op.setDescricao(aux);
    }

    /**
     * Test do set descrição com valor invalido (string vazia)
     */
    @Test(expected = RuntimeException.class)
    public void testSetDescricaoInvalidoStringVazia() {
        OpcaoVoto op = new OpcaoVoto();
        String aux = "";

        op.setDescricao(aux);
    }

    /**
     * Teste do metodo equals valido
     */
    @Test
    public void testEqualsValido() {
        OpcaoVoto op1 = new OpcaoVoto("opcao");
        OpcaoVoto op2 = new OpcaoVoto("opcao");

        assertTrue(op1.equals(op2));
    }

    /**
     * Teste do metodo equals invalido
     */
    @Test
    public void testEqualsInvalido() {
        OpcaoVoto op1 = new OpcaoVoto("opcao2");
        OpcaoVoto op2 = new OpcaoVoto("opcao");

        assertFalse(op1.equals(op2));
    }

}
