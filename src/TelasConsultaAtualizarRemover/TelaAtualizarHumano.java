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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaAtualizarHumano extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection conn = null;
	PreparedStatement st = null;
	private JTextField textNome;
	private JTextField TextIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarHumano frame = new TelaAtualizarHumano();
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
	public TelaAtualizarHumano() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escreva o ID da pessoa e os novos dados dela:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(26, 11, 382, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(111, 47, 86, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(76, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(76, 86, 46, 14);
		contentPane.add(lblTipo);
		
		textNome = new JTextField();
		textNome.setBounds(111, 114, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		TextIdade = new JTextField();
		TextIdade.setBounds(111, 145, 86, 20);
		contentPane.add(TextIdade);
		TextIdade.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(76, 117, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(76, 145, 46, 14);
		contentPane.add(lblIdade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "Cozinheiro", "Instrutor", "Monitor", "Professor", "Servente"}));
		comboBox.setBounds(111, 83, 86, 20);
		contentPane.add(comboBox);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == "Aluno") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "aluno";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Cozinheiro") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "cozinheiro";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Instrutor") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "instrutor";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Monitor") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "monitor";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Professor") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "professor";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Servente") {
					try {
						int idade = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "servente";
						atualizarPessoa(j, nome, tipo, idade);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Idade ou ID invalida.");
					}
				}
			}
		});
		btnConfirmar.setBounds(143, 181, 104, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarM ini = new TelaAtualizarM();
				ini.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(143, 215, 104, 23);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Consultar Pessoas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaTableHumano ini = new TelaConsultaTableHumano();
				ini.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setBounds(207, 47, 160, 25);
		contentPane.add(btnNewButton);

	}
	public void atualizarPessoa(int Id, String nome, String tipo, int idade) {
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("UPDATE pessoas SET Nome = ?, Idade = ?, Tipo = ? WHERE (ID = ?)");
			st.setString(1, nome);
			st.setInt(2, idade);
			st.setString(3, tipo);
			st.setInt(4, Id);
			
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		
	} 
}
