package br.com.teste.itau.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.itau.entities.ServicoCorreiosEntity;

public class ServicoCorreiosDAO {

	private Connection conect;

	/**
	 * ConnectionFactory serve para se comunicar com o banco de dados
	 * 
	 * @throws SQLException
	 */
	public ServicoCorreiosDAO() throws SQLException {

		new ConnectionFactory();

		this.conect = ConnectionFactory.getConnection();

	}

	/**
	 * Esse Método serve para buscar no banco de dados o Servico e o Codigo dele
	 * 
	 * @author João Vitor
	 * 
	 * @return
	 */
	public ArrayList<ServicoCorreiosEntity> buscaServicoECodigo() {

		String sqlSelect = "SELECT codigoServico,servico FROM servico";

		ArrayList<ServicoCorreiosEntity> lista = new ArrayList<>();

		try (PreparedStatement s = conect.prepareStatement(sqlSelect);) {

			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				ServicoCorreiosEntity servico = new ServicoCorreiosEntity();
				servico.setCodigoServico(rs.getString("codigoServico"));
				servico.setServico(rs.getString("servico"));
				lista.add(servico);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;
	}

	/**
	 * Esse Método serve para buscar no banco de dados o Codigo do servico
	 * 
	 * @author João Vitor
	 * 
	 * @return
	 */
	public String buscaCodigo(String nomeServico) {

		String sqlSelect = "SELECT codigoServico FROM servico WHERE servico = ?";

		String codigo = "";

		try (PreparedStatement s = conect.prepareStatement(sqlSelect);) {

			s.setString(1, nomeServico);

			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				codigo = rs.getString("codigoServico");

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return codigo;
	}

}
