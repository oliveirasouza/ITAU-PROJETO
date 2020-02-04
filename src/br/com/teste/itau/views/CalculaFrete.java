package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.rpc.ServiceException;

import br.com.teste.itau.DAO.ProdutoDAO;
import br.com.teste.itau.DAO.ServicoCorreiosDAO;
import br.com.teste.itau.entities.ProdutoEntity;
import br.com.teste.itau.entities.ProdutoValorNomeEntity;
import br.com.teste.itau.entities.ServicoCorreiosEntity;
import br.com.teste.itau.service.CalculaCepService;

public class CalculaFrete {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private ProdutoValorNomeEntity produtosProdutoValorNomeEntity;

	/**
	 * Launch the application.
	 */
	public void telaCalculaFrete(ProdutoValorNomeEntity produto) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					produtosProdutoValorNomeEntity = produto;
					CalculaFrete window = new CalculaFrete(produto);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public CalculaFrete(ProdutoValorNomeEntity produto) throws SQLException {
		initialize(produto);
		

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize(ProdutoValorNomeEntity produto) throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 50, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextPane txtpnCep = new JTextPane();
		txtpnCep.setText("CEP");
		txtpnCep.setBounds(10, 29, 44, 20);
		frame.getContentPane().add(txtpnCep);

		JComboBox<String> comboBox = new JComboBox<>();

		ServicoCorreiosDAO servicoCorreiosDAO = new ServicoCorreiosDAO();

		List<ServicoCorreiosEntity> servicos = servicoCorreiosDAO.buscaServicoECodigo();

		for (ServicoCorreiosEntity servico : servicos) {
			comboBox.addItem(servico.getServico());
		}

		comboBox.setBounds(10, 111, 346, 22);
		frame.getContentPane().add(comboBox);

		JTextPane txtpnServio = new JTextPane();
		txtpnServio.setText("Servi\u00E7o");
		txtpnServio.setBounds(10, 89, 59, 20);
		frame.getContentPane().add(txtpnServio);

		textField_1 = new JTextField();
		textField_1.setBounds(164, 223, 117, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JTextPane txtpnValorDoFrete = new JTextPane();
		txtpnValorDoFrete.setText("Valor do Frete");
		txtpnValorDoFrete.setBounds(164, 202, 106, 20);
		frame.getContentPane().add(txtpnValorDoFrete);

		JButton btnCalcularFrete = new JButton("Calcular Frete");

		this.produtosProdutoValorNomeEntity = produto;
		
		btnCalcularFrete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {

					// Instanciacoes necessarias

					ProdutoDAO produtoDAO = new ProdutoDAO();
					
					ServicoCorreiosDAO servicoCorreiosDAO2 = new ServicoCorreiosDAO();

					CalculaCepService calculaFrete = new CalculaCepService();
					

					// Valores

					String cepUsuario = textField.getText();

					String servico = (String) comboBox.getSelectedItem();
					
					String codigo = servicoCorreiosDAO2.buscaCodigo(servico);
					
					String nomeProduto = produtosProdutoValorNomeEntity.getNomeProduto();
					
					String valor = produtosProdutoValorNomeEntity.getValor();

					List<ProdutoEntity> produtos = produtoDAO.buscaProdutos(nomeProduto);
					
					int formato = Integer.parseInt(produtos.get(0).getFormato());
					BigDecimal comprimento = new BigDecimal(produtos.get(0).getComprimento());
					BigDecimal altura = new BigDecimal(produtos.get(0).getAltura());
					BigDecimal largura = new BigDecimal(produtos.get(0).getLargura());
					BigDecimal diametro = new BigDecimal(produtos.get(0).getDiametro());
					BigDecimal valorDeclarado = new BigDecimal(valor);

					// Calcula Frete

					String valorFrete = calculaFrete.calculadorFrete(codigo, cepUsuario, produtos.get(0).getPeso(),
							formato, comprimento, altura, largura, diametro, valorDeclarado);

					textField_1.setText(valorFrete);

				} catch (SQLException e1) {

					e1.printStackTrace();

				} catch (RemoteException e1) {

					e1.printStackTrace();
				} catch (ServiceException e1) {

					e1.printStackTrace();
				}

			}
		});

		btnCalcularFrete.setBounds(10, 222, 150, 23);
		frame.getContentPane().add(btnCalcularFrete);

		JButton btnProsseguir = new JButton("Prosseguir");

		btnProsseguir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FinalizadorCompras finalizador;
				finalizador = new FinalizadorCompras();
				finalizador.telaFinalizadorCompras();
			}
		});

		btnProsseguir.setBounds(307, 227, 117, 23);
		frame.getContentPane().add(btnProsseguir);
	}
}
