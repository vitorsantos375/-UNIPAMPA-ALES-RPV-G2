package com.rpvg2.model;

/**
 *
 * @author Giliardi Schmidt
 */
public class Relator {

    private int id;
    private String nome;

    public Relator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome do relator não pode estar vazio");
        }
    }

}
