package br.com.teste.itau.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.itau.DAO.ProdutoDAO;
import br.com.teste.itau.types.ProdutoTipo;

public class CarrinhoComprasService {
	
	/**
	 * Método para calcular o valor sem a taxa de entrega
	 * 
	 * @author João Vitor
	 * 
	 * @serialData 28/01/2020
	 * 
	 * */
	public Double calculaValorProduto(String nomeProduto, String cupom) throws SQLException {
		
		Double valor = insencaoImposto(nomeProduto);
		
		Double valorTotal = descontoProduto(nomeProduto,cupom, valor);
		
		return valorTotal;
		
	}

	/**
	 * Método para verificar se o produto entra na regra de isencao de imposto
	 * 
	 * @author João Vitor
	 * @throws SQLException 
	 * 
	 * @serialData 28/01/2020
	 * 
	 * */
	private Double insencaoImposto(String nomeProduto) throws SQLException {
		
		ProdutoDAO produto = new ProdutoDAO();
		
		String tipoProduto = produto.buscaTipoProduto(nomeProduto);
		
		Double valor = Double.parseDouble(produto.buscaValor(nomeProduto));
		
		List<ProdutoTipo> produtoTipo = Arrays.asList(ProdutoTipo.values());
		
		List<ProdutoTipo> produtoIsento = produtoTipo.stream()
				  .filter(state -> state.getTipo().equals(tipoProduto.toUpperCase()))
				  .collect(Collectors.toList());
		
		if(produtoIsento.isEmpty()) 
			return valor += (valor * 0.07);
			
		
		return valor ;
	}

	/**
	 * Método para verificar se o produto existe cupom de desconto
	 * 
	 * @author João Vitor
	 * 
	 * @serialData 28/01/2020
	 * 
	 * */
	private Double descontoProduto(String nomeProduto, String cupom , Double valor) throws SQLException {
		
		ProdutoDAO produto = new ProdutoDAO();
		
		String cupomProduto = produto.buscaCupomDesconto(cupom, nomeProduto);
		
		if(cupomProduto.isEmpty()) 
					return valor;
		
			
		return valor -= (valor * 0.05);
		
	}
}
