package validacaoTest;

import static org.junit.Assert.*; 

import org.junit.Test;

import validacao.Validacao;

public class TestValidation {

	@Test
	public void testVerificarRetornoString() {
		
		String testName = null;
		StringBuilder returnName = new StringBuilder();
		
		testName = "VINICIUS";
		returnName = Validacao.validaNome(testName);
		assertEquals("Teste de Nome valido!", testName, returnName.toString());
		
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
	
	public void testVerificarDataValida() {
		
		String testData = null;
		String returnData = null;
		
		testData = "01/01/2001";
		returnData = Validacao.validaData(testData);
		assertEquals("Teste de Data valido!", testData, returnData));
		
		testData = "30/01/2016";
		returnData = Validacao.validaData(testData);
		assertEquals("Teste de Data valido!", testData, returnData));
	}

}
