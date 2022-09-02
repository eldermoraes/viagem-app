package com.eldermoraes.cliente;

public class Cliente {
    
    private long id;
    private String nome;

    public Cliente(){

    }

    private Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cliente of(long id, String nome){
        return new Cliente(id, nome);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
