package com.example.Nivel_3_O_Portal_do_Hackathon.controllers;

import com.example.Nivel_3_O_Portal_do_Hackathon.models.RelatorioProcessamento;
import com.example.Nivel_3_O_Portal_do_Hackathon.services.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hackathon")
public class HackathonController {

    @Autowired
    private HackathonService hackathonService;

    @PostMapping("/processar")
    public RelatorioProcessamento processar() {
        return hackathonService.processarInscricoes();
    }

    @GetMapping("/aprovados")
    public List<String> listarAprovados() throws IOException {
        return hackathonService.listarAprovados();
    }

    @GetMapping("/pendencias")
    public List<String> listarPendencias() throws IOException {
        return hackathonService.listarPendencias();
    }
}
/*depois disso, é só abrir esses dois links direto no navegador para conferir:
* http://localhost:8080/hackathon/aprovados
* http://localhost:8080/hackathon/pendencias
* Esses dois são GET, então funcionam normalmente digitando a URL na aba do Chrome.*/