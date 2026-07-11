package com.example.Nivel_3_O_Portal_do_Hackathon.models;

import com.example.Nivel_3_O_Portal_do_Hackathon.enums.TipoParticipante;
import com.example.Nivel_3_O_Portal_do_Hackathon.exceptions.IdadeInvalidaException;

public abstract class Participante {

    private String nome;
    private int idade;

    public Participante(String nome, int idade) {
        this.nome = nome;
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 14 || idade > 21) {
            throw new IdadeInvalidaException(
                    "Idade " + idade + " fora da faixa permitida (14 a 21 anos)");
        }
        this.idade = idade;
    }

    public abstract TipoParticipante getTipo();

    public abstract String getDetalheEspecifico();

    public String paraLinhaTexto() {
        return getTipo() + ";" + nome + ";" + idade + ";" + getDetalheEspecifico();
    }
}