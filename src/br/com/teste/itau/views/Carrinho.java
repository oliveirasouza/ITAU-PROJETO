package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import br.com.teste.itau.DAO.ProdutoDAO;
import br.com.teste.itau.entities.ProdutoEntity;
import br.com.teste.itau.entities.ProdutoValorNomeEntity;
import br.com.teste.itau.service.CarrinhoComprasService;

public class Carrinho {

	private static final String FISICO = "FISICO";
	private static final String DIGITAL = "DIGITAL";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private ProdutoValorNomeEntity produtoValorNomeEntity = new ProdutoValorNomeEntity();
	/**
	 * Launch the application.
	 */
	
	public void telaCarrinho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrinho window = new Carrinho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Carrinho() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnProduto = new JTextPane();
		txtpnProduto.setText("Produto");
		txtpnProduto.setBounds(10, 11, 59, 20);
		frame.getContentPane().add(txtpnProduto);
		
		JComboBox<String> comboBox = new JComboBox<>();
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		List<ProdutoEntity> produtos = produtoDao.buscaNomeProdutos();
		
		for(ProdutoEntity produto : produtos) {
			comboBox.addItem(produto.getNome());
		}
		
		comboBox.setBounds(10, 31, 132, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnTipoDeMidia = new JTextPane();
		txtpnTipoDeMidia.setText("Tipo de Midia");
		txtpnTipoDeMidia.setBounds(10, 64, 132, 20);
		frame.getContentPane().add(txtpnTipoDeMidia);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		
		String[] tipoMedia = {FISICO,DIGITAL};

		for(String tipo : tipoMedia) {
			comboBox_1.addItem(tipo);
		}
		
		comboBox_1.setBounds(10, 85, 132, 22);
		frame.getContentPane().add(comboBox_1);
		
		JTextPane txtpnCupomDeDesconto = new JTextPane();
		txtpnCupomDeDesconto.setText("Cupom de Desconto");
		txtpnCupomDeDesconto.setBounds(10, 128, 132, 20);
		frame.getContentPane().add(txtpnCupomDeDesconto);
		
		textField = new JTextField();
		textField.setBounds(10, 149, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.setBounds(272, 227, 152, 23);
		
		/**
		 * 
		 * Método verifica o tipo de midia e cria a ação do botão para próxima tela
		 * 
		 * @author João Vitor
		 */
		
		btnProsseguir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (comboBox_1.getSelectedItem().equals(DIGITAL)) {
					
					FinalizadorCompras finalizador;
					finalizador = new FinalizadorCompras();
					finalizador.telaFinalizadorCompras();
					
				} else {
					
					try {
						
						
						produtoValorNomeEntity.setNomeProduto(comboBox.getSelectedItem().toString());
						produtoValorNomeEntity.setValor(textField_1.getText());
						
						
						CalculaFrete cadastraUsuario;
						cadastraUsuario = new CalculaFrete(produtoValorNomeEntity);
						cadastraUsuario.telaCalculaFrete(produtoValorNomeEntity);
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}

			}
		});
		
		frame.getContentPane().add(btnProsseguir);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 86, 122, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnValorDoProduto = new JTextPane();
		txtpnValorDoProduto.setText("Valor do Produto");
		txtpnValorDoProduto.setBounds(276, 64, 123, 20);
		frame.getContentPane().add(txtpnValorDoProduto);
		
		JButton btnCalcularValorProduto = new JButton("Calcular Valor Produto");
		
		/**
		 * Método para jogar no TextField o valor do produto ao clicar no botao
		 * @author João Vitor
		 */
		btnCalcularValorProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				CarrinhoComprasService carrinhoService = new CarrinhoComprasService();
				
				String nomeProduto = (String) comboBox.getSelectedItem();
				
				String cupom = "";
				
				cupom = textField.getText();
				
				try {
					
					Double valor = carrinhoService.calculaValorProduto(nomeProduto, cupom);
					textField_1.setText(String.valueOf(valor));
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
			}
		});
		
		btnCalcularValorProduto.setBounds(10, 210, 165, 23);
		frame.getContentPane().add(btnCalcularValorProduto);
		
	}
}
