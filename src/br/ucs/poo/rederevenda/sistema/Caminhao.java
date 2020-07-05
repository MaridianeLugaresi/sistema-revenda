package br.ucs.poo.rederevenda.sistema;

import java.io.Serializable;

public class Caminhao extends Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int capacidade;
	private boolean truck; //setar 0 e 1 para não dar problema
	
	
	public int getCapacidade() {
		return capacidade;
	}
	public boolean isTruck() {
		return truck;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public void setTruck(boolean truck) {
		this.truck = truck;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", Placa: " + getPlaca() + ", Preco: " + getPreco() + ", Ano: " + 
				getAno() + ", Cor: " + getCor() + ", Importado: " + isImportado() + ", Marca: " + 
				getMarca().getNome() + ", Capacidade: " + capacidade + ", Truck: " + truck; 
	}
	
	
}
