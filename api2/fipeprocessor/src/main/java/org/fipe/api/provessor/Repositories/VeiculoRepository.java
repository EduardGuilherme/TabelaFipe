package org.fipe.api.provessor.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VeiculoRepository implements PanacheRepository<Veiculo> {

    public List<Veiculo> findByMarca(String marca) {
        return list("marca", marca);
    }

    public void updateModeloEObservacoes(String codigo, String modelo, String observacoes) {
        update("modelo = ?1, observacoes = ?2 where codigo = ?3", modelo, observacoes, codigo);
    }
}
