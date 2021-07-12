package TelasCadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TelaMenuPrincipal.TelaMenuP;
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

public class TelaCadastroMaterial extends JFrame {

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
					TelaCadastroMaterial frame = new TelaCadastroMaterial();
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
	public TelaCadastroMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de material:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(113, 11, 205, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(125, 51, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Quantidade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(113, 82, 108, 14);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Didatico", "Escolar", "Limpeza"}));
		comboBox.setBounds(181, 110, 86, 20);
		contentPane.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(125, 113, 46, 14);
		contentPane.add(lblTipo);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() == "Didatico") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "didatico";
						cadastroMaterial(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Escolar") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "escolar";
						cadastroMaterial(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(rootPane, "Idade invalida.");
					}
				}
				else if(comboBox.getSelectedItem() == "Limpeza") {
					try {
						int i = Integer.parseInt(txtIdade.getText());
						String x = txtNome.getText();
						String y = "limpeza";
						cadastroMaterial(x, i, y);
						JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
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
	public void cadastroMaterial(String nome, int qntd, String tipo) {
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO materiais (Nome, Quantidade, tipo) VALUES (?, ?, ?)");
			st.setString(1, nome);
			st.setInt(2, qntd);
			st.setString(3, tipo);
			
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		DB.closeConnection();
		
	}
}
