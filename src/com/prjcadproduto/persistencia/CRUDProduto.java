package com.prjcadproduto.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;
import com.prjcadproduto.dominio.Produto;

/**
 * <b>CRUDProduto</b><br>
 * Essa classe permite manipular as informações do produto. Aqui você 
 * encontrará os seguintes comando:
 * <ul>
 * <li>Cadastro</li>
 * <li>Pesquisar por nome e por id</li>
 * <li>Atualizar</li>
 * <li>Deletar</li>
 * </ul>
 * @author murilo.soliva
 *
 */

public class CRUDProduto {
	private Connection con = null; // Estabelecer a comunicação com o banco de dados 
	private ResultSet rs = null; // 
	private PreparedStatement pst = null;
	
	
	public String cadastrar(Produto produto) {
		
		String msg = "";
		
		//Criação dos objetos para a conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // pega a pasta do driver de comunicação
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtodb?serverTimezone=UTC","root",""); // entrar na porta, para realizar a conexao remota 
			
			String consulta = "INSERT INTO tbproduto(nomeproduto,descricaoproduto,fabricante,quantidade,preco)values(?,?,?,?,?)"; // pegar da tabela as coisas e trazer o resultado
			
			pst = con.prepareStatement(consulta);
			
			pst.setString(1, produto.getNomeproduto());
			pst.setString(2, produto.getDescricaoproduto());
			pst.setString(3, produto.getFabricante());
			pst.setInt(4, produto.getQuantidade());
			pst.setDouble(5, produto.getPreco());
			
					
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "Não foi possivel cadastrar!";
				
		}
		//comandos de sql
		catch(SQLException ex){
			msg = "erro ao tentar cadastrar:"+ex.getMessage();//mostrar qual é o erro 
		}
		
		//erro geral
		catch(Exception e) {
			msg = "Erro inesperado: "+e.getMessage();
		}
		
		//close critico 
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		
		return msg;
	}
	
	public String atualizar(Produto produto) {
		String msg = "";
		//Criação dos objetos para a conexao com o banco de dados
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // pega a pasta do driver de comunicação
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtodb?serverTimezone=UTC","root",""); // entrar na porta, para realizar a conexao remota 
					
					String consulta = "UPDATE tbproduto SET nomeproduto=?,descricaoproduto=?,=?,fabricante=?,quantidade=?,preco=? WHERE id=?"; // pegar da tabela as coisas e trazer o resultado
					
					pst = con.prepareStatement(consulta);
					
					pst.setString(1, produto.getNomeproduto());
					pst.setString(2, produto.getDescricaoproduto());
					pst.setString(3, produto.getFabricante());
					pst.setInt(4, produto.getQuantidade());
					pst.setDouble(5, produto.getPreco());
					pst.setInt(6, produto.getId());
					
							
					int r = pst.executeUpdate();
					
					
					if(r > 0)
						msg = "Cadastro realizado com sucesso!";
					else
						msg = "Não foi possivel cadastrar!";
						
				}
				//comandos de sql
				catch(SQLException ex){
					msg = "erro ao tentar cadastrar:"+ex.getMessage();//mostrar qual é o erro 
				}
				
				//erro geral
				catch(Exception e) {
					msg = "Erro inesperado: "+e.getMessage();
				}
				
				//close critico 
				finally {
					try{con.close();}catch(Exception e) {e.printStackTrace();}
				}
				
				
				return msg;	
	}
	
	public String deletar(Produto produto) {
		
		String msg = "";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // pega a pasta do driver de comunicação
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtodb?serverTimezone=UTC","root",""); // entrar na porta, para realizar a conexao remota 
			
			String consulta = "DELETE FROM tbcliente WHERE id=?"; // pegar da tabela as coisas e trazer o resultado
			
			pst = con.prepareStatement(consulta);
			
			pst.setInt(1, produto.getId());
		
			
					
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "Não foi possivel cadastrar!";
				
		}
		//comandos de sql
		catch(SQLException ex){
			msg = "erro ao tentar cadastrar:"+ex.getMessage();//mostrar qual é o erro 
		}
		
		//erro geral
		catch(Exception e) {
			msg = "Erro inesperado: "+e.getMessage();
		}
		
		//close critico 
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		
		return msg;	
	}

public List<Produto> PesquisarPorNome(String nomeproduto) {
		
		List<Produto> lista = new ArrayList<Produto>(); //array é um do lado do outro com"," lista é um embaixo do outro
		
		try {
			//carregar o drive de comunicação com o banco de dados 
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Chamar o gerenciado de driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtodb?serverTimezone=UTC","root","");
			
			//Vamos criar a consulta para selecionar os cliente por nome 
			String consulta = "select * from tbproduto where nomeproduto=?";
			
			pst = con.prepareStatement(consulta);			
			
			pst.setString(1, nomeproduto);

			//Vamos executar a consulta e guardar o resultado na variável rs 
			rs = pst.executeQuery();
			
			/*
			 * vamos pegar um cliente por vez que esta no rs e adicioná-lo a lista de clientes para, então retorná-la
			 */
			while(rs.next()) {
				lista.add(new Produto(
						rs.getInt(0),
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getDouble(5)
						));
				
			}//Fim do while
			
		}//fim do try
		
		catch(SQLException ex) {
		ex.printStackTrace();	
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		finally {
			try {con.close();} catch(Exception e) {e.printStackTrace();}
		}
		
		return lista;
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	