package com.eldermoraes.reserva;


public class Reserva {
    
    private long id;
    private long idCliente;

    public Reserva(){
        
    }

    private Reserva(long id, long idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    public static Reserva of(long id, long idCliente){
        return new Reserva(id, idCliente);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    
}
