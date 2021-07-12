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

public class TelaAtualizarMaterial extends JFrame {

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
					TelaAtualizarMaterial frame = new TelaAtualizarMaterial();
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
	public TelaAtualizarMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escreva o ID do material e os novos dados dele:");
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
		
		JLabel lblIdade = new JLabel("Quantidade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(44, 148, 78, 14);
		contentPane.add(lblIdade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Didatico", "Escolar", "Limpeza"}));
		comboBox.setBounds(111, 83, 86, 20);
		contentPane.add(comboBox);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == "Didatico") {
					try {
						int qntd = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "didatico";
						atualizarMaterial(j, nome, tipo, qntd);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Quantidade ou ID invalido.");
					}
				}
				else if(comboBox.getSelectedItem() == "Escolar") {
					try {
						int qntd = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "escolar";
						atualizarMaterial(j, nome, tipo, qntd);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Quantidade ou ID invalido.");
					}
				}
				else if(comboBox.getSelectedItem() == "Limpeza") {
					try {
						int qntd = Integer.parseInt(TextIdade.getText());
						int j = Integer.parseInt(textField.getText());
						String nome = textNome.getText();
						String tipo = "limpeza";
						atualizarMaterial(j, nome, tipo, qntd);
						JOptionPane.showMessageDialog(rootPane, "Atualizado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "Quantidade ou ID invalido.");
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
		
		JButton btnNewButton = new JButton("Consultar Materiais");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaTableMaterial ini = new TelaConsultaTableMaterial();
				ini.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setBounds(207, 47, 160, 25);
		contentPane.add(btnNewButton);

	}
	public void atualizarMaterial(int Id, String nome, String tipo, int qntd) {
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("UPDATE materiais SET Nome = ?, Quantidade = ?, Tipo = ? WHERE (ID = ?)");
			st.setString(1, nome);
			st.setInt(2, qntd);
			st.setString(3, tipo);
			st.setInt(4, Id);
			
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		
	} 
}
