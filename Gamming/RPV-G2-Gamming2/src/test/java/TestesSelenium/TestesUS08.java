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
@Ignore
public class TestesUS08 extends TestCase_dados {

    // Classe para testes do Sprint IV.   
    /**
     *
     * Os testes que começam como "testemoderador" se referem aos testes das
     * telas de moderador, os testes que começam como "testemembro" se referem
     * aos testes das telas de membro. Testes que começam como "testesecretario"
     * se referem aos testes das telas de secretário.
     */
    public static String url = "http://localhost:8080/RPV-G2-Gamming2/index.xhtml";

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
     * Teste para verificar o funcionamento do registro de item de pauta.
     *
     * @throws Exception
     */
    @Test
    public void testesecretarioregistraitempauta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[4]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:desc\"]")).sendKeys("Teste registro de Item Pauta");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_input\"]")).sendKeys("Ad");
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_panel\"]/ul/li")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:j_idt22\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Item de Pauta criado com sucesso!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o funcionamento do registro de item de pauta com um
     * relator não cadastrado.
     *
     * @throws Exception
     */
    @Test
    public void testesecretariorelatorerrado() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[4]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:desc\"]")).sendKeys("Teste registro de Item Pauta com relator errado");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_input\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:j_idt22\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Relator: Erro de validação: o valor é necessário.")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o funcionamento do registro de item de pauta sem
     * relator.
     *
     * @throws Exception
     */
    @Test
    public void testesecretarioregistrarvazio() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[4]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:desc\"]")).sendKeys("Teste registro de Item Pauta sem relator");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_input\"]")).sendKeys("");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:j_idt22\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Relator: Erro de validação: o valor é necessário.")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o funcionamento do registro de item de pauta sem
     * descrição
     *
     * @throws Exception
     */
    @Test
    public void testesecretarioregistrardescricaovazia() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt11\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt15\"]/span")).click();
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/ul/li[4]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt13:j_idt14\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:desc\"]")).sendKeys("Teste registro de Item Pauta sem descrição");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:desc\"]")).clear();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_input\"]")).sendKeys("Ad");
            sleep();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:relator_panel\"]/ul/li")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt18:j_idt22\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div[1]/div/div[2]/p")).getText().equals("A descrição não pode estar vazia!")) {
                System.out.println("Teste passou!");

            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
    

    /**
     * Teste para verificar se após a votação o membro retorna automaticamente a
     * tela inicial.
     *
     * @throws Exception
     */
    @Test
    public void testemembroretornaautomatico() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:voto\"]/tbody/tr[1]/td/label")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:confirmdialog\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:j_idt15\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt12\"]")).getText().equals("Aguardando uma nova votação...")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar interface atualizada de moderador.
     *
     * @throws Exception
     */
    @Test
    public void moderadorinterface() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:voto\"]/tbody/tr[1]/td/label")).click();

            if (webDriver.findElement(By.xpath("///*[@id=\"j_idt11_header\"]/span")).getText().equals("menu")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar interface atualizada de membro.
     *
     * @throws Exception
     */
    @Test
    public void testemembrointerface() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:voto\"]/tbody/tr[1]/td/label")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:confirmdialog\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt12:j_idt15\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt11_header\"]/span")).getText().equals("menu")) {
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
