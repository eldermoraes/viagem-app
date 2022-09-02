package com.eldermoraes.reserva;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.eldermoraes.cliente.Cliente;
import com.eldermoraes.cliente.ClienteService;

@Path("/reserva-cli")
public class ReservaResource {
    
    @Inject
    @RestClient
    ReservaService reservaService;

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public String newReserva(){
        Cliente cliente = clienteService.findById(2);
        Reserva reserva = Reserva.of(0, cliente);

        return reservaService.newReserva(reserva);
    }
}
