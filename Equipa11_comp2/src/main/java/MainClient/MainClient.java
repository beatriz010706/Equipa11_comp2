package MainClient;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Scanner;

public class MainClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static final RestTemplate rest = new RestTemplate();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Menu Estudante");
            System.out.println("2. Menu Parceiro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> menuEstudante();
                case 2 -> menuParceiro();
                case 0 -> {
                    System.out.println("a sair...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuEstudante() {
        while (true) {
            System.out.println("\n=== MENU ESTUDANTE ===");
            System.out.println("1. Registar");
            System.out.println("2. Login");
            System.out.println("3. Consultar Histórico");
            System.out.println("4. Adicionar Horas Programa");
            System.out.println("5. Emitir Diploma");
            System.out.println("6. Consultar Progresso");
            System.out.println("7. Cancelar Participação");
            System.out.println("8. Candidatar-se a um Programa"); 
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> registarEstudante();
                case 2 -> loginEstudante();
                case 3 -> consultarHistorico();
                case 4 -> adicionarHoras();
                case 5 -> emitirDiploma();
                case 6 -> consultarProgresso();
                case 7 -> cancelarParticipacao();
                case 8 -> candidatarPrograma();
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuParceiro() {
        while (true) {
            System.out.println("\n=== MENU PARCEIRO ===");
            System.out.println("1. Registar");
            System.out.println("2. Login");
            System.out.println("3. Registar Programa");
            System.out.println("4. Editar Programa");
            System.out.println("5. Eliminar Programa");
            System.out.println("6. Listar todas candidaturas");
            System.out.println("7. Listar candidaturas de um programa");
            System.out.println("8. Aprovar candidatura");
            System.out.println("9. Rejeitar candidatura");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> registarParceiro();
                case 2 -> loginParceiro();
                case 3 -> registarPrograma();
                case 4 -> editarPrograma();
                case 5 -> eliminarPrograma();
                case 6 -> listarTodasCandidaturas();
                case 7 -> listarCandidaturasPrograma();
                case 8 -> aprovarCandidatura();
                case 9 -> rejeitarCandidatura();
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

// ------------------- MÉTODOS ESTUDANTE -------------------
    private static void registarEstudante() {
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Password: "); String password = sc.nextLine();
        System.out.print("Curso: "); String curso = sc.nextLine();
        System.out.print("Número de aluno: "); int numeroAluno = Integer.parseInt(sc.nextLine());

        String json = """
        {
          "nome": "%s",
          "email": "%s",
          "password": "%s",
          "curso": "%s",
          "numeroAluno": %d
        }
        """.formatted(nome, email, password, curso, numeroAluno);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        String response = rest.postForObject(BASE_URL + "/estudantes/registar", request, String.class);
        System.out.println("\nEstudante registado: " + response);
    }

    private static void loginEstudante() {
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Criar JSON com dados do login
        String json = """
                {
                  "email": "%s",
                  "senha": "%s"
                }
                """.formatted(email, senha);

        // Criar headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Criar HttpEntity com JSON e headers
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        // Enviar POST
        String url = BASE_URL + "/estudantes/login";
        try {
            ResponseEntity<String> resposta = rest.postForEntity(url, request, String.class);
            System.out.println("Login realizado." );
        } catch (HttpClientErrorException e) {
            System.out.println("Erro ao fazer login: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        }
    }


    private static void consultarHistorico() {
        System.out.print("ID do estudante: "); long id =Long.parseLong(sc.nextLine());
        String url = BASE_URL + "/estudantes/" + id + "/historico";
        String response = rest.getForObject(url, String.class);
        System.out.println("\nHistórico: " + response);
    }

    private static void adicionarHoras() {
        try {
            System.out.print("ID do programa: "); 
            long id = Long.parseLong(sc.nextLine());
            System.out.print("Horas a adicionar: "); 
            int horas = Integer.parseInt(sc.nextLine());

            String url = BASE_URL + "/programasEstudante/" + id + "/adicionarHoras?horas=" + horas;
            String response = rest.postForObject(url, null, String.class);

            System.out.println("\n" + response);

        } catch (NumberFormatException e) {
            System.out.println("IDs e horas devem ser números válidos.");
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void emitirDiploma() {
        try {
            System.out.print("ID do programa: "); 
            long id = Long.parseLong(sc.nextLine());

            String url = BASE_URL + "/programasEstudante/" + id + "/emitirDiploma";
            String response = rest.getForObject(url, String.class);

            System.out.println("\n" + response);

        } catch (NumberFormatException e) {
            System.out.println("IDs devem ser números válidos.");
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void consultarProgresso() {
        try {
            System.out.print("ID do programa: "); 
            long id = Long.parseLong(sc.nextLine());

            String url = BASE_URL + "/programasEstudante/" + id + "/progresso";
            String response = rest.getForObject(url, String.class);

            System.out.println("\n" + response);

        } catch (NumberFormatException e) {
            System.out.println("IDs devem ser números válidos.");
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void cancelarParticipacao() {
        try {
            System.out.print("ID do programa: "); 
            long id = Long.parseLong(sc.nextLine());

            String url = BASE_URL + "/programasEstudante/" + id + "/cancelar";
            String response = rest.postForObject(url, null, String.class);

            System.out.println("\n" + response);

        } catch (NumberFormatException e) {
            System.out.println("IDs devem ser números válidos.");
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    
    private static void candidatarPrograma() {
        try {
            System.out.print("ID do Estudante: ");
            long estudanteId = Long.parseLong(sc.nextLine());

            System.out.print("ID do Programa: ");
            long programaId = Long.parseLong(sc.nextLine());

            // Criar JSON com IDs
            String json = """
            {
              "estudanteId": %d,
              "programaId": %d
            }
            """.formatted(estudanteId, programaId);

            // Criar headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(json, headers);

            // URL do endpoint de candidatura
            String url = BASE_URL + "/candidaturas/criar";

            // Enviar POST
            String response = rest.postForObject(url, request, String.class);
            System.out.println("\nCandidatura realizada: " + response);

        } catch (NumberFormatException e) {
            System.out.println("Erro: IDs devem ser números válidos.");
        } catch (Exception e) {
            System.out.println("Erro ao realizar candidatura: " + e.getMessage());
        }
    }


    // ------------------- MÉTODOS PARCEIRO -------------------
    private static void registarParceiro() {
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Password: "); String password = sc.nextLine();
        System.out.print("Local: "); String local = sc.nextLine();

        String json = """
        {
          "nome": "%s",
          "email": "%s",
          "password": "%s",
          "local": "%s"
        }
        """.formatted(nome, email, password, local);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        String response = rest.postForObject(BASE_URL + "/parceiros/registar", request, String.class);
        System.out.println("\nParceiro registado: " + response);
    }

    private static void loginParceiro() {
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Password: "); String password = sc.nextLine();

        String url = BASE_URL + "/parceiros/login?email=" + email + "&password=" + password;
        String response = rest.postForObject(url, null, String.class);
        System.out.println("\nLogin: " + response);
    }

    private static void registarPrograma() {
        System.out.print("ID do Parceiro: "); long id = Long.parseLong(sc.nextLine());
        System.out.print("Título do programa: "); String titulo = sc.nextLine();
        System.out.print("Horas: "); int horas_servico = Integer.parseInt(sc.nextLine());
        System.out.print("Local:"); String local = sc.nextLine();
        System.out.print("Descrição:"); String descricao = sc.nextLine();
        System.out.print("Vagas: "); int vagas = Integer.parseInt(sc.nextLine());

        String json = """
        {
          "titulo": "%s",
          "horas_servico": %d,
          "local": "%s",
          "descricao": "%s",
          "vagas": %d
        }
        """.formatted(titulo, horas_servico, local, descricao, vagas);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        rest.postForObject(BASE_URL + "/parceiros/" + id + "/programa/registar", request, String.class);
        System.out.println("\nPrograma registado!");
    }

    private static void editarPrograma() {
        try {
            System.out.print("ID do Parceiro: ");
            long id = Long.parseLong(sc.nextLine());

            System.out.print("ID do Programa: ");
            long progId = Long.parseLong(sc.nextLine());

            System.out.print("Novo título: ");
            String titulo = sc.nextLine();

            System.out.print("Novas horas: ");
            int horas = Integer.parseInt(sc.nextLine());

            System.out.print("Novo local: ");
            String local = sc.nextLine();

            System.out.print("Nova descrição: ");
            String descricao = sc.nextLine();

            System.out.print("Novas vagas: ");
            int vagas = Integer.parseInt(sc.nextLine());

            // Criar JSON com todos os campos
            String json = """
                    {
                      "titulo": "%s",
                      "horas": %d,
                      "local": "%s",
                      "descricao": "%s",
                      "vagas": %d
                    }
                    """.formatted(titulo, horas, local, descricao, vagas);

            // Criar headers com Content-Type JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(json, headers);

            // URL do endpoint
            String url = BASE_URL + "/parceiros/" + id + "/programa/editar";

            // Enviar PUT
            rest.exchange(url, HttpMethod.PUT, request, String.class);

            System.out.println("\nPrograma editado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: IDs, horas e vagas devem ser números válidos.");
        } catch (Exception e) {
            System.out.println("Erro ao editar programa: " + e.getMessage());
        }
    }


    private static void eliminarPrograma() {
        try {
            System.out.print("ID do Parceiro: ");
            long id = Long.parseLong(sc.nextLine());

            System.out.print("ID do Programa: ");
            long progId = Long.parseLong(sc.nextLine());

            // Construir URL do DELETE
            String url = BASE_URL + "/parceiros/" + id + "/programa/" + progId;

            // Enviar DELETE
            rest.delete(url);

            System.out.println("\nPrograma eliminado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: IDs devem ser números válidos.");
        } catch (Exception e) {
            System.out.println("Erro ao eliminar programa: " + e.getMessage());
        }
    }

    private static void listarTodasCandidaturas() {
        String url = BASE_URL + "/candidaturas/todas";
        String response = rest.getForObject(url, String.class);
        System.out.println("\nTodas as candidaturas:");
        System.out.println(response);
    }

    private static void listarCandidaturasPrograma() {
        System.out.print("ID do programa: "); long id = Long.parseLong(sc.nextLine());
        String url = BASE_URL + "/candidaturas/programa/" + id;
        String response = rest.getForObject(url, String.class);
        System.out.println("\nCandidaturas do programa " + id + ":");
        System.out.println(response);
    }

    private static void aprovarCandidatura() {
        System.out.print("ID da candidatura: "); long id = Long.parseLong(sc.nextLine());
        String url = BASE_URL + "/candidaturas/" + id + "/aprovar";
        String response = rest.postForObject(url, null, String.class);
        System.out.println("\nResultado: " + response);
    }

    private static void rejeitarCandidatura() {
        System.out.print("ID da candidatura: "); long id = Long.parseLong(sc.nextLine());
        String url = BASE_URL + "/candidaturas/" + id + "/rejeitar";
        String response = rest.postForObject(url, null, String.class);
        System.out.println("\nResultado: " + response);
    }
}
