package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import br.com.teste.itau.DAO.UsuarioDAO;
import br.com.teste.itau.entities.UsuarioEntity;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public void telaCadastroUsuario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario window = new CadastroUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(10, 11, 58, 20);
		frame.getContentPane().add(txtpnNome);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 159, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnCep = new JTextPane();
		txtpnCep.setText("Cep");
		txtpnCep.setBounds(10, 61, 58, 20);
		frame.getContentPane().add(txtpnCep);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 81, 159, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 112, 58, 20);
		frame.getContentPane().add(txtpnEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 133, 159, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		/**
		 * Metodo para adicionar um Usuario ao Banco de dados
		 * @author João Vitor
		 */
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nome = textField.getText();
				String email = textField_1.getText();
				String cep = textField_2.getText();

				UsuarioEntity usuario = new UsuarioEntity(nome, cep, email);
				
				try {
					UsuarioDAO usuarioDao = new UsuarioDAO();
					usuarioDao.insereUsuario(usuario);
					
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o usuario");
					
					e1.printStackTrace();
				}

			}
		});
		
		btnCadastrar.setBounds(256, 227, 168, 23);
		frame.getContentPane().add(btnCadastrar);
	}
}
