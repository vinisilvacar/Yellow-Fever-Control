package comparadores;

import java.util.Comparator; 

import dados.Pessoa;

public class PessoaComparator implements Comparator<Pessoa> {
	public int compare(Pessoa humano1, Pessoa humano2) {
		return humano1.getNome().toString().compareTo(humano2.getNome().toString());
	}
}
