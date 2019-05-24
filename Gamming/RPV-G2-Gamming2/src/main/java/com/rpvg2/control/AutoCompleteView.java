package com.rpvg2.control;

import com.rpvg2.model.Relator;
import com.rpvg2.model.repository.RelatorRepository;
import com.rpvg2.view.MensagensView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutoCompleteView {

    private Relator relator;

    public List<Relator> completeText(String query) {
        List<Relator> relatores = new ArrayList<>();
        List<Relator> result = new ArrayList<>();
        try {
            if (!query.trim().isEmpty() && query != null) {
                result = new RelatorRepository().recuperarTodosObjetos();
                for (Relator relator : result) {
                    if (relator.getNome().toLowerCase().contains(query.toLowerCase())) {
                        relatores.add(relator);
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            new MensagensView().criarMensagemError(ex.getMessage());
        }
        return relatores;
    }

    public Relator getRelator() {
        return relator;
    }

    public void setRelator(Relator relator) {
        this.relator = relator;
    }

}
