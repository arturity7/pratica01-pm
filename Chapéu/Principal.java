package Chapéu;

import java.util.Scanner; 

public class Principal {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String nome;

        while(nome != "sair"){
            Aluno aluno = new Aluno();
            System.out.println("Digite o nome do aluno: ");
            aluno.setNome(input.nextLine());
            System.out.println("Digite a idade: ");
            aluno.setIdade(input.nextInt());
            System.out.println("Digite a quantidade de coragem (valor inteiro): ");
            aluno.setCoragem(input.nextInt());
            System.out.println("Digite a quantidade de inteligencia (valor inteiro): ");
            aluno.setInteligencia(input.nextInt());
            System.out.println("Digite a quantidade de lealdade (valor inteiro)");
            aluno.setLealdade(input.nextInt());
            System.out.println("Digite a quantidade de ambicao (valor inteiro): ");
            aluno.setAmbicao(input.nextInt());
             

        }

        
    }
}
