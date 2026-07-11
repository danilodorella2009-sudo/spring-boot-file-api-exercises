package com.example.Nivel_3_O_Portal_do_Hackathon.models;

import com.example.Nivel_3_O_Portal_do_Hackathon.enums.TipoParticipante;

public class Desenvolvedor extends Participante {

    private String linguagemPrincipal;

    public Desenvolvedor(String nome, int idade, String linguagemPrincipal) {
        super(nome, idade);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

    @Override
    public TipoParticipante getTipo() {
        return TipoParticipante.Desenvolvedor;
    }

    @Override
    public String getDetalheEspecifico() {
        return linguagemPrincipal;
    }
}