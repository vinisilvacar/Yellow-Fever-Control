package servicos;
  
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import comparadores.OrdenaDataVacina;
import comparadores.OrdenaNome;
import dados.*;
import executavel.Principal;

public class Pesquisa {
	public static void listarCadastrados(String tipo){
		int contMasculino=0, contFeminino=0;
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		listaPessoas.addAll(Principal.posto);
		
		if(Principal.posto.size() == 0){
			JOptionPane.showMessageDialog(null, "N�o h� cadastros!");
		}
		
		for(int aux=0; aux < Principal.posto.size(); aux++){
			if(Principal.posto.get(aux).toString().contains("Masculino")){
				contMasculino++;
			}else{
				contFeminino++;
			}
		}
		
		if(tipo.equals("Por Nome")){
			OrdenaNome ordemNome = new OrdenaNome();
	    	Collections.sort(listaPessoas, ordemNome);
		} else if(tipo.equals("Por Data Vacina")){
			OrdenaDataVacina ordemDataVacina = new OrdenaDataVacina();
		    Collections.sort(listaPessoas, ordemDataVacina);
		} else{
			//Nothing to do
		}
	    
		Servicos.pulaLinhas(20);
		System.out.println("\nQuantidade de Pessoas Cadastradas: " + Principal.posto.size());
		System.out.println("Quantidade de Homens Cadastrados: "+ contMasculino);
		System.out.println("Quantidade de Mulheres Cadastradas: " + contFeminino);
		System.out.println("\nNOME\t\t\tCPF\t\t\tSEXO\t\tDATA VACINA\t\tESTADO CIVIL\t\tQUANT GRAVIDEZ");
		for(Pessoa pes : listaPessoas) {
	        System.out.println(pes);
	    }
	}
	
	public static void consultaPorCpf(String numCpf){
		int cont=0;
		
			if (Principal.posto.size() == 0){
				JOptionPane.showMessageDialog(null, "N�o h� pessoas cadastradas");
			}else{			
				if(Servicos.isCpf(numCpf)){
					for (Pessoa pes : Principal.posto) {
				        if (pes.getCpf().equals(numCpf)) {
				        	if(pes.toString().contains("Masculino"))
				        		JOptionPane.showMessageDialog(null, "Nome: "+pes.getNome()+"\nCPF: "
							        + pes.getCpf() +"\nData Vacina:"+ pes.getDataVacina() + "\nSexo: Masculino" + "\nEstado Civil: " + pes.getDadoPessoa(), "Consulta Pessoa", JOptionPane.PLAIN_MESSAGE);
				        	else
				        		JOptionPane.showMessageDialog(null, "Nome: "+pes.getNome()+"\nCPF: "
								        + pes.getCpf() +"\nData Vacina:"+ pes.getDataVacina() + "\nSexo: Feminino" + "\nQuantidade Gravidez: " + pes.getDadoPessoa() , "Consulta Pessoa", JOptionPane.PLAIN_MESSAGE);
				        }else{
				        	cont++;
				        }
				    }
					if(cont >= Principal.posto.size())
						JOptionPane.showMessageDialog(null, "Registro n�o localizado!");
				}else
					JOptionPane.showOptionDialog(null, "CPF invalido", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			}
	} 
	
	public static List<Pessoa> pesquisaNome(ArrayList<Pessoa> pessoas, String parteNome){
		Integer qtdResultados = 0;
		List<Pessoa> pessoasPesquisadas = new ArrayList<Pessoa>();
		
	    for (int aux=0; aux< Principal.posto.size(); aux++) {
	      if (Principal.posto.get(aux).getNome().toString().contains(parteNome.toUpperCase())) {
	         qtdResultados++;
	    	 pessoasPesquisadas.add(Principal.posto.get(aux));
	      }else{
	    	  //Nothing to do
	      }
	    }
		return pessoasPesquisadas;
	}

}
