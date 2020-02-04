package br.com.teste.itau.service;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWSLocator;
import org.tempuri.CalcPrecoPrazoWSSoap;

public class CalculaCepService {
	
	/**
	 * Metodo para calcular o frete do Produto utilizando a WebService dos Correios
	 * 
	 * @author João Vitor
	 * 
	 * @serialData 29/01/2020
	 * 
	 * @param sevico
	 * @param cepOrigem
	 * @param peso
	 * @param formato
	 * @param comprimento
	 * @param altura
	 * @param largura
	 * @param diametro
	 * @param valorDeclarado
	 * @return
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	
	public String calculadorFrete(String sevico, String cepDestino, String peso, int formato, BigDecimal comprimento, BigDecimal altura, BigDecimal largura, BigDecimal diametro, BigDecimal valorDeclarado) 
			throws ServiceException, RemoteException {
		
		CalcPrecoPrazoWSSoap soap = new CalcPrecoPrazoWSLocator().getCalcPrecoPrazoWSSoap();
		
		CResultado resultado = soap.calcPreco("", "", sevico , cepDestino, "04094-050", peso, formato, comprimento, altura, largura, diametro, "N" , valorDeclarado, "N");

		org.tempuri.CServico[] service = resultado.getServicos();
		
		CServico servico = (CServico) service[0];	
		
		return servico.getValor();	
	}
}
