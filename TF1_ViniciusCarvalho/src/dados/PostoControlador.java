package dados;

import interfaces.ValorUnico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PostoControlador implements ValorUnico{
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Boolean cpfUnico(ArrayList<Pessoa> pessoas, String numReg) {
		for(Pessoa pessoa : pessoas){
			if(pessoa.getCpf().equals(numReg)){
				JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
				return true;
			}
		}
		return false;
	}
	
}
