package com.eldermoraes.cliente;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {
    
    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("newCliente")
    public Response newCliente(){
        Cliente cliente = Cliente.of(99, "Remoto");
        Response response = clienteService.newCliente(cliente);

        return Response.status(Status.CREATED).entity(response).build();
    }
}
