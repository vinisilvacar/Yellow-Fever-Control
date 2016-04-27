package interfaces;

import java.util.ArrayList;

import dados.Pessoa;

public interface ValorUnico {
	
	public Boolean cpfUnico(ArrayList<Pessoa> pessoas, String cpf);
	
}
