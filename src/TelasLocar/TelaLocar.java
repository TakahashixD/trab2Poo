package TelasLocar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TelaMenuPrincipal.TelaMenuP;
import TelasCadastro.TelaCadastroM;
import TelasConsultaAtualizarRemover.TelaConsultaTableMaterial;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaLocar extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTextField txtQntd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLocar frame = new TelaLocar();
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
	public TelaLocar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escreva o ID, quantidade e para quem o material a ser\u00E1 locado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 449, 25);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(111, 47, 86, 25);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(76, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtQntd = new JTextField();
		txtQntd.setBounds(111, 83, 86, 25);
		contentPane.add(txtQntd);
		txtQntd.setColumns(10);
		
		JLabel lblIdade = new JLabel("Quantidade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(45, 86, 152, 14);
		contentPane.add(lblIdade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "Cozinheiro", "Instrutor", "Monitor", "Professor", "Servente"}));
		comboBox.setBounds(111, 119, 86, 20);
		contentPane.add(comboBox);
		
		JLabel lblHumano = new JLabel("Humano:");
		lblHumano.setForeground(Color.WHITE);
		lblHumano.setBounds(45, 122, 56, 14);
		contentPane.add(lblHumano);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == "Aluno") {
					try {
						int qntd = Integer.parseInt(txtQntd.getText());
						int id = Integer.parseInt(txtID.getText());
						String y = "aluno";
						locarMaterial(id, qntd, y);
						JOptionPane.showMessageDialog(rootPane, "Locado com sucesso.");
						TelaMenuP ret = new TelaMenuP();
						ret.setVisible(true);
						dispose();
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(rootPane, "ID ou quantidade invalido.");
					}
				}
				else if(comboBox.getSelectedItem() == "Cozinheiro") {

				}
				else if(comboBox.getSelectedItem() == "Instrutor") {

				}
				else if(comboBox.getSelectedItem() == "Monitor") {

				}
				else if(comboBox.getSelectedItem() == "Professor") {

				}
				else if(comboBox.getSelectedItem() == "Servente") {

				}
			}
		});
		btnConfirmar.setBounds(143, 181, 104, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMenuP ini = new TelaMenuP();
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
	public void locarMaterial(int id, int qntd, String humano) {
		try {
			int aux;
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT Quantidade FROM materiais WHERE ID = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			aux = rs.getInt("Quantidade") - qntd;
			st = conn.prepareStatement("UPDATE materiais SET Quantidade = ? WHERE ID = ?");
			if(aux <= 0) {
				st.setInt(1, 0);
			}else {
				st.setInt(1, aux);
			}
			st.setInt(2, id);
			st.execute();
			st = conn.prepareStatement("INSERT INTO alocados (ID_Mat, Nome, Quantidade, tipo) "
					+ "SELECT ID, Nome, Quantidade, tipo FROM materiais where ID = ?");
			st.setInt(1, id);
			st.execute();
			st = conn.prepareStatement("UPDATE alocados SET Quantidade = ?, humano = ? WHERE (ID_Mat = ?)");
			st.setInt(1, qntd);
			st.setString(2, humano);
			st.setInt(3, id);
			st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DB.closeStatement(st);
		DB.closeResultSet(rs);
		DB.closeConnection();
		
	} 
}
