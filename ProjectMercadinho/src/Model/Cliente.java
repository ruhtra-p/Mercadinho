package Model;

public class Cliente {
	
	private String id;
	private String nome;
	private String cpf;
	private String emal;
	private String telefone;
	private String genero;
	private String endereco;
	private String dataNasc;
	
	public Cliente() {
		super();
	}
	public Cliente(String id, String nome, String cpf, String emal, String telefone, String genero, String endereco,
			String dataNasc) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.emal = emal;
		this.telefone = telefone;
		this.genero = genero;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmal() {
		return emal;
	}
	public void setEmal(String emal) {
		this.emal = emal;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
