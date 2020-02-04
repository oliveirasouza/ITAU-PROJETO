package br.com.teste.itau.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/**
	 * Conexao com o banco de dados mysql
	 * 
	 * @author João Vitor
	 * @return
	 */
	public static Connection getConnection() {
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/itau?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&user=root&password=12345");
			return connect;
		} catch (SQLException e) {
			throw new RuntimeException("Banco de Dados Indisponivel, verifique a conexão");
		}
	}
}
