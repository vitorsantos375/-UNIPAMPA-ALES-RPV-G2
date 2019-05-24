package com.rpvg2.control;

import Configuracao.JUnitTestReflectionBase;
import com.rpvg2.model.EncaminhamentoCustomizado;
import com.rpvg2.model.OpcaoVoto;
import com.rpvg2.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Giliardi Schmidt
 */
public class VotacaoControllerTest extends JUnitTestReflectionBase {

    private void adicionarVotos(VotacaoController controller) throws Exception {
        EncaminhamentoCustomizado c = new EncaminhamentoCustomizado();
        setAtributo(controller, "encaminhamentoEmVotacao", c);

        OpcaoVoto op1 = new OpcaoVoto("opcao 1");
        OpcaoVoto op2 = new OpcaoVoto("opcao 2");
        OpcaoVoto op3 = new OpcaoVoto("opcao 3");

        Usuario us1 = new Usuario();
        us1.setNome("User 1");
        Usuario us2 = new Usuario();
        us2.setNome("User 2");
        Usuario us3 = new Usuario();
        us3.setNome("User 3");

        Map<Usuario, OpcaoVoto> votos = new HashMap<>();
        votos.put(us1, op1);
        votos.put(us2, op2);
        votos.put(us3, op3);
        setAtributo(controller, "votosPrimeiroTurno", votos);

        votos = new HashMap<>();
        votos.put(us1, op3);
        votos.put(us2, op2);
        votos.put(us3, op1);

        setAtributo(controller, "votosSegundoTurno", votos);
    }

    /**
     * Testa se retorna todos os votos computados do primeiro turno
     *
     * @throws Exception
     */
    @Test
    public void testGetNumeroVotosPorOpcaoPrimeiroTurno() throws Exception {
        VotacaoController controller = new VotacaoController();

        adicionarVotos(controller);

        Map<OpcaoVoto, Long> map = controller.getNumeroVotosPorOpcaoPrimeiroTurno();

        Collection<Long> values = map.values();
        for (Long value : values) {
            System.out.println(value);
            if (value > 1) {
                fail("A contagem dos votos não está funcionando corretamente.");
            }
        }

    }

    /**
     * Testa se retorna todos os votos computados do segundo turno
     *
     * @throws Exception
     */
    @Test
    public void testGetNumeroVotosPorOpcaoSegundoTurno() throws Exception {
        VotacaoController controller = new VotacaoController();

        adicionarVotos(controller);

        Map<OpcaoVoto, Long> map = controller.getNumeroVotosPorOpcaoSegundoTurno();

        Collection<Long> values = map.values();
        for (Long value : values) {
            if (value != 1) {
                fail("A contagem dos votos não está funcionando corretamente.");
            }
        }

    }

    /**
     * Testa se a votação é finalizada após ser cancelada
     */
    @Test
    public void testCancelarVotacao() {
        VotacaoController controller = new VotacaoController();
        setAtributo(controller, "votacaoAberta", true);
        setAtributo(controller, "votacaoCancelada", false);
        
        //PushChannel sempre vai ser null
        try {
            controller.cancelarVotacao();
        }catch(Exception e){
            
        }

        assertEquals(controller.isVotacaoAberta(), false);
        assertEquals(controller.isVotacaoCancelada(), true);

    }

}
