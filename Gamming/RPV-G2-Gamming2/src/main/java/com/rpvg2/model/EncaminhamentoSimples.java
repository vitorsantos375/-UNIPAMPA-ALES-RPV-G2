package com.rpvg2.model;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Giliardi Schmidt
 */
@ManagedBean
@ApplicationScoped
public class EncaminhamentoSimples extends Encaminhamento implements Serializable {

    public EncaminhamentoSimples() {
        super();
        this.opcoesVoto.add(new OpcaoVoto("Favorável"));
        this.opcoesVoto.add(new OpcaoVoto("Contrário"));
        this.opcoesVoto.add(new OpcaoVoto("Abstenção"));
    }
}
