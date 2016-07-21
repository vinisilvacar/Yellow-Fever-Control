package validacaoTest;

import static org.junit.Assert.*; 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import servicos.Servicos;
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
	
	@Test
	public void testVerificarDataValida() throws ParseException {
		
		String testData = null;
		String returnData = null;
		
		testData = "01/01/2001";
		returnData = Validacao.validaData(testData);
		assertEquals("Teste de Data valido!", testData, returnData);
		
		testData = "30/02/2016";
		returnData = Validacao.validaData(testData);
		assertNull(returnData);
		
		testData = "__/__/____";
		returnData = Validacao.validaData(testData);
		assertNull(returnData);
		
		testData = "";
		returnData = Validacao.validaData(testData);
		assertNull(returnData);
		
		testData = "20/07/2016";
		Date dataAtual = Servicos.getDateTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dtVacinacao = dateFormat.parse(testData);
		assertTrue(dataAtual.after(dtVacinacao));
	}
	
	@Test
	public void testVerificarQuantGravidez() {
		
		String testQuantGravidez = null;
		int returnQuantGravidez = 0;
		
		testQuantGravidez = "0";
		returnQuantGravidez = Validacao.validaQuantGravidez(testQuantGravidez);
		assertEquals("Teste de Quant Gravidez valido!", Integer.parseInt(testQuantGravidez), returnQuantGravidez);
		
		testQuantGravidez = "100";
		returnQuantGravidez = Validacao.validaQuantGravidez(testQuantGravidez);
		assertEquals("Teste de Quant Gravidez valido!", Integer.parseInt(testQuantGravidez), returnQuantGravidez);
		
		testQuantGravidez = "";
		returnQuantGravidez = Validacao.validaQuantGravidez(testQuantGravidez);
		assertEquals("Teste de Quant Gravidez valido!", Integer.parseInt(testQuantGravidez), returnQuantGravidez);
		
		testQuantGravidez = "-2";
		returnQuantGravidez = Validacao.validaQuantGravidez(testQuantGravidez);
		assertEquals("Teste de Quant Gravidez valido!", Integer.parseInt(testQuantGravidez), returnQuantGravidez);
	}

}
