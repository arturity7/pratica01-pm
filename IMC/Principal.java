import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.println("Informe o seu nome: ");
        pessoa.setNome(input.nextLine());
        System.out.println("Informe seu sobrenome: ");
        pessoa.setSobrenome(input.nextLine());
        System.out.println("Informe sua idade: ");
        pessoa.setIdade(input.nextInt());
        System.out.println("Digite sua altura: ");
        pessoa.setAltura(input.nextDouble());
        System.out.println("Digite o seu peso: ");
        pessoa.setPeso(input.nextDouble());

        pessoa.CalculaIMC();

        System.out.printf("O seu IMC é: %.2f%n", pessoa.getImc());
        System.out.println("A sua faixa de massa corporal é: " + pessoa.InformaObesidade());

        input.close();
    }

}
