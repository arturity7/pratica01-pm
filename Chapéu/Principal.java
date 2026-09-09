package Chapéu;

import java.util.Scanner; 

public class Principal {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String nome = "";

        System.out.println("=== Chapéu Seletor de Hogwarts ===");

        while(!nome.equalsIgnoreCase("sair")){
            System.out.println();
            System.out.println("Digite o nome do aluno (ou \"sair\" para encerrar): ");
            nome = input.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                break;
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            System.out.println("Digite a idade: ");
            aluno.setIdade(input.nextInt());
            System.out.println("Digite a quantidade de coragem (valor inteiro): ");
            aluno.setCoragem(input.nextInt());
            System.out.println("Digite a quantidade de inteligencia (valor inteiro): ");
            aluno.setInteligencia(input.nextInt());
            System.out.println("Digite a quantidade de ambicao (valor inteiro): ");
            aluno.setAmbicao(input.nextInt());
            System.out.println("Digite a quantidade de lealdade (valor inteiro): ");
            aluno.setLealdade(input.nextInt());
            input.nextLine();

            aluno.calcularCasa();
            System.out.println();
            aluno.exibirInformacoes();
        }

        System.out.println("O Chapéu Seletor encerrou a seleção.");
        input.close();
    }
}
