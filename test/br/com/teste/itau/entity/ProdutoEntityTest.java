package br.com.teste.itau.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.teste.itau.entities.ProdutoEntity;

public class ProdutoEntityTest {

	@Test
	public void instanciaProdutoSucessTest() {
		//cenario
		ProdutoEntity produtoEntity = new ProdutoEntity();
		produtoEntity.setAltura("1");
		produtoEntity.setComprimento("2");
		produtoEntity.setCupomDesconto("1");
		produtoEntity.setDiametro("2");
		produtoEntity.setFormato("1");
		produtoEntity.setLargura("2");
		produtoEntity.setNome("Mario Bross");
		produtoEntity.setPeso("2");
		produtoEntity.setTipo("LIVRO");
		produtoEntity.setTipoMidia("DIGITAL");
		produtoEntity.setValor(0.0);
		
		//ação
		
		//assertivas
		assertEquals("1", produtoEntity.getAltura());
		assertEquals("2", produtoEntity.getComprimento());
		assertEquals("1", produtoEntity.getCupomDesconto());
		assertEquals("2", produtoEntity.getDiametro());
		assertEquals("1", produtoEntity.getFormato());
		assertEquals("2", produtoEntity.getLargura());
		assertEquals("Mario Bross", produtoEntity.getNome());
		assertEquals("2", produtoEntity.getPeso());
		assertEquals("LIVRO", produtoEntity.getTipo());
		assertEquals("DIGITAL", produtoEntity.getTipoMidia());
		assertEquals(new Double(0.0), produtoEntity.getValor());
		
	}
}
