package br.ucs.poo.rederevenda.sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Revenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String cidade;
	private String telefone;
	
	List<Carro> carros = new ArrayList<>();
	List<Caminhao> caminhoes = new ArrayList<>();
	
	public Revenda(int codigo, String nome, String cidade, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.telefone = telefone;
	}
	
	public Revenda() {
		super();
	}

	public void adicionarCarro(Carro carro) {
		for (Carro car : carros) {
			if (car.getPlaca().equalsIgnoreCase(carro.getPlaca())) {
				System.out.println("O carro informado já existe!");
				return;
			}
		}
		carros.add(carro);
	}
	
	public void adicionarCaminhao(Caminhao caminhao) {
		for (Caminhao camin : caminhoes) {
			if (camin.getPlaca().equalsIgnoreCase(caminhao.getPlaca())) {
				System.out.println("O caminhão informado já existe!");
				return;
			}
		}
		caminhoes.add(caminhao);
	}
	
	public void excluirVeiculo(String placa) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getPlaca().equalsIgnoreCase(placa)) {
				caminhoes.remove(caminhao);
				return;
			}
		}
		for (Carro carro : carros) {
			if (carro.getPlaca().equalsIgnoreCase(placa)) {
				carros.remove(carro);
				return;
			}
		}
		System.out.println("A placa do veículo informada não foi encontrada!");
	}
	
	public void alterarCarro(Carro carro) {
		for (Carro car : carros) {
			if (car.getPlaca().equalsIgnoreCase(carro.getPlaca())) {
				car.setAno(carro.getAno());
				car.setAutomatico(carro.isAutomatico());
				car.setCor(carro.getCor());
				car.setImportado(carro.isImportado());
				car.setMarca(carro.getMarca());
				car.setNome(carro.getNome());
				car.setPortas(carro.getPortas());
				car.setPreco(carro.getPreco());
			}
		}
	}
	
	public void alterarCaminhao(Caminhao caminhao) {
		for (Caminhao cami : caminhoes) {
			if (cami.getPlaca().equalsIgnoreCase(caminhao.getPlaca())) {
				cami.setAno(caminhao.getAno());
				cami.setTruck(caminhao.isTruck());
				cami.setCor(caminhao.getCor());
				cami.setImportado(caminhao.isImportado());
				cami.setMarca(caminhao.getMarca());
				cami.setNome(caminhao.getNome());
				cami.setPreco(caminhao.getPreco());
				cami.setCapacidade(caminhao.getCapacidade());
			}
		}
	}
	
	public Caminhao buscarCaminhao(String placa) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getPlaca().equalsIgnoreCase(placa)) {
				return caminhao;
			}
		}
		return null;
		//TODO: IMPLEMENTAR EXCEPTION
	}
	
	public Carro buscarCarro(String placa) {
		for (Carro carro : carros) {
			if (carro.getPlaca().equalsIgnoreCase(placa)) {
				return carro;
			}
		}
		return null;
		//TODO: IMPLEMENTAR EXCEPTION
	}
	
	public void pesquisarPlaca(String placa) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getPlaca().equalsIgnoreCase(placa)) {
				System.out.println(caminhao.toString());
				return;
			}
		}
		for (Carro carro : carros) {
			if (carro.getPlaca().equalsIgnoreCase(placa)) {
				System.out.println(carro.toString());
				return;
			}
		}
		System.out.println("A placa do veículo informada não foi encontrada!");
	}
	
	public void pesquisarNome(String nome) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getNome().equalsIgnoreCase(nome)) {
				System.out.println(caminhao.toString());
			}
		}
		for (Carro carro : carros) {
			if (carro.getNome().equalsIgnoreCase(nome)) {
				System.out.println(carro.toString());
			}
		}
	}
	
	public void pesquisarCor(String cor) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getCor().equalsIgnoreCase(cor)) {
				System.out.println(caminhao.toString());
			}
		}
		for (Carro carro : carros) {
			if (carro.getCor().equalsIgnoreCase(cor)) {
				System.out.println(carro.toString());
			}
		}
	}
	
	public void pesquisarFaixaPreco(double min, double max) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getPreco() >= min && caminhao.getPreco() <= max) {
				System.out.println(caminhao.toString());
			}
		}
		for (Carro carro : carros) {
			if (carro.getPreco() >= min && carro.getPreco() <= max) {
				System.out.println(carro.toString());
			}
		}
	}
	
	public void listarTodosVeiculos() {
		System.out.println("CAMINHÕES");
		for (Caminhao caminhao : caminhoes) {
			System.out.println(caminhao.toString());
		}
		System.out.println("\nCARROS");
		for (Carro carro : carros) {
			System.out.println(carro.toString());
		}
	}

	public void pesquisarMarcaVeiculo(Marca marca) {
		for (Caminhao caminhao : caminhoes) {
			if (caminhao.getMarca() == marca) {
				System.out.println(caminhao.toString());
			}
		}
		for (Carro carro : carros) {
			if (carro.getMarca() == marca) {
				System.out.println(carro.toString());
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Nome: " + nome + ", Cidade: " + cidade + ", Telefone: " + telefone;
	}
	
}