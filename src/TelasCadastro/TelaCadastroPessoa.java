package TelasCadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	Connection conn = null;
	PreparedStatement st = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPessoa frame = new TelaCadastroPessoa();
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
	public TelaCadastroPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de pessoa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(125, 11, 178, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(125, 51, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(125, 82, 46, 14);
		contentPane.add(lblIdade);
		
		txtNome = new JTextField();
		txtNome.setBounds(181, 48, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(181, 79, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroM ini = new TelaCadastroM();
				ini.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(166, 203, 101, 23);
		contentPane.add(btnVoltar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "Cozinheiro", "Instrutor", "Monitor", "Professor", "Servente"}));
		comboBox.setBounds(181, 110, 86, 20);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(125, 113, 46, 14);
		contentPane.add(lblTipo);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() == "Aluno") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "aluno";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Cozinheiro") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "cozinheiro";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Instrutor") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "instrutor";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Monitor") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "monitor";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Professor") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "professor";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Servente") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "servente";
						cadastroPessoa(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaCadastroM ret = new TelaCadastroM();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
			}
		});
		btnConfirmar.setBounds(166, 169, 101, 23);
		contentPane.add(btnConfirmar);
	}
	public void cadastroPessoa(String nome, int idade, String tipo) {
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO pessoas (Nome, Idade, tipo) VALUES (?, ?, ?)");
			st.setString(1, nome);
			st.setInt(2, idade);
			st.setString(3, tipo);
			
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		DB.closeConnection();
		
	}
}
