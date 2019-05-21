package com.prjcadproduto.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.prjcadproduto.dominio.Produto;
import com.prjcadproduto.persistencia.CRUDProduto;

public class GerenciarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private Produto produto;
	private CRUDProduto crud;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarProduto frame = new GerenciarProduto();
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
	public GerenciarProduto() {
		
		produto = new Produto();
		crud = new CRUDProduto();
		
		
		setTitle("Gerenciar Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(10, 23, 212, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(139, 21, 253, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescricao.setBounds(10, 55, 212, 14);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 76, 382, 63);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFabricante.setBounds(10, 150, 93, 14);
		contentPane.add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(93, 148, 299, 20);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(10, 185, 93, 14);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(93, 183, 96, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreco.setBounds(24, 221, 59, 14);
		contentPane.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(93, 219, 96, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Passar os dados do formulário para o objeto cliente 
				produto.setNomeproduto(txtNome.getText());
				produto.setDescricaoproduto(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Integer.parseInt(txtPreco.getText()));
				String retorno = crud.cadastrar(produto);
				JOptionPane.showMessageDialog(null,retorno);
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				carregarDados();
			}
		});
	
		
		
		btnCadastrar.setBounds(14, 258, 95, 29);
		contentPane.add(btnCadastrar);
		
		
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnPesquisar.setBounds(119, 258, 89, 29);
		contentPane.add(btnPesquisar);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = JOptionPane.showInputDialog("Digite o Id do produto");
				
				//Passar os dados do formulário para o objeto cliente 
				produto.setNomeproduto(txtNome.getText());
				produto.setDescricaoproduto(txtDescricao.getText());
				produto.setFabricante(txtFabricante.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Integer.parseInt(txtPreco.getText()));
				
				String retorno = crud.atualizar(produto);
				
				JOptionPane.showMessageDialog(null,retorno);
				
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricante.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				id = "0";	
			}
		});
		
		btnAtualizar.setBounds(218, 258, 89, 29);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String id = JOptionPane.showInputDialog("Digite o Id do produto para apagar");
			
			produto.setId(Integer.parseInt(id));
			
			JOptionPane.showMessageDialog(null, crud.deletar(produto));
			}
		});	
		
		btnDeletar.setBounds(317, 258, 89, 29);
		contentPane.add(btnDeletar);
		
		
		
		carregarDados();
	}
	private void carregarDados() {
		
		
		
		String[] colunas = {"id","Nome","Descricao","Fabricante","Quantidade","Preco"};
		
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 298, 414, 115);
		contentPane.add(scrollPane);
		
		
		for(Produto p : crud.PesquisarTodos()) {
			modelo.addRow(new Object[] {
					p.getId(),
					p.getNomeproduto(),
					p.getDescricaoproduto(),
					p.getFabricante(),
					p.getQuantidade(),
					p.getPreco()
					
			});
		}
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
	}
	
}
