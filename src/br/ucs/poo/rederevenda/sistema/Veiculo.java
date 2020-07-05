package br.ucs.poo.rederevenda.sistema;

import java.io.Serializable;

public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String placa;
	private double preco;
	private int ano;
	private String cor;
	private boolean importado; //setar 0 e 1 para não dar problema
	private Marca marca;
	
	
	public Veiculo(String nome, String placa, double preco, int ano, String cor, boolean importado, Marca marca) {
		super();
		this.nome = nome;
		this.placa = placa;
		this.preco = preco;
		this.ano = ano;
		this.cor = cor;
		this.importado = importado;
		this.marca = marca;
	}

	public Veiculo() {
		super();
	}

	public String getNome() {
		return nome;
	}


	public String getPlaca() {
		return placa;
	}


	public double getPreco() {
		return preco;
	}


	public int getAno() {
		return ano;
	}


	public String getCor() {
		return cor;
	}


	public boolean isImportado() {
		return importado;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Placa: " + placa + ", Preco: " + preco + ", Ano: " + ano
				+ ", Cor: " + cor + ", Importado: " + importado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

}
