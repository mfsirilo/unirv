package controledemilhagem;

public class Clientes {

    private int codCli;
    private String nome;
    private String sexo;
    private int cpf;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
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
    public Clientes(int codCli, String nome, String sexo, int cpf, int categoria, int codCon) {
	setCodCli(codCli);
	setNome(nome);
	setSexo(sexo);
	setCpf(cpf);
	setCategoria(categoria);
	setCodCon(codCon);
    }
    //Metodo para cadastrar clientes
    public Clientes cadastrarCliente(int codCli, String nome, String sexo, int cpf, int categoria, int codCon){
	Clientes cliente = new Clientes(codCli , nome, sexo, cpf, categoria, codCon);
	return cliente;
	}
	
    //Metodo que procurar o indide do cliente dentro do arraylist através do código
    public static int retornaIndiceCliente(int codigo, ArrayList<Clientes> clientes){
    	int index = 0;
        for (int i =0; i<clientes.size();i++){
            if(clientes.get(i).getCodCli()==codigo)
            index = i;
	}
	return index;
    }
}
