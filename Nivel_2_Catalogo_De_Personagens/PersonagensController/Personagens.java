package com.example.Nivel_2_Catalogo_De_Personagens.PersonagensController;

import com.example.Nivel_2_Catalogo_De_Personagens.entities.Atirador;
import com.example.Nivel_2_Catalogo_De_Personagens.entities.LutadorCorpoACorpo;
import com.example.Nivel_2_Catalogo_De_Personagens.entities.Personagem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personagens")
public class Personagens {
    private final String caminhoPersonagens = "arquivos/personagens_db.csv.txt";

    @GetMapping("/todos")

    public List<Personagem> listar() {
        List<Personagem> personagens = new ArrayList<>();
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(caminhoPersonagens));

                String linha;

                while ((linha = br.readLine()) != null) {

                    String[] dados = linha.split(";");

                    String tipo = dados[0];
                    String nome = dados[1];
                    int forcaBase = Integer.parseInt(dados[2]);
                    String atributo = dados[3];

                    if (tipo.equals("L")) {

                        LutadorCorpoACorpo lutador =
                                new LutadorCorpoACorpo(nome, forcaBase, atributo);

                        personagens.add(lutador);

                    } else if (tipo.equals("A")) {

                        Atirador atirador =
                                new Atirador(nome, forcaBase, atributo);

                        personagens.add(atirador);
                    }
                }

                br.close();

                System.out.println(" ELENCO DO JOGO DE LUTA ");

                for (Personagem personagem : personagens) {
                    System.out.println(personagem);
                }

            } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
            return personagens;
        }
    }
    /*@PathVariable captura o valor informado na URL no lugar de {tipo}
    * (ex:/categoria/atirador) e coloca automaticamente na variável "tipo",
    * permitindo filtrar os personagens sem precisar de query params.*/
    @GetMapping("/categoria/{tipo}")
    public List<Personagem> listarPorCategoria(@PathVariable String tipo) {
        List<Personagem> personagensFiltrados = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoPersonagens));

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                String tipoArquivo = dados[0];
                String nome = dados[1];
                int forcaBase = Integer.parseInt(dados[2]);
                String atributo = dados[3];

                Personagem personagem = null;

                if (tipoArquivo.equals("L")) {
                    personagem = new LutadorCorpoACorpo(nome, forcaBase, atributo);
                } else if (tipoArquivo.equals("A")) {
                    personagem = new Atirador(nome, forcaBase, atributo);
                }

                // Só adiciona na lista se o personagem for da categoria pedida na URL
                if (personagem instanceof Atirador && tipo.equalsIgnoreCase("atirador")) {
                    personagensFiltrados.add(personagem);
                } else if (personagem instanceof LutadorCorpoACorpo && tipo.equalsIgnoreCase("lutador")) {
                    personagensFiltrados.add(personagem);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return new ArrayList<>(); // retorna lista vazia em caso de erro
        }
        return personagensFiltrados;
    }
}
/*Obs: para testar este endpoint no Postman, foi necessário configurar
 * manualmente o metodo HTTP como POST e inserir o corpo (body) da
 *requisição no formato JSON (raw/JSON), já que o Postman cria as
 * requisições como GET por padrão e sem body.*/