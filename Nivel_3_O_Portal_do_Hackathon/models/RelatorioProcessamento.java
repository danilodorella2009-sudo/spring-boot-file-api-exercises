package com.example.Nivel_3_O_Portal_do_Hackathon.models;

public class RelatorioProcessamento {

    private int quantidadeAprovados;
    private int quantidadeRejeitados;
    private String status;

    public RelatorioProcessamento() {
    }

    public RelatorioProcessamento(int quantidadeAprovados, int quantidadeRejeitados, String status) {
        this.quantidadeAprovados = quantidadeAprovados;
        this.quantidadeRejeitados = quantidadeRejeitados;
        this.status = status;
    }

    public int getQuantidadeAprovados() {
        return quantidadeAprovados;
    }

    public void setQuantidadeAprovados(int quantidadeAprovados) {
        this.quantidadeAprovados = quantidadeAprovados;
    }

    public int getQuantidadeRejeitados() {
        return quantidadeRejeitados;
    }

    public void setQuantidadeRejeitados(int quantidadeRejeitados) {
        this.quantidadeRejeitados = quantidadeRejeitados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
