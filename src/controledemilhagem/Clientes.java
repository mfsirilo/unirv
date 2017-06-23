package controledemilhagem;

import java.util.ArrayList;

public class Clientes {

    private int codCli;
    private String nome;
    private String sexo;
    private String cpf;
    private int categoria;
    private int codConjuge;

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCodConjuge() {
        return codConjuge;
    }

    public void setCodConjuge(int codConjuge) {
        this.codConjuge = codConjuge;
    }
    
    //Construtor de clientes

    public Clientes(int codCli, String nome, String sexo, String cpf, int categoria, int codConjuge) {
        this.codCli = codCli;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.categoria = categoria;
        this.codConjuge = codConjuge;
    }

    
    
	
    
}
