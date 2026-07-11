package com.example.Nivel_3_O_Portal_do_Hackathon.services;

import com.example.Nivel_3_O_Portal_do_Hackathon.models.Desenvolvedor;
import com.example.Nivel_3_O_Portal_do_Hackathon.models.Designer;
import com.example.Nivel_3_O_Portal_do_Hackathon.models.Participante;
import com.example.Nivel_3_O_Portal_do_Hackathon.models.RelatorioProcessamento;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HackathonService {

    private static final String ARQUIVO_INSCRICOES = "src/main/resources/inscricoes_brutas.txt";
    private static final String ARQUIVO_APROVADOS = "src/main/resources/aprovados_hackathon.txt";
    private static final String ARQUIVO_PENDENCIAS = "src/main/resources/pendencias_inscricao.txt";

    public RelatorioProcessamento processarInscricoes() {
        int aprovados = 0;
        int rejeitados = 0;

        File arquivoEntrada = new File(ARQUIVO_INSCRICOES);

        try (
                BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
                BufferedWriter escritorAprovados = new BufferedWriter(new FileWriter(ARQUIVO_APROVADOS, false));
                BufferedWriter escritorPendencias = new BufferedWriter(new FileWriter(ARQUIVO_PENDENCIAS, false))
        ) {
            String linha;
            while ((linha = leitor.readLine()) != null) {

                if (linha.isBlank()) {
                    continue;
                }

                try {
                    Participante participante = converterLinhaEmParticipante(linha);
                    escritorAprovados.write(participante.paraLinhaTexto());
                    escritorAprovados.newLine();
                    aprovados++;

                } catch (RuntimeException erroDeValidacao) {
                    escritorPendencias.write(linha + " -> MOTIVO: " + erroDeValidacao.getMessage());
                    escritorPendencias.newLine();
                    rejeitados++;
                }
            }

        } catch (IOException erroDeArquivo) {
            return new RelatorioProcessamento(0, 0, "Erro ao acessar arquivo: " + erroDeArquivo.getMessage());
        }

        return new RelatorioProcessamento(aprovados, rejeitados, "Processamento concluído com sucesso!");
    }

    private Participante converterLinhaEmParticipante(String linha) {
        String[] partes = linha.split(";");

        if (partes.length < 4) {
            throw new IllegalArgumentException("Linha com formato inválido (esperado 4 campos).");
        }

        String tipo = partes[0].trim().toUpperCase();
        String nome = partes[1].trim();
        String textoIdade = partes[2].trim();
        String detalhe = partes[3].trim();

        int idade;
        try {
            idade = Integer.parseInt(textoIdade);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Idade inválida (não é um número): '" + textoIdade + "'.");
        }

        return switch (tipo) {
            case "DESENVOLVEDOR" -> new Desenvolvedor(nome, idade, detalhe);
            case "DESIGNER" -> new Designer(nome, idade, detalhe);
            default -> throw new IllegalArgumentException("Tipo de participante desconhecido: '" + tipo + "'.");
        };
    }

    public List<String> listarAprovados() throws IOException {
        return lerArquivoComoLista(ARQUIVO_APROVADOS);
    }


    public List<String> listarPendencias() throws IOException {
        return lerArquivoComoLista(ARQUIVO_PENDENCIAS);
    }


    private List<String> lerArquivoComoLista(String caminhoArquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return linhas;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.isBlank()) {
                    linhas.add(linha);
                }
            }
        }

        return linhas;
    }
}