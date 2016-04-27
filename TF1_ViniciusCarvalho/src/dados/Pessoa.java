package dados;

public abstract class Pessoa {
	private StringBuilder nome;
	private String dataVacina;
	private String cpf;
	
	public Pessoa(StringBuilder nome, String dataVacina, String cpf) {
		this.nome = nome;
		this.dataVacina = dataVacina;
		this.cpf = cpf;
	}
	
	public StringBuilder getNome() {
		return nome;
	}
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
	public String getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(String dataVacina) {
		this.dataVacina = dataVacina;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public abstract String getDadoPessoa();
	
}
