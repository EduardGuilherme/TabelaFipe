package org.fipe.api.provessor.Consumers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class MarcaConsumer {

    @Inject
    FipeClient fipeClient;

    @Inject
    VeiculoRepository veiculoRepository;

    @Incoming("marcas-in")
    public void processMarca(String codigoMarca) {
        ModelosWrapper modelosWrapper = fipeClient.getModelos(codigoMarca);

        modelosWrapper.getModelos().forEach(modelo -> {
            Veiculo veiculo = new Veiculo();
            veiculo.codigo = modelo.getCodigo();
            veiculo.marca = codigoMarca;
            veiculo.modelo = modelo.getNome();
            veiculoRepository.persist(veiculo);
        });
    }
}
