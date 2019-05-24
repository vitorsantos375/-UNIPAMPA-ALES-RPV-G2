package TestesSelenium;

import ConfiguracaoSelenium.TestCase_dados;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Filipe
 */
// Nesta classe será codificado o script selenium para apresentação do Sprint IV.
public class Apresentacao extends TestCase_dados {

    public static String url = "http://localhost:8080/RPV-G2-Gamming2/";

    /**
     * Limpa os cookies e libera o navegador para os testes.
     *
     * @throws MalformedURLException
     */
    @Before
    public void beforeMethod() throws MalformedURLException {
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Script para abrir votação simples.
     *
     * @throws Exception
     */
    @Test
    public void iniciarVotacaoSimples() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();  
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt36\"]/span[2]")).click();     
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt39\"]/span[2]")).click();  

            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt42:j_idt43:listaVotosPrimeiroTurno\"]/div[1]")).getText().equals("Membros que Votaram no Primeiro Turno")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Script para abrir votação customizada.
     *
     * @throws Exception
     */
    @Test
    public void iniciarVotacaoCustomizada() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();  
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            sleep();          
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:opcaoVoto\"]")).sendKeys("Resposta customizada X");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:j_idt26\"]/span[2]")).click();            
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:opcaoVoto\"]")).sendKeys("Resposta customizada Y");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:j_idt26\"]/span[2]")).click();   
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:opcaoVoto\"]")).sendKeys("Resposta customizada Z");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt20:j_idt26\"]/span[2]")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt36\"]/span[2]")).click(); 
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt39\"]/span[2]")).click(); 
            
            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt42:j_idt43:listaVotosPrimeiroTurno\"]/div[1]")).getText().equals("Membros que Votaram no Primeiro Turno")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
     /**
     * Script para membro se registrar em votação.
     *
     * @throws Exception
     */
    @Test
    public void membroregistra() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[7]/a/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt14:j_idt15:0:j_idt17\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt14:j_idt20\"]/span[2]")).click();
            
            

            if (webDriver.findElement(By.xpath("///*[@id=\"j_idt19\"]")).getText().equals("Aguardando uma nova votação...")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
     /**
     * Script para executar funções de secretário sobre Reunioes.
     *
     * @throws Exception
     */
    @Test
    public void secretarioreunioes() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[5]/a/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            // Definir ações para apresentação
            
            

            if (webDriver.findElement(By.xpath("///*[@id=\"j_idt19\"]")).getText().equals("Aguardando uma nova votação...")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
    /**
     * Script para executar funções de secretário sobre itemPauta.
     *
     * @throws Exception
     */
    @Test
    public void secretarioitempauta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[4]/a/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            // Definir ações para apresentação
            

            if (webDriver.findElement(By.xpath("///*[@id=\"j_idt19\"]")).getText().equals("Aguardando uma nova votação...")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     *
     * Fecha o webdriver após os testes.
     */
    @After
    public void afterMethod() {
        webDriver.close();
    }

}
