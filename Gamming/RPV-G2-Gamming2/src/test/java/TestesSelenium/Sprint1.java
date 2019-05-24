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
public class Sprint1 extends TestCase_dados {

    public static String url = "http://localhost:8080/RPV-G2-Gamming2/index.xhtml";

    @Before
    public void beforeMethod() throws MalformedURLException {
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testeclique() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();

            if (webDriver.findElement(By.xpath("/html/body/h1")).getText().equals("Perfil do professor para substituir Kepler,João Pablo")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @Test
    public void testecustomizada() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:custom\"]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]")).getText().equals("Segundo Turno:")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @Test
    public void testesegundoturno() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt20\"]/div[3]")).click();
            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt20\"]/div[2]/span")).getText().equals("on")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @Test
    public void testeescreverresposta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste escrita de resposta");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt15\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:o_list\"]/li[1]")).getText().equals("Teste escrita de resposta")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @Test
    public void testeretornasimples() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[1]/a")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt10_list\"]/li[1]")).getText().equals("Favorável")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @Test
    public void testerespostavazia() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Escrever e apagar");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).clear();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt15\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:o_list\"]/li[1]")).getText().equals("")) {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
    @Test
    public void testelimpacampo() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste limpa campo");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt15\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).getText().equals("")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    @After
    public void afterMethod() {
        webDriver.close();
    }

}
