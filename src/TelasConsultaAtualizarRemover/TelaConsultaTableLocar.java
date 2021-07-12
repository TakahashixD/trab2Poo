package TelasConsultaAtualizarRemover;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import db.DB;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import TelaMenuPrincipal.TelaMenuP;
import TelasCadastro.TelaCadastroM;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
public class TelaConsultaTableLocar extends JFrame {

	private JPanel contentPane;
	private JTable tabelaConsult;
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaTableLocar frame = new TelaConsultaTableLocar();
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
	public TelaConsultaTableLocar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabelaConsult = new JTable();
		tabelaConsult.setBounds(23, 78, 375, 143);
		contentPane.add(tabelaConsult);
		tabelaConsult.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_loc", "Nome", "Quantidade", "tipo", "humano"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaConsult.setBackground(Color.LIGHT_GRAY);
		tabelaConsult.setForeground(Color.BLACK);
		
		JLabel lblId = new JLabel("ID_Loc");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(32, 62, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(113, 58, 46, 23);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Quatidade");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(179, 62, 74, 14);
		contentPane.add(lblIdade);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(263, 62, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("Tabela de materiais locados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(99, 11, 241, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.closeConnection();
				System.exit(0);
			}
		});
		btnSair.setBounds(165, 284, 89, 23);
		contentPane.add(btnSair);
		
		
		JButton btnNewButton = new JButton("Voltar ao Menu Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuP ret = new TelaMenuP();
				ret.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(113, 250, 199, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Humano");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(333, 62, 60, 14);
		contentPane.add(lblNewLabel_1);
		preencherTabela("select * from alocados order by ID_loc");

	}
	public void preencherTabela(String Sql){
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"ID_loc", "Nome", "Quantidade", "tipo", "humano"};
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(Sql);
			while(rs.next()) {
				dados.add(new Object[] {rs.getInt("ID_loc"), rs.getString("Nome"), rs.getInt("Quantidade"), rs.getString("tipo"), rs.getString("humano")});
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(rootPane, "Erro ao preencher ArrayList"+ex);
		}
		Table modelo = new Table(dados, colunas);
		
		tabelaConsult.setModel(modelo);
		tabelaConsult.getTableHeader().setReorderingAllowed(false);
		tabelaConsult.setAutoResizeMode(tabelaConsult.AUTO_RESIZE_OFF);
		tabelaConsult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	}
}
