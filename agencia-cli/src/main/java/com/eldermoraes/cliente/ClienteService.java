package com.eldermoraes.cliente;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
        requestVolumeThreshold = 4,
        failureRatio = .5,
        delay = 6000,
        successThreshold = 1
    )
    public Cliente findById(@QueryParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);

    private Cliente fallback(long id){
        return Cliente.of(0, "");
    }
}
