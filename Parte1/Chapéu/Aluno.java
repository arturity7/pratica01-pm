package Parte1.Chapéu;

public class Aluno {
    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private String casa; 

    public Aluno(){
        nome = "";
        idade = 0;
        coragem = 0;
        inteligencia = 0;
        ambicao = 0;
        lealdade = 0;
        casa = "";
    }
    public Aluno(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade){
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        calcularCasa();
    }
    public void exibirInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Ambicao: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Casa: " + casa);
    }
    public void calcularCasa(){
        double grifinoria, sonserina, corvinal, lufaLufa, maior;

        grifinoria = (2 * coragem) + lealdade;
        sonserina = (2 * ambicao);
        corvinal = (2 * inteligencia);
        lufaLufa = ((2 * lealdade) + coragem) / 3.0;

        maior = Math.max(Math.max(grifinoria, sonserina), Math.max(corvinal, lufaLufa));

        if(maior == grifinoria){
            casa = "Grifinória";
        } else if(maior == sonserina){
            casa = "Sonserina";
        } else if(maior == corvinal){
            casa = "Corvinal";
        } else {
            casa = "Lufa-Lufa";
        }
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getCoragem(){
        return coragem;
    }
    public void setCoragem(int coragem){
        this.coragem = coragem;
    }
    public int getInteligencia(){
        return inteligencia;
    }
    public void setInteligencia(int inteligencia){
        this.inteligencia = inteligencia;
    }
    public int getAmbicao(){
        return ambicao;
    }
    public void setAmbicao(int ambicao){
        this.ambicao = ambicao;
    }
    public int getLealdade(){
        return lealdade;
    }
    public void setLealdade(int lealdade){
        this.lealdade = lealdade;
    }
    public String getCasa(){
        return casa;
    }
    public void setCasa(String casa){
        this.casa = casa;
    }
}
