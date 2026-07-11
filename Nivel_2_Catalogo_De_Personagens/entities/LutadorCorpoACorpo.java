package com.example.Nivel_2_Catalogo_De_Personagens.entities;

public class LutadorCorpoACorpo extends Personagem {

    private String arteMarcial;

    public LutadorCorpoACorpo(String nome, int forcaBase, String arteMarcial) {
        super(nome, forcaBase);
        this.arteMarcial = arteMarcial;
    }

    public String getArteMarcial() {
        return arteMarcial;
    }

    public void setArteMarcial(String arteMarcial) {
        this.arteMarcial = arteMarcial;
    }

    public String toString() {
        return "[Lutador] " + super.toString() + ",arteMarcial" + arteMarcial;
    }
}


