package com.example.Nivel_1_API_Playlist.controllers;

import com.example.Nivel_1_API_Playlist.models.Musica;
import com.example.Nivel_1_API_Playlist.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Nivel_1_API_Playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/listar")
    public List<Musica> listar() throws IOException {
        return playlistService.listarMusicas();
    }

    @PostMapping("/adicionar")
    public String adicionar(@RequestBody Musica musica) throws IOException {
        playlistService.adicionarMusica(musica);
        return "Música salva com sucesso!";
    }
}