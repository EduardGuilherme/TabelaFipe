package org.fipe.api.Clients;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/v1")
@RegisterRestClient(configKey = "fipe-api")
public interface FipeClient {

    @GET
    @Path("/carros/marcas")
    List<Marca> getMarcas();

    @GET
    @Path("/carros/marcas/{codigo}/modelos")
    ModelosWrapper getModelos(@PathParam("codigo") String codigoMarca);
}