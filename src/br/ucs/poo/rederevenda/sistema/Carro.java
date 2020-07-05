package br.ucs.poo.rederevenda.sistema;

import java.io.Serializable;

public class Carro extends Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int portas;
	private boolean automatico; //setar 0 e 1 para não dar problema

	public int getPortas() {
		return portas;
	}
	public boolean isAutomatico() {
		return automatico;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", Placa: " + getPlaca() + ", Preco: " + getPreco() + ", Ano: " + getAno() + 
				", Cor: " + getCor() + ", Importado: " + isImportado() + ", Marca: " + getMarca().getNome() + ", Portas: " + 
				portas + ", Automatico: " + automatico;
	}
	
	
	
}
