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
public class TelaConsultaTableHumano extends JFrame {

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
					TelaConsultaTableHumano frame = new TelaConsultaTableHumano();
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
	public TelaConsultaTableHumano() {
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
			}
		));
		tabelaConsult.setBackground(Color.LIGHT_GRAY);
		tabelaConsult.setForeground(Color.BLACK);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(32, 62, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(113, 58, 46, 23);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(221, 62, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(323, 62, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("Tabela de pessoas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(141, 11, 180, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Remover");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverHumano ret = new TelaRemoverHumano();
				ret.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(109, 232, 199, 23);
		contentPane.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.closeConnection();
				System.exit(0);
			}
		});
		btnSair.setBounds(164, 334, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnVoltarATela = new JButton("Atualizar");
		btnVoltarATela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarHumano ret = new TelaAtualizarHumano();
				ret.setVisible(true);
				dispose();
			}
			
		});
		btnVoltarATela.setBounds(109, 266, 199, 23);
		contentPane.add(btnVoltarATela);
		
		JButton btnNewButton = new JButton("Voltar ao Menu Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuP ret = new TelaMenuP();
				ret.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(109, 300, 199, 23);
		contentPane.add(btnNewButton);
		preencherTabela("select * from pessoas order by ID");

	}
	public void preencherTabela(String Sql){
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"ID", "Nome", "Idade", "tipo"};
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(Sql);
			while(rs.next()) {
				dados.add(new Object[] {rs.getInt("ID"), rs.getString("Nome"), rs.getInt("Idade"), rs.getString("tipo")});
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(rootPane, "Erro ao preencher ArrayList"+ex);
		}
		Table modelo = new Table(dados, colunas);
		
		tabelaConsult.setModel(modelo);
		tabelaConsult.getColumnModel().getColumn(0).setPreferredWidth(23);
		tabelaConsult.getColumnModel().getColumn(0).setResizable(false);
		tabelaConsult.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabelaConsult.getColumnModel().getColumn(1).setResizable(false);
		tabelaConsult.getColumnModel().getColumn(2).setPreferredWidth(23);
		tabelaConsult.getColumnModel().getColumn(2).setResizable(false);
		tabelaConsult.getColumnModel().getColumn(3).setPreferredWidth(80);
		tabelaConsult.getColumnModel().getColumn(3).setResizable(false);
		tabelaConsult.getTableHeader().setReorderingAllowed(false);
		tabelaConsult.setAutoResizeMode(tabelaConsult.AUTO_RESIZE_OFF);
		tabelaConsult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DB.closeStatement(st);
		DB.closeResultSet(rs);
	}
}
