package Chapéu;

import java.time.LocalDate;

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
        double grifinoria, sonserina, corvinal, lufaLufa;

        grifinoria = (2 * coragem) + lealdade;
        sonserina = (2 * ambicao);
        corvinal = (2 * inteligencia);
        lufaLufa = ((2 * lealdade) + coragem) / 3.0;

        if(grifinoria >= sonserina && grifinoria >= corvinal && grifinoria >= lufaLufa){
            casa = "Grifinória";
        } else if(sonserina >= corvinal && sonserina >= lufaLufa){
            casa = "Sonserina";
        } else if(corvinal >= lufaLufa){
            casa = "Corvinal";
        } else {
            casa = "Lufa-Lufa";
        }
    }

    public int calcularIdade(){
        if(dataNascimento == null){
            return 0;
        }

        LocalDate hoje = LocalDate.now();
        int anos = hoje.getYear() - dataNascimento.getYear();

        if(hoje.getMonthValue() < dataNascimento.getMonthValue()){
            anos = anos - 1;
        } else if(hoje.getMonthValue() == dataNascimento.getMonthValue() && hoje.getDayOfMonth() < dataNascimento.getDayOfMonth()){
            anos = anos - 1;
        }

        return anos;
    }

    public boolean verificarMaioridadeMagica(){
        return calcularIdade() >= 17;
    }

    public String formatarCasa(){
        return casa.toUpperCase();
    }

    public String gerarNomeUsuario(){
        if(nome.equals("")){
            return "";
        }

        String partes[] = nome.split(" ");
        String usuario = "" + partes[0].charAt(0);

        for(int i = 1; i < partes.length; i++){
            usuario = usuario + partes[i];
        }

        return removerAcentos(usuario.toLowerCase());
    }

    public String gerarCodigoMatricula(int posicao){
        if(nome.equals("")){
            return "";
        }

        String partes[] = nome.split(" ");
        String iniciais = "";

        for(int i = 0; i < partes.length; i++){
            iniciais = iniciais + partes[i].charAt(0);
        }
        iniciais = removerAcentos(iniciais.toLowerCase()).toUpperCase();

        String numero = "" + posicao;
        if(posicao < 10){
            numero = "0" + posicao;
        }

        codigoMatricula = iniciais + "-" + LocalDate.now().getYear() + "-" + numero;
        return codigoMatricula;
    }

    public boolean verificarCasa(String casaInformada){
        String casaDoAluno = removerAcentos(casa.toLowerCase());
        String casaDigitada = removerAcentos(casaInformada.trim().toLowerCase());
        return casaDoAluno.equals(casaDigitada);
    }

    public boolean verificarPresencaPalavra(String palavra){
        if(palavra.trim().equals("")){
            return false;
        }

        String sobrenome = removerAcentos(getSobrenome().toLowerCase());
        String busca = removerAcentos(palavra.trim().toLowerCase());
        return sobrenome.contains(busca);
    }

    public String getSobrenome(){
        String partes[] = nome.split(" ");
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

        String dia = "" + dataNascimento.getDayOfMonth();
        String mes = "" + dataNascimento.getMonthValue();

        if(dataNascimento.getDayOfMonth() < 10){
            dia = "0" + dia;
        }
        if(dataNascimento.getMonthValue() < 10){
            mes = "0" + mes;
        }

        return dia + "/" + mes + "/" + dataNascimento.getYear();
    }

    private String padronizarNome(String texto){
        String partes[] = texto.trim().toLowerCase().split(" ");
        String padronizado = "";

        for(int i = 0; i < partes.length; i++){
            if(partes[i].length() > 0){
                if(padronizado.length() > 0){
                    padronizado = padronizado + " ";
                }
                padronizado = padronizado + partes[i].substring(0, 1).toUpperCase() + partes[i].substring(1);
            }
        }

        return padronizado;
    }

    private String removerAcentos(String texto){
        String limpo = texto;
        limpo = limpo.replace("á", "a").replace("ã", "a").replace("â", "a");
        limpo = limpo.replace("é", "e").replace("ê", "e");
        limpo = limpo.replace("í", "i");
        limpo = limpo.replace("ó", "o").replace("õ", "o");
        limpo = limpo.replace("ú", "u");
        limpo = limpo.replace("ç", "c");
        return limpo;
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
