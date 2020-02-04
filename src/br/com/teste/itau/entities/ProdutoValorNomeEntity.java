package br.com.teste.itau.entities;

public class ProdutoValorNomeEntity {
	
	private String valor;
	
	private String nomeProduto;

	public ProdutoValorNomeEntity() {
		
	}
	
	public ProdutoValorNomeEntity(String valor, String nomeProduto) {

		this.valor = valor;
		this.nomeProduto = nomeProduto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
}
