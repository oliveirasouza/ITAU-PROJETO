package br.com.teste.itau.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.itau.entities.ProdutoEntity;

public class ProdutoDAO {
	
private Connection conect;
	
	/**
	 * ConnectionFactory serve para se comunicar com o banco de dados 
	 * @throws SQLException
	 */
	public ProdutoDAO() throws SQLException{
		new ConnectionFactory();
		this.conect = ConnectionFactory.getConnection();
	}
	
	/**
	 * Metodo para inserir produtos na tabela
	 * @param produto
	 */
	public void insereProduto(ProdutoEntity produto) {
		
		String insert = "INSERT INTO produto (peso,comprimento,altura,largura,diametro,formato,valor,cupomDesconto,nome,tipo,tipoMidia) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement s = conect.prepareStatement(insert);){
			
			s.setString(1, produto.getPeso());
			s.setString(2, produto.getComprimento());
			s.setString(3, produto.getAltura());
			s.setString(4, produto.getLargura());
			s.setString(5, produto.getDiametro());
			s.setString(6, produto.getFormato());
			s.setDouble(7, produto.getValor());
			s.setString(8, produto.getCupomDesconto());
			s.setString(9, produto.getNome());
			s.setString(10, produto.getTipo());
			s.setString(11, produto.getTipoMidia());
			s.execute();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			try {
				
				conect.rollback();
				
			}catch(SQLException ex) {
				
				System.out.println(ex.getStackTrace());
				
			}
		}
	}		
	
	/**
	 * Método para verificar se existe algum cupom de desconto do produto
	 * @param cupomDesconto
	 * @return
	 */
	public String buscaCupomDesconto(String cupomDesconto,String nomeProduto)  {
		
	    String sqlSelect = "SELECT cupomDesconto FROM produto WHERE cupomDesconto = ? and nome = ?";
	    
	    	String cupom = "";
	    	
	    	    try (PreparedStatement s = conect.prepareStatement(sqlSelect);){
	    	    	
	    	    	s.setString(1, cupomDesconto);
	    	    	s.setString(2, nomeProduto);
	    	    	
	    	    	ResultSet rs = s.executeQuery();
	    	    	
	    	    	while (rs.next()) {
	    	    		
	    	    		cupom = rs.getString("cupomDesconto");  
	    	    	}
	    	       
	    	    } catch (SQLException e) {
	    	    	
	    	        e.printStackTrace(); 
	    	     } 
	    	    
	   return cupom;
	  }
	
	/**
	 * Método para buscar o valor do produto no banco de dados
	 * @param nomeProduto
	 * @return
	 */
	public String buscaValor(String nomeProduto)  {
		
	    String sqlSelect = "SELECT valor FROM produto WHERE nome = ?";
	    
	    	String valor = "";
	    	
	    	    try (PreparedStatement s = conect.prepareStatement(sqlSelect);){
	    	    	
	    	    	s.setString(1, nomeProduto);
	    	    	
	    	    	ResultSet rs = s.executeQuery();
	    	    	
	    	    	 while (rs.next()) {
	    	    		 
	    	    	valor = rs.getString("valor");
	    	    	
	    	    	 }
	     
	    	    } catch (SQLException e) {
	    	    	
	    	        e.printStackTrace();
	    	        
	    	     } 
	    	    
	   return valor;
	  }
	
	/**
	 * Método para buscar o tipo do produto de acordo com o nome dele
	 * @param nomeProduto
	 * @return
	 */
	public String buscaTipoProduto(String nomeProduto)  {
		
	    String sqlSelect = "SELECT tipo FROM produto WHERE nome = ?";
	    
	    	String tipoProduto = null;
	    	
	    	    try (PreparedStatement s = conect.prepareStatement(sqlSelect);){
	    	    	
	    	    	s.setString(1, nomeProduto);
	    	    	
	    	    	ResultSet rs = s.executeQuery();
	    	    	
	    	    	 while (rs.next()) {
	    	    		 
	    	    	tipoProduto = rs.getString("tipo");
	    	    	
	    	    	 }
	    	    } catch (SQLException e) {
	    	    	
	    	        e.printStackTrace();
	    	        
	    	     } 
	    	    
	   return tipoProduto;
	   
	  }
	
	/**
	 * Método para trazer todos os nomes existentes de produtos
	 * @return
	 */
	public ArrayList<ProdutoEntity> buscaNomeProdutos(){
		
	    String sqlSelect = "SELECT nome FROM produto";
	    
	    	    ArrayList<ProdutoEntity> lista = new ArrayList<>();
	    	    
	    	    try (PreparedStatement s = conect.prepareStatement(sqlSelect);){
	    	    	
	    	    	ResultSet rs = s.executeQuery();
	    	    	
	    	        while (rs.next()) {
	    	        	
	    	        	ProdutoEntity produto = new ProdutoEntity();
	    	        	
	    	        	produto.setNome(rs.getString("nome"));    
	    	        	
	    	             lista.add(produto);
	    	          }
	    	       
	    	    } catch (SQLException e) {
	    	    	
	    	        e.printStackTrace();
	    	      
	    	     } 
	    	    
	   return lista;
	}
	
	/**
	 * Método para verificar todos os produtos existente no banco e trazer suas especificacoes de acordo com o seu nome
	 * @param nomeProduto
	 * @return
	 */
	public ArrayList<ProdutoEntity> buscaProdutos(String nomeProduto){
		
	    String sqlSelect = "SELECT * FROM produto where nome = ?";
	    
	    	    ArrayList<ProdutoEntity> lista = new ArrayList<>();
	    	    
	    	    try (PreparedStatement s = conect.prepareStatement(sqlSelect);){
	    	    	
	    	    	s.setString(1, nomeProduto);
	    	    	
	    	    	ResultSet rs = s.executeQuery();
	    	    	
	    	        while (rs.next()) {
	    	        	
	    	        	ProdutoEntity produto = new ProdutoEntity();
	    	        	produto.setPeso(rs.getString("peso"));
	    	        	produto.setComprimento(rs.getString("comprimento"));
	    	        	produto.setAltura(rs.getString("altura"));
	    	        	produto.setDiametro(rs.getString("diametro"));
	    	        	produto.setFormato(rs.getString("formato"));
	    	        	produto.setLargura(rs.getString("largura"));
	    	            lista.add(produto);
	    	             
	    	          }
	    	       
	    	    } catch (SQLException e) {
	    	    	
	    	        e.printStackTrace();
	    	        
	    	     } 
	    	    
	   return lista;
	}
}
