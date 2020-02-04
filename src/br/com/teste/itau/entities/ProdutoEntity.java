package br.com.teste.itau.entities;

public class ProdutoEntity {
	
	private String peso;
	
	private String comprimento;
	
	private String altura;
	
	private String largura;
	
	private String diametro;
	
	private String formato;
	
	private Double valor;
	
	private String cupomDesconto;
	
	private String nome;
	
	private String tipo;
	
	private String tipoMidia;
	
	public ProdutoEntity() {
		
	}

	public ProdutoEntity(String peso, String comprimento, String altura, String largura, String diametro,
			String formato, Double valor, String cupomDesconto, String nome, String tipo, String tipoMidia) {

		this.peso = peso;
		this.comprimento = comprimento;
		this.altura = altura;
		this.largura = largura;
		this.diametro = diametro;
		this.formato = formato;
		this.valor = valor;
		this.cupomDesconto = cupomDesconto;
		this.nome = nome;
		this.tipo = tipo;
		this.tipoMidia = tipoMidia;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getComprimento() {
		return comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getDiametro() {
		return diametro;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(String cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
}
