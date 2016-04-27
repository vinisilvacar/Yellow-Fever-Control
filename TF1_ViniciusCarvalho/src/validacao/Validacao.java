package validacao;

import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import servicos.Servicos;
import dados.*;

public class Validacao {
	public static StringBuilder validaNome(String nomePessoa) {
		String nomeAux = null;
		StringBuilder nomeMutavel = new StringBuilder();

		try {
			nomeAux = nomePessoa.trim().toUpperCase();
			if (nomeAux.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campo nome vazio!",
						"Invalido", JOptionPane.ERROR_MESSAGE);
				return null;
			} 
			
			//Verificar de ha numeros no nome
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(nomeAux);
			if(matcher.find()){
				JOptionPane.showMessageDialog(null, "Campo NOME nao pode conter numeros!",
						"Invalido", JOptionPane.ERROR_MESSAGE);
				return null;
			}else{
				//Nothing to do
			}
			
		} catch (NullPointerException excecao) {
			JOptionPane.showMessageDialog(null, "Nome inválido.");
			return null;
		}
		return nomeMutavel.append(nomeAux);
	}

	@SuppressWarnings("deprecation")
	public static String validaData(String dataVacinacao) {
		try {
			// Chamar metodo para verificar se data é menor que hoje.
			Date dataAtual = Servicos.getDateTime();

			if (dataVacinacao.equals("__/__/____")) {
				JOptionPane.showMessageDialog(null, "Data vazia!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dtVacinacao = dateFormat.parse(dataVacinacao);
			
			// Se data é valida
			if (Servicos.isValidDate(dataVacinacao) == false) {
				JOptionPane.showMessageDialog(null, "Data inválida!",
									"Invalido", JOptionPane.ERROR_MESSAGE);
				return null;
			}

			if (dtVacinacao.after(dataAtual)) {
				JOptionPane.showMessageDialog(null,
						"Data superior a atual\nDigite uma data até hoje.");
				return null;
			} else if (dtVacinacao.before(new Date("01/01/1900"))) {
				JOptionPane.showMessageDialog(null,
						"Data muito inferior a atual\nDigite uma data "
								+ "após 1900.");
				return null;
			}

		} catch (NullPointerException exNullPointer) {
			JOptionPane.showMessageDialog(null,
					"Data Inadequada! Digite uma data no formato", "Invalido",
					JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (NumberFormatException exNumber) {
			JOptionPane.showMessageDialog(null,
					"Data Inadequada! Digite apenas numeros no formato",
					"Invalido", JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (ParseException pe) {
			JOptionPane.showMessageDialog(null,
					"Data Inadequada! Erro na obtençao de data.", "Invalido",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return dataVacinacao;
	}

	public static String validaCpf(String numReg, ArrayList<Pessoa> pessoas) {

		try {
			// Chamada de método para verificar se Cpf e valido
			if (!Servicos.isCpf(numReg)) {
				JOptionPane.showMessageDialog(null,
						"CPF inválido\nInsira apenas números\n"
								+ "Digite 11 números");
				return null;
			}
			
			//Verificar se CPF e unico
			PostoControlador reg = new PostoControlador();
			if(reg.cpfUnico(pessoas, numReg)){
				return null;
			}

		} catch (NullPointerException excNullPointer) {
			JOptionPane.showMessageDialog(null,
					"Registro Inadequado!\nComplete todos os numeros",
					"Invalido", JOptionPane.ERROR_MESSAGE);
			return null;
		} catch (NumberFormatException exNumber) {
			JOptionPane.showMessageDialog(null,
					"Registro Inadequado!\nDigite numeros inteiros positivos",
					"Invalido", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return numReg;
	}

	public static Integer validaQuantGravidez(String quantGravidez) {
		Integer quantGravInt = 0;

		try {
			quantGravInt = Integer.parseInt(quantGravidez);
			if (quantGravInt < 0) {
				JOptionPane.showMessageDialog(null,
								"Quantidade de Gravidez Invalida! Selecione zero ou um valor positivo",
								"Invalido", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch (NumberFormatException exNumber) {
			JOptionPane.showMessageDialog(null,
							"Quantidade de Gravidez Inadequada!\nDigite numeros inteiros positivos",
							"Invalido", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return quantGravInt;
	}

}
