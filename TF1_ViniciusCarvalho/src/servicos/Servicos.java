package servicos;

import java.text.*; 
import java.util.Date;
import java.util.InputMismatchException;

import dados.*;

public class Servicos {
	public static Homem cadastraHomem(StringBuilder nome, String dataVacina, String cpf, String estadoCivil){
		return(new Homem(nome, dataVacina, cpf, estadoCivil));
	}

	public static Mulher cadastraMulher(StringBuilder nome, String dataVacina, String cpf, Integer quantGravidez){
		return(new Mulher(nome, dataVacina, cpf, quantGravidez));
	} 
	
	public static void fechaJanela() {
		System.exit(0); 
	}
	
	public static void pulaLinhas(int linhas){
		for(int aux=0; aux < linhas; aux++)
			System.out.println();
	}
	
	//Verifica se CPF e valido
	public static Boolean isCpf(String CPF){
		if (CPF.equals("000.000.000-00") || CPF.equals("111.111.111-11") ||CPF.equals("222.222.222-22") || CPF.equals("333.333.333-33") ||
				CPF.equals("444.444.444-44") || CPF.equals("555.555.555-55") || CPF.equals("666.666.666-66") || CPF.equals("777.777.777-77") ||
				CPF.equals("888.888.888-88") || CPF.equals("999.999.999-99") || (CPF.length() != 14)){
			return false;
		}
		
		char dig10, dig11;
	    int soma=0, resto, num, peso=10;

	    try {
	    	// Calculo do 1 Digito Verificador
	    	String CPFnum = CPF.replaceAll("[.-]", ""); //Retira caracteres da string
	    	for (int aux = 0; aux < 9; aux++) {              
	    		// converte o i-esimo caractere do CPF em um numero        
	    		num = (int)(CPFnum.charAt(aux) - 48); 
	    		soma += (num * peso);
	    		peso--;
	    	}

	    	resto = 11 - (soma % 11);
	    	//Se o resto da divisao for 10 ou 11, o dv é zero
		    if ((resto == 10) || (resto == 11))
		         dig10 = '0';
		    else //No outro caso, o dv e o resto
		    	dig10 = (char)(resto + 48); // converte no respectivo caractere numerico
		    
	      // Calculo do 2o. Digito Verificador
	      soma = 0;
	      peso = 11;
	      for(int aux=0; aux<10; aux++) {
	        num = (int)(CPFnum.charAt(aux) - 48);
	        soma += (num * peso);
	        peso--;
	      }

	      resto = 11 - (soma % 11);
	      if (resto == 10 || resto == 11)
	         dig11 = '0';
	      else 
	    	 dig11 = (char)(resto + 48);
	      
	      // Verifica se os digitos calculados conferem com os digitos informados.
	      if (dig10 == CPFnum.charAt(9) && dig11 == CPFnum.charAt(10))
	    	  return true;
	      else
	    	  return false;  
	    }catch(InputMismatchException erro) {
	        return false;
	    }catch(StringIndexOutOfBoundsException ex){
	    	return false;
	    }
	}
	
	//Verifica se data e valida
	public static Boolean isValidDate(String inDate) {
		if(inDate == null)
			return false;
			
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (inDate.trim().length() != dateFormat.toPattern().length())
			return false;
		dateFormat.setLenient(false);
		try{
			dateFormat.parse(inDate.trim());
		}catch(ParseException pe){
			return false;
		}
		return true;
		}
	
	//Pegar data do sistema
	public static Date getDateTime() {
		return new Date();
	}
	
}
