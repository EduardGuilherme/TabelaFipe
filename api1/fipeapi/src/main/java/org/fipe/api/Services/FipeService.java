package com.fipe.api.services;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FipeService {

    @Inject
    FipeClient fipeClient;

    @Inject
    VeiculoRepository veiculoRepository;

    @Channel("marcas-out")
    Emitter<String> marcasEmitter;

    public void triggerBrandsLoad() {
        List<Marca> marcas = fipeClient.getMarcas();
        marcas.forEach(marca -> marcasEmitter.send(marca.getCodigo()));
    }

    public List<String> getMarcas() {
        return veiculoRepository.listAll().stream()
                .map(v -> v.marca)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Veiculo> getVeiculosByMarca(String marca) {
        return veiculoRepository.findByMarca(marca);
    }

    public void updateVeiculo(String codigo, String modelo, String observacoes) {
        veiculoRepository.updateModeloEObservacoes(codigo, modelo, observacoes);
    }
}