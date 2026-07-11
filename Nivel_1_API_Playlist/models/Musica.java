package com.example.Nivel_1_API_Playlist.models;

public class Musica {

    private String titulo;
    private String artista;
    private String duracao;


    public Musica() {
    }


    public Musica(String titulo, String artista, String duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String paraLinhaTexto() {
        return titulo + ";" + artista + ";" + duracao;
    }

    public static Musica deLinhaTexto(String linha) {
        String[] partes = linha.split(";");
        String titulo = partes.length > 0 ? partes[0] : "";
        String artista = partes.length > 1 ? partes[1] : "";
        String duracao = partes.length > 2 ? partes[2] : "";
        return new Musica(titulo, artista, duracao);
    }
}