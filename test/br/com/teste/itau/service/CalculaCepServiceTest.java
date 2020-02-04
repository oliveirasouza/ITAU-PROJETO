package br.com.teste.itau.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.xml.rpc.ServiceException;

import org.junit.Test;

public class CalculaCepServiceTest {

	/**
	 * Teste para Calcular o valor do frete
	 * 
	 * @author João Vitor
	 * 
	 * @throws SQLException
	 * @throws ServiceException 
	 * @throws RemoteException 
	 */
	
	@Test
	public void calculaValorFreteSucessTest() throws SQLException, RemoteException, ServiceException{
		//cenario
		CalculaCepService calculaCepService = new CalculaCepService();
		
		int formato = Integer.parseInt("1");
		BigDecimal comprimento = new BigDecimal("30");
		BigDecimal altura = new BigDecimal("2");
		BigDecimal largura= new BigDecimal("15");
		BigDecimal diametro = new BigDecimal("0.0");
		BigDecimal valorDeclarado = new BigDecimal( "0.00");
		
		//ação
		
		String valorFrete = calculaCepService.calculadorFrete("04510", "90619-900", "0.3", formato, comprimento, altura, largura, diametro, valorDeclarado);
		
		//assertivas
		assertNotNull(valorFrete);
		assertEquals("24,80", valorFrete);
		
	}
	
}
