package dados;

public class Mulher extends Pessoa {
	private Integer quantGravidez;

	public Mulher(StringBuilder nome, String dataVacina, String cpf,
			Integer quantGravidez) {
		super(nome, dataVacina, cpf);
		this.quantGravidez = quantGravidez;
	}

	public Integer getQuantGravidez() {
		return quantGravidez;
	}

	public void setQuantGravidez(Integer quantGravidez) {
		this.quantGravidez = quantGravidez;
	}

	@Override
	public String toString() {
		return getNome() + "\t\t\t" + getCpf() + "\t\t" + "\t\t" + "Feminino" + "\t\t"+ getDataVacina() + "\t\t" + "-" + "\t\t" + getQuantGravidez();
	}

	@Override
	public String getDadoPessoa() {
		return getQuantGravidez().toString();
	}

}
