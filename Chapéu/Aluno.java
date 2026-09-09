package Chapéu;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private String casa;
    private LocalDate dataNascimento;
    private String codigoMatricula;

    public Aluno(){
        nome = "";
        idade = 0;
        coragem = 0;
        inteligencia = 0;
        ambicao = 0;
        lealdade = 0;
        casa = "";
        dataNascimento = null;
        codigoMatricula = "";
    }

    public Aluno(String nome, LocalDate dataNascimento, int coragem, int inteligencia, int ambicao, int lealdade){
        this.nome = padronizarNome(nome);
        this.dataNascimento = dataNascimento;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.idade = calcularIdade();
        this.codigoMatricula = "";
        calcularCasa();
    }

    public void exibirInformacoes(){
        String maioridade = "Nao";
        if(verificarMaioridadeMagica()){
            maioridade = "Sim";
        }
        System.out.println("Matricula: " + codigoMatricula);
        System.out.println("Nome: " + nome);
        System.out.println("Usuario: " + gerarNomeUsuario());
        System.out.println("Data de nascimento: " + formatarDataNascimento());
        System.out.println("Idade: " + calcularIdade());
        System.out.println("Maioridade magica: " + maioridade);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Ambicao: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Casa: " + formatarCasa());
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

    public int calcularIdade(){
        if(dataNascimento == null){
            return 0;
        }
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public boolean verificarMaioridadeMagica(){
        return calcularIdade() >= 17;
    }

    public String formatarCasa(){
        return casa.toUpperCase();
    }

    public String gerarNomeUsuario(){
        if(nome.isBlank()){
            return "";
        }
        String partes[] = nome.trim().split("\\s+");
        String usuario = "" + partes[0].charAt(0);
        for(int i = 1; i < partes.length; i++){
            usuario = usuario + partes[i];
        }
        return removerAcentos(usuario.toLowerCase());
    }

    public String gerarCodigoMatricula(int posicao){
        if(nome.isBlank()){
            return "";
        }
        String partes[] = nome.trim().split("\\s+");
        String iniciais = "";
        for(int i = 0; i < partes.length; i++){
            iniciais = iniciais + partes[i].charAt(0);
        }
        iniciais = removerAcentos(iniciais.toUpperCase());

        String numero = "" + posicao;
        if(posicao < 10){
            numero = "0" + posicao;
        }

        codigoMatricula = iniciais + "-" + LocalDate.now().getYear() + "-" + numero;
        return codigoMatricula;
    }

    public boolean verificarCasa(String casaInformada){
        if(casaInformada == null){
            return false;
        }
        return removerAcentos(casa.toLowerCase()).equals(removerAcentos(casaInformada.trim().toLowerCase()));
    }

    public boolean verificarPresencaPalavra(String palavra){
        if(palavra == null || palavra.isBlank()){
            return false;
        }
        String sobrenome = removerAcentos(getSobrenome().toLowerCase());
        return sobrenome.contains(removerAcentos(palavra.trim().toLowerCase()));
    }

    public String getSobrenome(){
        if(nome.isBlank()){
            return "";
        }
        String partes[] = nome.trim().split("\\s+");
        String sobrenome = "";
        for(int i = 1; i < partes.length; i++){
            if(i > 1){
                sobrenome = sobrenome + " ";
            }
            sobrenome = sobrenome + partes[i];
        }
        return sobrenome;
    }

    public String formatarDataNascimento(){
        if(dataNascimento == null){
            return "Nao informada";
        }
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private String padronizarNome(String texto){
        if(texto == null || texto.isBlank()){
            return "";
        }
        String partes[] = texto.trim().toLowerCase().split("\\s+");
        String padronizado = "";
        for(int i = 0; i < partes.length; i++){
            if(i > 0){
                padronizado = padronizado + " ";
            }
            padronizado = padronizado + partes[i].substring(0, 1).toUpperCase() + partes[i].substring(1);
        }
        return padronizado;
    }

    private String removerAcentos(String texto){
        String semAcento = texto;
        semAcento = semAcento.replace("á", "a").replace("à", "a").replace("ã", "a").replace("â", "a");
        semAcento = semAcento.replace("é", "e").replace("ê", "e");
        semAcento = semAcento.replace("í", "i");
        semAcento = semAcento.replace("ó", "o").replace("ô", "o").replace("õ", "o");
        semAcento = semAcento.replace("ú", "u");
        semAcento = semAcento.replace("ç", "c");
        semAcento = semAcento.replace("Á", "A").replace("À", "A").replace("Ã", "A").replace("Â", "A");
        semAcento = semAcento.replace("É", "E").replace("Ê", "E");
        semAcento = semAcento.replace("Í", "I");
        semAcento = semAcento.replace("Ó", "O").replace("Ô", "O").replace("Õ", "O");
        semAcento = semAcento.replace("Ú", "U");
        semAcento = semAcento.replace("Ç", "C");
        return semAcento;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = padronizarNome(nome);
    }
    public int getIdade(){
        return idade;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
        this.idade = calcularIdade();
    }
    public String getCodigoMatricula(){
        return codigoMatricula;
    }
    public void setCodigoMatricula(String codigoMatricula){
        this.codigoMatricula = codigoMatricula;
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
