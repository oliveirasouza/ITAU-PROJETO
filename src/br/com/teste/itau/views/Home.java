package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import javax.swing.JButton;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnCadastrarUsuario = new JButton("Cadastrar Usuario");

		/**
		 * Entra na tela cadastra usuario
		 */
		btnCadastrarUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CadastroUsuario cadastraUsuario = new CadastroUsuario();
				cadastraUsuario.telaCadastroUsuario();

			}
		});

		btnCadastrarUsuario.setBounds(120, 45, 177, 23);
		frame.getContentPane().add(btnCadastrarUsuario);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");

		/**
		 * Entra na tela cadastra produto
		 */
		btnCadastrarProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CadastraProduto cadastraUsuario = new CadastraProduto();
				cadastraUsuario.telaCadastraProduto();

			}
		});

		btnCadastrarProduto.setBounds(120, 79, 177, 23);
		frame.getContentPane().add(btnCadastrarProduto);

		JButton btnCarrinhoDeCompras = new JButton("Carrinho de Compras");
		
		/**
		 * Entra na tela carrinho de compras
		 */
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Carrinho cadastraUsuario;
				try {
					cadastraUsuario = new Carrinho();
					cadastraUsuario.telaCarrinho();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnCarrinhoDeCompras.setBounds(120, 113, 177, 23);
		frame.getContentPane().add(btnCarrinhoDeCompras);
	}
}
