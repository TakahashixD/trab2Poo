package TelasConsultaAtualizarRemover;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TelaMenuPrincipal.TelaMenuP;
import db.DB;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaM frame = new TelaConsultaM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscolhaORecurso = new JLabel("Escolha qual recurso a ser consultado:");
		lblEscolhaORecurso.setForeground(Color.WHITE);
		lblEscolhaORecurso.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEscolhaORecurso.setBounds(39, 11, 335, 33);
		contentPane.add(lblEscolhaORecurso);
		
		JButton btnRecursoHumano = new JButton("Recurso Humano");
		btnRecursoHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaTableHumano prox = new TelaConsultaTableHumano();
				prox.setVisible(true);
				dispose();
			}
		});
		btnRecursoHumano.setBounds(122, 55, 174, 23);
		contentPane.add(btnRecursoHumano);
		
		JButton btnRecursoMaterial = new JButton("Recurso Material");
		btnRecursoMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaTableMaterial prox = new TelaConsultaTableMaterial();
				prox.setVisible(true);
				dispose();
			}
		});
		btnRecursoMaterial.setBounds(122, 89, 174, 23);
		contentPane.add(btnRecursoMaterial);
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao Menu Inicial");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuP ini = new TelaMenuP();
				ini.setVisible(true);
				dispose();
				
			}
			
		});
		btnVoltarAoMenu.setBounds(122, 175, 174, 23);
		contentPane.add(btnVoltarAoMenu);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.closeConnection();
				System.exit(0);
			}
		});
		btnSair.setBounds(164, 227, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnRecursosLocados = new JButton("Recursos Locados");
		btnRecursosLocados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaTableLocar prox = new TelaConsultaTableLocar();
				prox.setVisible(true);
				dispose();
			}
		});
		btnRecursosLocados.setBounds(122, 123, 174, 23);
		contentPane.add(btnRecursosLocados);
	}

}
