public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(){
        nome = "";
        sobrenome = "";
        idade = 0;
        altura = 0;
        peso = 0;
        imc = 0;
    }
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        CalculaIMC();
    }
    public double CalculaIMC(){
        double quadradoaltura;

        quadradoaltura = Math.pow (altura, 2);

        this.imc = this.peso / quadradoaltura;
        return imc;
    }
    public String InformaObesidade(){
        if(imc < 18.5){
            return "Abaixo do peso";
        } else if(imc < 25){
            return "Peso normal";
        } else if(imc < 30){
            return "Sobrepeso";
        } else if(imc < 35){
            return "Obesidade grau 1";
        } else if(imc < 40){
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getImc(){
        return imc;
    }
    public void setImc(double imc){
        this.imc = imc;
    }
}
