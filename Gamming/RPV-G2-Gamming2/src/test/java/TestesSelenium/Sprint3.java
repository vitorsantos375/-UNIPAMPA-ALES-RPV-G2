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
public class Sprint3 extends TestCase_dados {

    /**
     *
     * Os testes que começam como "testemoderador" se referem aos testes das
     * telas de moderador, os testes que começam como "testemembro" se referem
     * aos testes das telas de membro.
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

    // Classe para testes do Sprint III.
    // Alguns testes tiveram de ser realizados novamente devido as mudanças na interface.
    /**
     * Teste para verificar se o login exibe mensagem de erros com login
     * incorreto.
     *
     * @throws Exception
     */
    @Test
    public void testemembrologin() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]/span[2]")).click();

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
     * Teste para verificar se o membro recebe as opções de voto com uma votação
     * iniciada.
     *
     * @throws Exception
     */
    @Test
    public void testemembroreuniaodisponivel() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt11_header\"]/span")).getText().equals(" Votando - Perfil docente para concurso em Engenharia de Software")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

     /**
     * Teste para verificar o funcionamento do voto do membro.
     *
     * @throws Exception
     */
    @Test
    public void testemembrovotasimples() throws Exception {
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
            

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt11_header\"]/span")).getText().equals("Voto contabilizado com sucesso")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
    /**
     * Teste para verificar se existe uma opção de cancelamento ao selecionar
     * uma reunião indesejada.
     *
     * @throws Exception
     */
    @Test
    public void testemembrocancelareu() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9:0:j_idt11\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt15\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt7_header\"]/span")).getText().equals("Selecione a reunião na qual deseja participar")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o login exibe mensagem de erros com login
     * incorreto.
     *
     * @throws Exception
     */
    @Test
    public void testemembrologinincorreto() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Felipi Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/span")).getText().equals("Error!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o login exibe mensagem de erros com login vazio.
     *
     * @throws Exception
     */
    @Test
    public void testemembrologinvazio() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("Escreve e deleta");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).clear();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/span")).getText().equals("Error!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o login exibe mensagem de erros com login
     * numérico.
     *
     * @throws Exception
     */
    @Test
    public void testemembrologinnumeros() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:nomeUsuario\"]")).sendKeys("16115");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt12\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/span")).getText().equals("Error!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar a escrita de resposta em um encaminhamento
     * customizado.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadoresposta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("/html/body/a[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste resposta 3");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste resposta 2");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]/span")).click();

            if (webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Terminar</span>")).getText().equals("Terminar")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o funcionamento da nova interface.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorsimples() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt32\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt35\"]/span[2]")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Sim</span>")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Votação Encerrada!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o funcionamento da nova interface.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorcustomizada() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta 1");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta 2");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta 3");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt32\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt35\"]/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt38:j_idt51\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt35\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Votação Encerrada!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

     /**
     * Teste para verificar a disposição dos resultados da votação.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorresultados() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt32\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt35\"]/span[2]")).click();     
            
            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt54:j_idt59:j_idt69_data\"]/tr/td[2]")).getText().equals("Favorável")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }
    
    /**
     * Teste para verificar o cadastro de respostas iguais.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadormesmaresposta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta igual");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta igual");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Opção de voto já cadastrada!!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o cadastro de respostas vazias.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorrespostavazia() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt9:j_idt10\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).sendKeys("Resposta vazia");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:opcaoVoto\"]")).clear();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt16:j_idt22\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Opção de Voto Vazia!!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se após cancelar o encaminhamento retorna a nova
     * tela inicial.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorcancel() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt25\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt27\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/div")).getText().equals("Itens Pauta")) {
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
