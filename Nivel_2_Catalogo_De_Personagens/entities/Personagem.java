package com.example.Nivel_2_Catalogo_De_Personagens.entities;

public class Personagem {

    private String nome;
    private int forcaBase;

    public Personagem(String nome, int forcaBase) {
        this.nome = nome;
        this.forcaBase = forcaBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForcaBase() {
        return forcaBase;
    }

    public void setForcaBase(int forcaBase) {
        this.forcaBase = forcaBase;
    }

    @Override
    public String toString() {

        return "Personagem[nome: " + nome + " ,forcaBase: " + forcaBase + " ] ";
    }
}
