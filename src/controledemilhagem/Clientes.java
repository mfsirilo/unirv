package controledemilhagem;

import java.util.ArrayList;

public class Clientes {

    private int codCli;
    private String nome;
    private String sexo;
    private String cpf;
    private int categoria;
    private int codCon;

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

    public int getCodCon() {
        return codCon;
    }

    public void setCodCon(int codCon) {
        this.codCon = codCon;
    }
    
    //Construtor de clientes
    public Clientes(int codCli, String nome, String sexo, String cpf, int categoria, int codCon) {
	setCodCli(codCli);
	setNome(nome);
	setSexo(sexo);
	setCpf(cpf);
	setCategoria(categoria);
	setCodCon(codCon);
    }
    
	
    
}
