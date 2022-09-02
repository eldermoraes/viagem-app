package com.eldermoraes.cliente;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {
    
    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente finById(@QueryParam("id") long id){
        return clienteService.findById(id);
    }

    @GET
    @Path("newCliente")
    public String newCliente(){
        Cliente cliente = Cliente.of(99, "Remoto");
        return clienteService.newCliente(cliente);
    }
}
