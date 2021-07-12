package TelaMenuPrincipal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TelasCadastro.TelaCadastroM;
import TelasConsultaAtualizarRemover.TelaAtualizarM;
import TelasConsultaAtualizarRemover.TelaConsultaM;
import TelasConsultaAtualizarRemover.TelaRemoverHumano;
import TelasConsultaAtualizarRemover.TelaRemoverM;
import TelasLocar.TelaLocar;
import db.DB;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaMenuP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuP frame = new TelaMenuP();
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
	public TelaMenuP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroM prox = new TelaCadastroM();
				prox.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(141, 85, 135, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLocarRecurso = new JButton("Locar Recursos");
		btnLocarRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLocar prox = new TelaLocar();
				prox.setVisible(true);
				dispose();
			}
		});
		btnLocarRecurso.setBounds(141, 221, 135, 23);
		contentPane.add(btnLocarRecurso);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.closeConnection();
				System.exit(0);
			}
		});
		btnSair.setBounds(164, 325, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblEscolhaAOpo = new JLabel("Escolha a op\u00E7\u00E3o:");
		lblEscolhaAOpo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEscolhaAOpo.setForeground(Color.WHITE);
		lblEscolhaAOpo.setBounds(140, 51, 149, 23);
		contentPane.add(lblEscolhaAOpo);
		
		JLabel lblSistemaDeGesto = new JLabel("Sistema de Gest\u00E3o de Recursos");
		lblSistemaDeGesto.setForeground(Color.WHITE);
		lblSistemaDeGesto.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSistemaDeGesto.setBounds(71, 12, 268, 28);
		contentPane.add(lblSistemaDeGesto);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverM prox = new TelaRemoverM();
				prox.setVisible(true);
				dispose();
			}
		});
		btnRemover.setBounds(141, 119, 135, 23);
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarM prox = new TelaAtualizarM();
				prox.setVisible(true);
				dispose();
			}
		});
		btnAtualizar.setBounds(141, 153, 135, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaM prox = new TelaConsultaM();
				prox.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(141, 187, 135, 23);
		contentPane.add(btnConsultar);
	}
}
