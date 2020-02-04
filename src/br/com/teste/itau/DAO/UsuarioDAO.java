package br.com.teste.itau.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.teste.itau.entities.UsuarioEntity;

public class UsuarioDAO {

	private Connection conect;

	/**
	 * ConnectionFactory serve para se comunicar com o banco de dados
	 * 
	 * @throws SQLException
	 */
	public UsuarioDAO() throws SQLException {
		
		new ConnectionFactory();
		
		this.conect = ConnectionFactory.getConnection();
		
	}

	/**
	 * Metodo para inserir usuarios na tabela
	 * @param user
	 */
	public void insereUsuario(UsuarioEntity user) {
		
		String insert = "INSERT INTO user (nome,email,cep) VALUES (?,?,?)";

		try (PreparedStatement s = conect.prepareStatement(insert);) {
			
			s.setString(1, user.getNome());
			s.setString(2, user.getEmail());
			s.setString(3, user.getCep());
			s.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			try {
				
				conect.rollback();
				
			} catch (SQLException ex) {
				
				ex.getStackTrace();
				
			}
		}
	}
}
