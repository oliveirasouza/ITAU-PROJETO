package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import br.com.teste.itau.DAO.ProdutoDAO;
import br.com.teste.itau.entities.ProdutoEntity;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CadastraProduto {

	private static final String LIVRO = "LIVRO";
	private static final String JORNAL = "JORNAL";
	private static final String REVISTA = "REVISTA";
	private static final String EREADERS = "EREADERS";
	private static final String OUTROS = "OUTROS";
	private static final String FISICO = "FISICO";
	private static final String DIGITAL = "DIGITAL";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public void telaCadastraProduto() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraProduto window = new CadastraProduto();
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
	public CadastraProduto() {
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
		
		JTextPane txtpnPeso = new JTextPane();
		txtpnPeso.setText("Peso");
		txtpnPeso.setBounds(10, 11, 57, 20);
		frame.getContentPane().add(txtpnPeso);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 86, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnComprimento = new JTextPane();
		txtpnComprimento.setText("Comprimento");
		txtpnComprimento.setBounds(10, 65, 79, 20);
		frame.getContentPane().add(txtpnComprimento);
		
		JTextPane txtpnAltura = new JTextPane();
		txtpnAltura.setText("Altura");
		txtpnAltura.setBounds(10, 117, 57, 20);
		frame.getContentPane().add(txtpnAltura);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 138, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnLargura = new JTextPane();
		txtpnLargura.setText("Largura");
		txtpnLargura.setBounds(10, 168, 57, 20);
		frame.getContentPane().add(txtpnLargura);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 188, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextPane txtpnDiametro = new JTextPane();
		txtpnDiametro.setText("Diametro");
		txtpnDiametro.setBounds(143, 11, 57, 20);
		frame.getContentPane().add(txtpnDiametro);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 31, 96, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JTextPane txtpnFormato = new JTextPane();
		txtpnFormato.setText("Formato");
		txtpnFormato.setBounds(143, 65, 57, 20);
		frame.getContentPane().add(txtpnFormato);
		
		textField_5 = new JTextField();
		textField_5.setBounds(143, 86, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JTextPane txtpnValor = new JTextPane();
		txtpnValor.setText("Valor");
		txtpnValor.setBounds(143, 117, 57, 20);
		frame.getContentPane().add(txtpnValor);
		
		textField_6 = new JTextField();
		textField_6.setBounds(143, 138, 96, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JTextPane txtpnCupom = new JTextPane();
		txtpnCupom.setText("Cupom");
		txtpnCupom.setBounds(140, 168, 60, 20);
		frame.getContentPane().add(txtpnCupom);
		
		textField_7 = new JTextField();
		textField_7.setBounds(143, 188, 96, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(278, 11, 57, 20);
		frame.getContentPane().add(txtpnNome);
		
		textField_8 = new JTextField();
		textField_8.setBounds(278, 31, 134, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JTextPane txtpnTipo = new JTextPane();
		txtpnTipo.setText("Tipo");
		txtpnTipo.setBounds(278, 65, 57, 20);
		frame.getContentPane().add(txtpnTipo);
		
		JComboBox<String> comboBox = new JComboBox<>();
		
		String[] dados = {LIVRO,JORNAL,REVISTA,EREADERS,OUTROS};

		for(String dado : dados) {
			comboBox.addItem(dado);
		}
		comboBox.setBounds(278, 85, 117, 22);
		frame.getContentPane().add(comboBox);
		
		JTextPane txtpnTipoMidia = new JTextPane();
		txtpnTipoMidia.setText("Tipo Midia");
		txtpnTipoMidia.setBounds(278, 117, 96, 20);
		frame.getContentPane().add(txtpnTipoMidia);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		
		String[] tipoMedia = {FISICO,DIGITAL};

		for(String tipo : tipoMedia) {
			comboBox_1.addItem(tipo);
		}
		comboBox_1.setBounds(278, 137, 117, 22);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		/**
		 *Método de ação para gravar um Produto ao clicar no botão  
		 *
		 * @author João Vitor
		 *
		 */
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String peso = textField.getText();
				String comprimento = textField_1.getText();
				String altura = textField_2.getText();
				String largura = textField_3.getText();
				String diametro = textField_4.getText();
				String formato = textField_5.getText();
				Double valor = Double.parseDouble(textField_6.getText());
				String cupomDesconto = "";
				cupomDesconto = textField_7.getText();
				String nome = textField_8.getText();
				String tipo = (String) comboBox.getSelectedItem();
				String tipoMidia = (String) comboBox_1.getSelectedItem();

				ProdutoEntity produto = new ProdutoEntity(peso, comprimento, altura, largura, diametro, formato, valor, cupomDesconto, nome, tipo, tipoMidia);

				try {
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					produtoDao.insereProduto(produto);
					
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o produto");
					e1.printStackTrace();
					
				}
			}
		});
		
		btnCadastrar.setBounds(278, 227, 146, 23);
		frame.getContentPane().add(btnCadastrar);
	}
}
