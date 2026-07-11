package com.example.Nivel_1_API_Playlist.services;

import com.example.Nivel_1_API_Playlist.models.Musica;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private static final String CAMINHO_ARQUIVO = "src/main/resources/minha_playlist.txt";


    public List<Musica> listarMusicas() throws IOException {
        List<Musica> musicas = new ArrayList<>();

        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            return musicas;
        }

        try (FileReader fileReader = new FileReader(arquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                if (!linha.isBlank()) {
                    musicas.add(Musica.deLinhaTexto(linha));
                }
            }
        }

        return musicas;
    }

    public void adicionarMusica(Musica musica) throws IOException {
        try (FileWriter fileWriter = new FileWriter(CAMINHO_ARQUIVO, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(musica.paraLinhaTexto());
            bufferedWriter.newLine();
        }
    }
}