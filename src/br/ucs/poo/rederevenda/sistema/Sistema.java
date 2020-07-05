package br.ucs.poo.rederevenda.sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sistema implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	List<Revenda> revendas = new ArrayList<>();
	List<Marca> marcas = new ArrayList<>();
	int indiceRevendaAtual;
	
	public void adicionarRevenda(Revenda revenda) {
		if(revendas.contains(revenda)){
			System.out.println("\nA revenda informada já existe! Nenhuma operação foi realizada");
			return;
		}
		revendas.add(revenda);
	}
	
	public void alterarRevenda(Revenda revenda) {
		for (Revenda rev : revendas) {
			if (rev.getCodigo() == revenda.getCodigo()) {
				rev.setCidade(revenda.getCidade());
				rev.setNome(revenda.getNome());
				rev.setTelefone(revenda.getTelefone());
			}
		}
	}
	
	public void excluirRevenda(Revenda revenda) {
		if (revendas.contains(revenda)) {
			revendas.remove(revenda);
		} else {
			System.out.println("Revenda informada não foi encontrada!");
		}
	}
	
	public Revenda buscarRevenda(int codigo) {
		for (Revenda rev : revendas) {
			if(rev.getCodigo() == codigo) {
				return rev;
			}
		}
		return null;
		//TODO: IMPLEMENTAR UM EXECPTION DE REVENDA NÃO ENCONTRADA
	}
	
	public void pesquisarCodigo(int codigo) {
		for (Revenda rev : revendas) {
			if(rev.getCodigo() == codigo) {
				System.out.println(rev.toString());
				return;
			}
		}
		System.out.println("Revenda não encontrada");
	}
	
	public void pesquisarNome(String nome) {
		for (Revenda rev : revendas) {
			if(rev.getNome().equalsIgnoreCase(nome)) {
				System.out.println(rev.toString());
			}
		}
	}
	
	public void listarTodas() {
		for (Revenda rev : revendas) {
			System.out.println(rev.toString());
		}
	}
	
	public void listarTodosVeiculosTodasRevendas() {
		for (Revenda rev : revendas) {
			System.out.println(rev.toString());
			System.out.println("\nCARROS");
			for (Carro carro : rev.carros) {
				System.out.println(carro.toString());
			}
			System.out.println("\nCAMINHÕES");
			for (Caminhao caminhao : rev.caminhoes) {
				System.out.println(caminhao.toString());
			}
		}
	}
	
	public void adicionarMarca(Marca marca) {
		if(marcas.contains(marca)) {
			System.out.println("A marca informada já esta registrada no sistema!");
			return;
		}
		marcas.add(marca);
	}
	
	public void alterarMarca(Marca marca) {
		for (Marca mar : marcas) {
			if (mar.getCodigo() == marca.getCodigo()) {
				mar.setNome(marca.getNome());
				mar.setPaisOrigem(marca.getPaisOrigem());
			}
		}
	}
	
	public void excluirMarca(Marca marca) {
		if (marcas.contains(marca)) {
			marcas.remove(marca);
		} else {
			System.out.println("A marca informada não foi encontrada!");
		}
	}
	
	public void pesquisarCodigoMarca(int codigo) {
		for (Marca marca : marcas) {
			if (marca.getCodigo() == codigo) {
				System.out.println(marca.toString());
			}
		}
	}
	
	public void pesquisarNomeMarca(String nome) {
		for (Marca marca : marcas) {
			if (marca.getNome().equalsIgnoreCase(nome)) {
				System.out.println(marca.toString());
			}
		}
	}
	
	public void listarTodasMarcas() {
		for (Marca marca : marcas) {
			System.out.println(marca.toString());
		}
	}
	
	public Marca buscarMarca(int codigo) {
		for (Marca marca : marcas) {
			if (marca.getCodigo() == codigo) {
				return marca;
			}
		}
		return null;
		//TODO: IMPLEMENTAR EXCEPTION
	}
	
	public int retornarRevendaAtual(int codigo) {
		for (Revenda rev : revendas) {
			if(rev.getCodigo() == codigo) {
				return revendas.indexOf(rev);
			}
		}
		System.out.println("Revenda não encontrada");
		return -1;
	}
	
	public void gravarArquivo() {
		try {
			FileOutputStream fo = new FileOutputStream("revendas.dat");
			ObjectOutputStream ou = new ObjectOutputStream(fo);
			ou.writeObject(revendas);
			ou.close();
			fo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fo = new FileOutputStream("marcas.dat");
			ObjectOutputStream ou = new ObjectOutputStream(fo);
			ou.writeObject(marcas);
			ou.close();
			fo.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void lerArquivo() {
		File f = new File("revendas.dat");
		
		if (f.exists()) {
			try {
				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				Object o = oi.readObject();
				revendas = (List<Revenda>) o;
				oi.close();
				fi.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		File f1 = new File("marcas.dat");
		
		if (f1.exists()) {
			try {
				FileInputStream fi = new FileInputStream(f1);
				ObjectInputStream oi = new ObjectInputStream(fi);
				Object o = oi.readObject();
				marcas = (List<Marca>) o;
				oi.close();
				fi.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
