/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesJUnit;

import com.rpvg2.util.StringUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor Ribeiro
 */

public class StringTest {

    public StringTest() {
    }

    @Test
    public void testStringVazia() {
        System.out.println("Test String Vazia");
        String nome = "";
        assertEquals(true, StringUtil.verificaStringVazia(nome));

    }
    
    @Test
    public void testStringCheia() {
    System.out.println("Test String Vazia");
    String nome = " ";
    assertEquals(true, StringUtil.verificaStringVazia(nome));

    }
    
    @Test
    public void testStringComNome() {
    System.out.println("Test String Vazia");
    String nome = "Victor Ribeiro";
    assertEquals(false, StringUtil.verificaStringVazia(nome));

    }

}
