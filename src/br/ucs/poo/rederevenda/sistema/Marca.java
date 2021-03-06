package br.ucs.poo.rederevenda.sistema;

import java.io.Serializable;

public class Marca implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String paisOrigem;
	
	public Marca() {
		super();
	}

	public Marca(int codigo, String nome, String paisOrigem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Nome: " + nome + ", País de Origem: " + paisOrigem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Marca other = (Marca) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
