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
import TelasLocar.TelaLocar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
public class TelaConsultaTableMaterial extends JFrame {

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
					TelaConsultaTableMaterial frame = new TelaConsultaTableMaterial();
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
	public TelaConsultaTableMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 466);
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
		
		JLabel lblIdade = new JLabel("Quantidade");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(203, 62, 92, 14);
		contentPane.add(lblIdade);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(323, 62, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("Tabela de materiais:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(141, 11, 180, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Remover");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverMaterial ret = new TelaRemoverMaterial();
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
		btnSair.setBounds(165, 368, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnVoltarATela = new JButton("Atualizar");
		btnVoltarATela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarMaterial ret = new TelaAtualizarMaterial();
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
		btnNewButton.setBounds(109, 334, 199, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLocar = new JButton("Locar");
		btnLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLocar ret = new TelaLocar();
				ret.setVisible(true);
				dispose();
			}
		});
		btnLocar.setBounds(108, 300, 199, 23);
		contentPane.add(btnLocar);
		preencherTabela("select * from materiais order by ID");

	}
	public void preencherTabela(String Sql){
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"ID", "Nome", "Quantidade", "tipo"};
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(Sql);
			while(rs.next()) {
				dados.add(new Object[] {rs.getInt("ID"), rs.getString("Nome"), rs.getInt("Quantidade"), rs.getString("tipo")});
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
		tabelaConsult.getColumnModel().getColumn(2).setPreferredWidth(80);
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
