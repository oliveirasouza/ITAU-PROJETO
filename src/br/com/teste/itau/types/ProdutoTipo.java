package br.com.teste.itau.types;

public enum ProdutoTipo {
	
	LIVRO("LIVRO"),
	JORNAL("JORNAL"),
	REVISTA("REVISTA"),
	EREADERS("EREADERS");
	
    private String tipo;

    private ProdutoTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
