package Chapéu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Aluno alunos[] = new Aluno[10];
        int total = 0;
        int opcao = 0;

        System.out.println("=== Sistema de Cadastro de Bruxos de Hogwarts ===");

        while(opcao != 8){
            exibirMenu();
            opcao = lerInteiro(input);

            if(opcao == 1){
                if(total == alunos.length){
                    System.out.println("Limite de " + alunos.length + " alunos atingido.");
                } else {
                    alunos[total] = cadastrarAluno(input, total + 1);
                    total++;
                }
            } else if(opcao == 2){
                listarTodos(alunos, total);
            } else if(opcao == 3){
                exibirCasaEscolhida(alunos, total, input);
            } else if(opcao == 4){
                exibirPorCasa(alunos, total);
            } else if(opcao == 5){
                exibirPorIdade(alunos, total, true);
            } else if(opcao == 6){
                exibirPorIdade(alunos, total, false);
            } else if(opcao == 7){
                buscarPorSobrenome(alunos, total, input);
            } else if(opcao == 8){
                break;
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        System.out.println();
        System.out.println("=== Alunos cadastrados ===");
        listarTodos(alunos, total);
        System.out.println("O Chapeu Seletor encerrou a selecao.");
        input.close();
    }

    public static void exibirMenu(){
        System.out.println();
        System.out.println("--- MENU ---");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar todos os alunos");
        System.out.println("3 - Exibir alunos de uma casa escolhida");
        System.out.println("4 - Exibir alunos por casa");
        System.out.println("5 - Exibir alunos maiores de idade");
        System.out.println("6 - Exibir alunos menores de idade");
        System.out.println("7 - Buscar aluno por sobrenome");
        System.out.println("8 - Encerrar");
        System.out.println("Escolha uma opcao: ");
    }

    public static Aluno cadastrarAluno(Scanner input, int posicao){
        Aluno aluno = new Aluno();

        System.out.println("Digite o nome completo do aluno: ");
        aluno.setNome(input.nextLine());
        aluno.setDataNascimento(lerData(input));

        System.out.println("Digite a quantidade de coragem (valor inteiro): ");
        aluno.setCoragem(lerInteiro(input));
        System.out.println("Digite a quantidade de inteligencia (valor inteiro): ");
        aluno.setInteligencia(lerInteiro(input));
        System.out.println("Digite a quantidade de ambicao (valor inteiro): ");
        aluno.setAmbicao(lerInteiro(input));
        System.out.println("Digite a quantidade de lealdade (valor inteiro): ");
        aluno.setLealdade(lerInteiro(input));

        aluno.calcularCasa();
        aluno.gerarCodigoMatricula(posicao);

        System.out.println();
        System.out.println("Aluno cadastrado com sucesso!");
        aluno.exibirInformacoes();
        return aluno;
    }

    public static void listarTodos(Aluno alunos[], int total){
        if(total == 0){
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for(int i = 0; i < total; i++){
            System.out.println();
            alunos[i].exibirInformacoes();
        }
        System.out.println();
        System.out.println("Total de alunos: " + total);
    }

    public static void exibirCasaEscolhida(Aluno alunos[], int total, Scanner input){
        System.out.println("Digite o nome da casa: ");
        String casa = input.nextLine();
        int contador = 0;

        for(int i = 0; i < total; i++){
            if(alunos[i].verificarCasa(casa)){
                System.out.println();
                alunos[i].exibirInformacoes();
                contador++;
            }
        }

        System.out.println();
        if(contador == 0){
            System.out.println("Nenhum aluno encontrado nessa casa.");
        } else {
            System.out.println("Total de alunos na casa: " + contador);
        }
    }

    public static void exibirPorCasa(Aluno alunos[], int total){
        String casas[] = {"Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa"};

        for(int c = 0; c < casas.length; c++){
            System.out.println();
            System.out.println("--- " + casas[c].toUpperCase() + " ---");
            int contador = 0;

            for(int i = 0; i < total; i++){
                if(alunos[i].verificarCasa(casas[c])){
                    System.out.println(alunos[i].getCodigoMatricula() + " - " + alunos[i].getNome());
                    contador++;
                }
            }

            if(contador == 0){
                System.out.println("Nenhum aluno.");
            } else {
                System.out.println("Total: " + contador);
            }
        }
    }

    public static void exibirPorIdade(Aluno alunos[], int total, boolean maiores){
        int contador = 0;

        System.out.println();
        if(maiores){
            System.out.println("--- ALUNOS MAIORES DE IDADE (17 anos ou mais) ---");
        } else {
            System.out.println("--- ALUNOS MENORES DE IDADE ---");
        }

        for(int i = 0; i < total; i++){
            if(alunos[i].verificarMaioridadeMagica() == maiores){
                System.out.println(alunos[i].getNome() + " - " + alunos[i].calcularIdade() + " anos");
                contador++;
            }
        }

        if(contador == 0){
            System.out.println("Nenhum aluno encontrado.");
        } else {
            System.out.println("Total: " + contador);
        }
    }

    public static void buscarPorSobrenome(Aluno alunos[], int total, Scanner input){
        System.out.println("Digite o sobrenome a buscar: ");
        String sobrenome = input.nextLine();
        int contador = 0;

        for(int i = 0; i < total; i++){
            if(alunos[i].verificarPresencaPalavra(sobrenome)){
                System.out.println();
                alunos[i].exibirInformacoes();
                contador++;
            }
        }

        System.out.println();
        if(contador == 0){
            System.out.println("Nenhum aluno encontrado com esse sobrenome.");
        } else {
            System.out.println("Total encontrado: " + contador);
        }
    }

    public static LocalDate lerData(Scanner input){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate data = null;

        while(data == null){
            System.out.println("Digite a data de nascimento (dd/MM/aaaa): ");
            String texto = input.nextLine();
            try {
                data = LocalDate.parse(texto.trim(), formato);
                if(data.isAfter(LocalDate.now())){
                    System.out.println("A data nao pode estar no futuro.");
                    data = null;
                }
            } catch(DateTimeParseException e){
                System.out.println("Data invalida. Use o formato dd/MM/aaaa.");
            }
        }

        return data;
    }

    public static int lerInteiro(Scanner input){
        int valor = 0;
        boolean valido = false;

        while(!valido){
            try {
                valor = Integer.parseInt(input.nextLine().trim());
                valido = true;
            } catch(NumberFormatException e){
                System.out.println("Valor invalido. Digite um numero inteiro: ");
            }
        }

        return valor;
    }
}
