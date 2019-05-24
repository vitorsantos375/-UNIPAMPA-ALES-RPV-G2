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
public class Sprint2 extends TestCase_dados {

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

    /**
     * Teste para verificar se é possível adicionar a mesma opção de voto.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadormesmaresposta() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste mesma resposta");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]")).sendKeys("Teste mesma resposta");
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:j_idt14\"]/span")).click();

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
     * Teste para verificar se a opção de abstenção pode ser excluída no
     * encaminhamento customizado.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorexcluirabstencao() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:datalistEC:0:j_idt19\"]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"msg_container\"]/div/div/div[2]/p")).getText().equals("Está opção de voto não pode ser removida!!")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se a opção de abstenção foi adicionada como padrão
     * no encaminhamento customizado.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorabstencao() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8:datalistEC_list\"]/li")).getText().equals("Abstenção")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se é exibida confirmação para encaminhar para a
     * votação.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorconfirmaenc() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt24\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt26\"]/div[2]/span[2]")).getText().equals("Encaminhar para votação?")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se é exibida confirmação para cancelar o
     * encaminhamento.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorconfirmacan() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt25\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt26\"]/div[2]/span[2]")).getText().equals("Cancelar Encaminhamento?")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se após cancelar o encaminhamento retorna a tela
     * principal.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorcancelar() throws Exception {
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
     * Teste para verificar se os resultados foram adicionados a tela de
     * votação.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorresultados() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]")).click();

            if (webDriver.findElement(By.xpath("/html/body/h3")).getText().equals("Resultados da Votação")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o encaminhamento funciona corretamente.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorencaminhamento() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt24\"]/span")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Sim</span>")).click();

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
     * Teste para verificar a confirmação do término do encaminhamento.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorconfenc() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt24\"]/span")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Sim</span>")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Terminar</span>")).click();

            if (webDriver.findElement(By.xpath("<span class=\"ui-confirm-dialog-message\">Terminar Votação?</span>")).getText().equals("Terminar Votação?")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar confirmação para cancelar o encaminhamento.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorterminoenc() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li[1]/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt24\"]/span")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Sim</span>")).click();
            webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Cancelar</span>")).click();

            if (webDriver.findElement(By.xpath("<span class=\"ui-button-text ui-c\">Sim</span>")).getText().equals("Sim")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se são exibidos os votos do primeiro e segundo
     * turno.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorsegturno() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Respota x");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Resposta y");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt24\"]/div[3]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt25\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt28\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt31:listaVotosSegundoTurno\"]/div[1]")).getText().equals("Membros que Votaram no Segundo Turno")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o nome pode ser composto de números.
     *
     * @throws Exception
     */
    @Test
    public void testemembronomenumerico() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("1234");

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt26\"]/div[2]/span[2]")).getText().equals("1234")) {
                System.out.println("O teste falhou!");
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o nome pode ser vazio.
     *
     * @throws Exception
     */
    @Test
    public void testemembronomevazio() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("nome");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).clear();

            if (webDriver.findElement(By.xpath("//*[@id=\"form:j_idt26\"]/div[2]/span[2]")).getText().equals(" ")) {
                System.out.println("O teste falhou!");
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o membro deve aguardar até a votação ser
     * encaminhada.
     *
     * @throws Exception
     */
    @Test
    public void testemembroesperavotacao() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt9_header\"]/span")).getText().equals("Aguardando votação")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o membro tem acesso a votação encaminhada.
     *
     * @throws Exception
     */
    @Test
    public void testemembrovervotacao() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            // Após esta ação a outra tela de moderador encaminhou a votação.

            if (webDriver.findElement(By.xpath("/html/body/h3")).getText().equals(" Votando - Adicionar Física como CCCG do curso")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se é exibida a confirmação do voto.
     *
     * @throws Exception
     */
    @Test
    public void testemembroconfirmavoto() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:voto\"]/tbody/tr[1]/td/div/div[2]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt8\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt9\"]/div[2]/span[2]")).getText().equals("Confirme Seu Voto:")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o registro do voto de um membro, realizado no teste
     * "testemembrovoto". turno.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorresigtrovotomembro() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Respota x");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Resposta y");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt24\"]/div[3]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt25\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt48:listaVotosFinalPrimeiroTurno_data\"]/tr/td[1]")).getText().equals("Filipe Garcia")) {
                System.out.println("Teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o membro consegue efetuar seu voto.
     *
     * @throws Exception
     */
    @Test
    public void testemembrovota() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:voto\"]/tbody/tr[1]/td/div/div[2]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt8\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt10\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt5_header\"]/span")).getText().equals("Voto contabilizado com sucesso")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar se o membro após efetuar o seu voto, consegue ficar
     * pronto e aguardar a próxima votação.
     *
     * @throws Exception
     */
    @Test
    public void testemembroproximavotacao() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:voto\"]/tbody/tr[1]/td/div/div[2]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt8\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt10\"]/span[2]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt7\"]/span")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt9_header\"]/span")).getText().equals("Aguardando votação")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    //Os três testes abaixo foram realizados simultaneamente
    /**
     * Teste para verificar o a votação de mais de um membro com os votos
     * definidos nesse teste. turno.
     *
     * @throws Exception
     */
    @Test
    public void testemoderadorvotacao2mem() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5_list\"]/li[1]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"form:j_idt8\"]/ul/li[2]/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Teste votacao");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:opcaoVoto\"]")).sendKeys("Teste votacao 2 turno");
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt15\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt9:j_idt24\"]/div[3]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt25\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"dashboard:form:j_idt28\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"dashboard:j_idt36:listaVotosSegundoTurno_data\"]/tr/td")).getText().equals("No records found.")) {
                System.out.println("O teste falhou!");
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o segundo turno funciona corretamente com dois ou
     * mais membros (Teste utilizado simultaneamente).
     *
     * @throws Exception
     */
    @Test
    public void testemembrovoto1() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Filipe Garcia");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:voto\"]/tbody/tr[3]/td/div/div[2]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt8\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt10\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt9_header\"]/span")).getText().equals("Aguardando votação")) {
                System.out.println("O teste passou!");
            } else {
                Assert.fail("O teste falhou!");
            }
        } catch (Exception e) {
            Assert.fail("Erro no sistema");
        }
    }

    /**
     * Teste para verificar o segundo turno funciona corretamente com dois ou
     * mais membros (Teste utilizado simultaneamente).
     *
     * @throws Exception
     */
    @Test
    public void testemembrovoto2() throws Exception {
        try {
            webDriver.get(url);
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt8:nomeUsuario\"]")).sendKeys("Guilherme Bolfe");
            webDriver.findElement(By.xpath("//*[@id=\"j_idt5:j_idt6\"]/div/div/ul/li/table/tbody/tr/td/a")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:voto\"]/tbody/tr[3]/td/div/div[2]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt8\"]/span")).click();
            webDriver.findElement(By.xpath("//*[@id=\"j_idt6:j_idt10\"]/span[2]")).click();

            if (webDriver.findElement(By.xpath("//*[@id=\"j_idt9_header\"]/span")).getText().equals("Aguardando votação")) {
                System.out.println("O teste passou!");
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
