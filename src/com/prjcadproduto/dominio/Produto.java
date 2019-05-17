package com.prjcadproduto.dominio;

public class Produto {
	
	private int id;
	private String nomeproduto;
	private String descricaoproduto;
	private String fabricante;
	private int quantidade;
	private double preco;
	
	public Produto() {
	}

	public Produto(int id, String nomeproduto, String descricaoproduto, String fabricante, int quantidade,
			double preco) {
		this.id = id;
		this.nomeproduto = nomeproduto;
		this.descricaoproduto = descricaoproduto;
		this.fabricante = fabricante;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public String getDescricaoproduto() {
		return descricaoproduto;
	}

	public void setDescricaoproduto(String descricaoproduto) {
		this.descricaoproduto = descricaoproduto;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
