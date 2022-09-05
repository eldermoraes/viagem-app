package com.eldermoraes.cliente;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/cliente")
public class ClienteResource {
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> get(){
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@QueryParam("id") long id) throws InterruptedException{
        return Cliente.findById(id);
    }

    @Transactional
    @DELETE
    @Path("deleteById")
    public void deleteById(long id){
        Cliente.deleteById(id);
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(Cliente cliente){
        cliente.id = null;
        cliente.persist();

        return Response.status(Status.CREATED).entity(cliente).build();
    }
}
