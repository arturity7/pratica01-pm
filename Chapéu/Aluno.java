package Chapéu;

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
    public Pessoa(String nome, int idade, int coragem, int inteligencia, int ambicao, int lealdade){
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        CalcularCasa();
    }
    public String exibirInformacoes(){
        return casa;
    }
    public int CalcularCasa(){
        int grifinoria, sonserina, corvinal, lufa-lufa;

        grifinoria = (2 * coragem) + lealdade;
        sonserina = (2*ambicao);
        corvinal = (2*inteligencia);
        lufa-lufa = ((2*lealdade) + coragem)/3;

        if(grifinoria > sonserina && grifinoria > corvinal && grifinoria > lufa-lufa){
            casa = grifinoria;
        } else if(sonserina > grifinoria && sonserina > corvinal && sonserina > lufa-lufa){
            casa = sonserina;
        } else if(corvinal > grifinoria && corvinal > sonserina && corvinal > lufa-lufa){
            casa = corvinal; 
        } else if(lufa-lufa > grifinoria && lufa-lufa > sonserina && lufa-lufa > corvinal){
            casa = lufa-lufa;
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
    public void setIdade(int iadde){
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
}
