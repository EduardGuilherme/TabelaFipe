package com.fipe.api.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/fipe")
public class FipeController {

    @Inject
    FipeService fipeService;

    @POST
    @Path("/load-initial")
    public Response triggerInitialLoad() {
        fipeService.triggerBrandsLoad();
        return Response.accepted().build();
    }

    @GET
    @Path("/marcas")
    public List<String> getMarcas() {
        return fipeService.getMarcas();
    }

    @GET
    @Path("/veiculos/{marca}")
    public List<Veiculo> getVeiculosByMarca(@PathParam("marca") String marca) {
        return fipeService.getVeiculosByMarca(marca);
    }

    @PUT
    @Path("/veiculos")
    public Response updateVeiculo(VeiculoUpdateDTO dto) {
        fipeService.updateVeiculo(dto.codigo, dto.modelo, dto.observacoes);
        return Response.ok().build();
    }
}