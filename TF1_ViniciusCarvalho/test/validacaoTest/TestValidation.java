package validacaoTest;

import static org.junit.Assert.*; 

import org.junit.Test;

import validacao.Validacao;

public class TestValidation {

	@Test
	public void testVerificarRetornoString(){
		
		String testName = null;
		StringBuilder returnName = new StringBuilder();
		
		testName = "VINICIUS";
		returnName = Validacao.validaNome(testName);
		assertEquals("Teste de Nome válido!", testName, returnName.toString());
		
		testName = "Vinicius";
		returnName = Validacao.validaNome(testName);
		assertNotSame(testName, returnName.toString());
		
		testName = "123deOliveira";
		returnName = Validacao.validaNome(testName);
		assertNull(returnName);
		
		testName = "";
		returnName = Validacao.validaNome(testName);
		assertNull(returnName);
	}

}
