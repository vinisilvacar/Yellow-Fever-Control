package dados;

public class Homem extends Pessoa {
	private String estadoCivil;

	public Homem(StringBuilder nome, String dataVacina, String cpf, String estadoCivil) {
		super(nome, dataVacina, cpf);
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return getNome() + "\t\t\t" + getCpf() + "\t\t" + "Masculino" +"\t\t" + getDataVacina() + "\t\t"+ getEstadoCivil();
	}

	@Override
	public String getDadoPessoa() {
		return getEstadoCivil();
	}

}
