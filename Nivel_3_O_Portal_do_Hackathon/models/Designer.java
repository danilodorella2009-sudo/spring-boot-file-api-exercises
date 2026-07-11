package com.example.Nivel_3_O_Portal_do_Hackathon.models;

import com.example.Nivel_3_O_Portal_do_Hackathon.enums.TipoParticipante;

public class Designer extends Participante {

    private String ferramentaPrincipal;

    public Designer(String nome, int idade, String ferramentaPrincipal) {
        super(nome, idade);
        this.ferramentaPrincipal = ferramentaPrincipal;
    }

    public String getFerramentaPrincipal() {
        return ferramentaPrincipal;
    }

    public void setFerramentaPrincipal(String ferramentaPrincipal) {
        this.ferramentaPrincipal = ferramentaPrincipal;
    }

    @Override
    public TipoParticipante getTipo() {
        return TipoParticipante.Designer;
    }

    @Override
    public String getDetalheEspecifico() {
        return ferramentaPrincipal;
    }
}