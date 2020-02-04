package br.com.teste.itau.service;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import br.com.teste.itau.entities.ProdutoEntity;

public class CarrinhoComprasServiceTest {
	
	
	/**
	 * Teste para Calcular o valor do produto sem cupomDeDesconto
	 * 
	 * @author João Vitor
	 * 
	 * @throws SQLException
	 */
	
	@Test
	public void calculaValorProdutoSucessTest() throws SQLException {
		//cenario
		CarrinhoComprasService  carrinho = new CarrinhoComprasService();
		ProdutoEntity produto = new ProdutoEntity();
		produto.setCupomDesconto("");
		produto.setNome("A culpa é das estrelas");
		
		//ação
		Double valorProduto = carrinho.calculaValorProduto(produto.getNome(), produto.getCupomDesconto());
		
		//assertivas
		assertNotNull(valorProduto);
		
	}
	
	/**
	 * Teste para Calcular o valor do produto com cupomDeDesconto
	 * 
	 * @author João Vitor
	 * 
	 * @throws SQLException
	 */
	@Test
	public void calculaValorProdutoComDescontoSucessTest() throws SQLException {
		//cenario
		CarrinhoComprasService  carrinho = new CarrinhoComprasService();
		
		//ação
		Double valorProduto = carrinho.calculaValorProduto("Estadao", "FEIRANATAL");
		
		//assertivas
		assertNotNull(valorProduto);
		
	}
}
