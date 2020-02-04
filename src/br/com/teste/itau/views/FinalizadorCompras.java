package br.com.teste.itau.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FinalizadorCompras {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void telaFinalizadorCompras() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizadorCompras window = new FinalizadorCompras();
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
	public FinalizadorCompras() {
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

		JButton btnConfirmarCompra = new JButton("Confirmar Compra");

		btnConfirmarCompra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//Aqui ocorreria o envio do email confirmando a compra
			}
		});

		btnConfirmarCompra.setBounds(129, 183, 187, 23);
		frame.getContentPane().add(btnConfirmarCompra);

		JLabel lblDesejaConfirmarA = new JLabel("DESEJA CONFIRMAR A COMPRA?!");
		lblDesejaConfirmarA.setBounds(142, 119, 237, 14);
		frame.getContentPane().add(lblDesejaConfirmarA);
	}
}
