package TelasConsultaAtualizarRemover;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TelaMenuPrincipal.TelaMenuP;
import TelasCadastro.TelaCadastroM;
import db.DB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaRemoverHumano extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection conn = null;
	PreparedStatement st = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverHumano frame = new TelaRemoverHumano();
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
	public TelaRemoverHumano() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 203);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escreva o ID da pessoa que deseja remover:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 11, 318, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(60, 47, 86, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(39, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(textField.getText());
					removerPessoa(i);
					JOptionPane.showMessageDialog(rootPane, "Removido com sucesso.");
					TelaMenuP ret = new TelaMenuP();
					ret.setVisible(true);
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(rootPane, "ID invalido.");
				}
			}
		});
		btnConfirmar.setBounds(128, 83, 104, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverM ini = new TelaRemoverM();
				ini.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(128, 117, 104, 23);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Consultar Pessoas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaTableHumano ini = new TelaConsultaTableHumano();
				ini.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setBounds(173, 47, 160, 25);
		contentPane.add(btnNewButton);
	}
	public void removerPessoa(int Id) {
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM pessoas WHERE ID = ?");
			st.setInt(1, Id);
			
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		DB.closeConnection();
		
	} 
}
