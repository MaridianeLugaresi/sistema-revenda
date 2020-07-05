package br.ucs.poo.rederevenda.main;
import java.io.Serializable;
import java.util.Scanner;

import br.ucs.poo.rederevenda.sistema.*;;

public class Main implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema(); 
		Scanner in = new Scanner(System.in);
		int opcao = 0;
		
		do {
			mostraMenuPrincipal();
			System.out.println("Informe sua opção :");
			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor informe uma das opções válidas!");
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				menuRevenda(in, sistema);
				break;
			case 2:
				menuMarcas(in, sistema);
				break;
			case 3:
				menuVeiculo(in, sistema);
				break;
			default :
				break;
			}
			in.nextLine();

		} while(opcao != 4);
		
		in.close();
		System.out.println("Você saiu do sistema!");
	
	}

	public static void mostraMenuPrincipal() {
		System.out.println("------------------------------------------------------------");
		System.out.println("                 REVENDAS DE CARROS                         ");
		System.out.println("------------------------------------------------------------");
		System.out.println("1) Revendas");
		System.out.println("2) Marcas");
		System.out.println("3) Veículos");
		System.out.println("4) Sair");
		System.out.println("------------------------------------------------------------");
	}
	
	public static void mostraMenuRevenda() {
		
		System.out.println("------------------------------------");
		System.out.println("             REVENDAS               ");
		System.out.println("------------------------------------");
		System.out.println("1) Incluir");
		System.out.println("2) Alterar");
		System.out.println("3) Excluir");
		System.out.println("4) Pesquisar por código");
		System.out.println("5) Pesquisar por nome");
		System.out.println("6) Listar todas as revendas");
		System.out.println("7) Listar todos os veículos de todas as revendas");
		System.out.println("8) Voltar ao menu principal");
		
	}

	public static void menuRevenda(Scanner in, Sistema sistema) {
		
		int opcao;
		
		do {
			Revenda rev = new Revenda();
			mostraMenuRevenda();
			System.out.println("Informe sua opção :");
			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor informe uma das opções válidas!");
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Informe os dados da nova revenda:");
				System.out.println("Código:");
				rev.setCodigo(in.nextInt());
				in.nextLine();
				System.out.println("Nome:");
				rev.setNome(in.nextLine());
				System.out.println("Cidade:");
				rev.setCidade(in.nextLine());
				System.out.println("Telefone:");
				rev.setTelefone(in.nextLine());
				sistema.adicionarRevenda(rev);
				break;
				
			case 2: //PRINTAR DO LADO OS NOVOS ATUAIS, SE DER ENTER NÃO ALTERA
				System.out.println("Informe o código da revenda a ser alterada:");			
				rev = sistema.buscarRevenda(in.nextInt());
				
				System.out.println("Agora informe os novos dados da revenda:");
				in.nextLine();
				System.out.println("Nome:");
				rev.setNome(in.nextLine());
				System.out.println("Cidade:");
				rev.setCidade(in.nextLine());
				System.out.println("Telefone:");
				rev.setTelefone(in.nextLine());
				sistema.alterarRevenda(rev);
				break;
				
			case 3:
				System.out.println("Informe o código da revenda a ser excluída:");
				rev = sistema.buscarRevenda(in.nextInt());
				sistema.excluirRevenda(rev);
				break;
				
			case 4:
				System.out.println("Informe o código a ser pesquisado:");
				sistema.pesquisarCodigo(in.nextInt());
				break;
				
			case 5:
				in.nextLine();
				System.out.println("Informe o nome da revenda a ser pesquisado:");
				sistema.pesquisarNome(in.nextLine());
				break;
				
			case 6:
				sistema.listarTodas();
				break;
				
			case 7:
				sistema.listarTodosVeiculosTodasRevendas();
				break;
				
			default :
				break;
			}

		} while(opcao != 8);
		return;
	}
	
	public static void mostraMenuMarcas() {
		
		System.out.println("------------------------------------");
		System.out.println("              MARCAS                ");
		System.out.println("------------------------------------");
		System.out.println("1) Incluir");
		System.out.println("2) Alterar");
		System.out.println("3) Excluir");
		System.out.println("4) Pesquisar por código");
		System.out.println("5) Pesquisar por nome");
		System.out.println("6) Listar todas as marcas");
		System.out.println("7) Voltar ao menu principal");
		
	}
	
	public static void menuMarcas(Scanner in, Sistema sistema) {
		
		int opcao;
		
		do {
			Marca marca = new Marca();
			mostraMenuMarcas();
			System.out.println("Informe sua opção :");
			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor informe uma das opções válidas!");
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Informe os dados da nova Marca: ");
				System.out.println("Código: ");
				marca.setCodigo(in.nextInt());
				in.nextLine();
				System.out.println("Nome: ");
				marca.setNome(in.nextLine());
				System.out.println("País de Origem: ");
				marca.setPaisOrigem(in.nextLine());
				sistema.adicionarMarca(marca);
				break;
				
			case 2:
				System.out.println("Informe o código da Marca a ser alterada: ");
				marca = sistema.buscarMarca(in.nextInt());
				
				System.out.println("Agora informe os novos dados da Marca: ");
				System.out.println("Nome: ");
				marca.setNome(in.nextLine());
				System.out.println("País de Origem: ");
				marca.setPaisOrigem(in.nextLine());
				sistema.alterarMarca(marca);
				break;
				
			case 3:
				System.out.println("Informe o código da Marca a ser excluída: ");
				marca = sistema.buscarMarca(in.nextInt());
				sistema.excluirMarca(marca);
				break;
				
			case 4:
				System.out.println("Informe o código a ser pesquisado:");
				sistema.pesquisarCodigoMarca(in.nextInt());
				break;
				
			case 5:
				System.out.println("Informe o nome a ser pesquisado:");
				sistema.pesquisarNomeMarca(in.nextLine());
				break;
				
			case 6:
				sistema.listarTodasMarcas();
				break;
				
			default :
				break;
			}

		} while(opcao != 7);
		return;
	}
	
	public static void mostraMenuVeiculo() {
		
		System.out.println("------------------------------------");
		System.out.println("             VEÍCULOS               ");
		System.out.println("------------------------------------");
		System.out.println("1) Incluir");
		System.out.println("2) Alterar");
		System.out.println("3) Excluir");
		System.out.println("4) Pesquisar por placa");
		System.out.println("5) Pesquisar por nome");
		System.out.println("6) Pesquisar por marca");
		System.out.println("7) Pesquisar por cor");
		System.out.println("8) Pesquisar por faixa de preço");
		System.out.println("9) Listar todos os veículos");
		System.out.println("10) Voltar ao menu principal");
		
	}
	
	public static void menuVeiculo(Scanner in, Sistema sistema) {
		
		int opcao;
		int tipoVeiculo;
		int converteBoolean;
		Revenda revendaAtual = new Revenda();
		
		System.out.println("\nInforme o código da revenda que deseja fazer manutenção: ");
		revendaAtual = sistema.buscarRevenda(in.nextInt());
		
		do {
			Carro carro = new Carro();
			Caminhao caminhao = new Caminhao();
			mostraMenuVeiculo();
			System.out.println("Informe sua opção :");
			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor informe uma das opções válidas!");
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Informe o tipo de veículo a ser inserido: ");
				System.out.println("1 - Carro       2 - Caminhão");
				tipoVeiculo = in.nextInt();
				
				if (tipoVeiculo == 1) {
					in.nextLine();
					System.out.println("Informe os dados do Carro: ");
					System.out.println("Nome: ");
					carro.setNome(in.nextLine());
					System.out.println("Placa: ");
					carro.setPlaca(in.nextLine());
					System.out.println("Preço: ");
					carro.setPreco(in.nextDouble());
					System.out.println("Ano de fabricação: ");
					carro.setAno(in.nextInt());
					in.nextLine();
					System.out.println("Cor: ");
					carro.setCor(in.nextLine());
					System.out.println("Informe se o carro é importado. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						carro.setImportado(true);
					} else {
						carro.setImportado(false);
					}
					System.out.println("Informe quantas portas o carro tem: ");
					carro.setPortas(in.nextInt());
					System.out.println("Informe se o carro é automático. \nOpções:  1 - Sim   0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						carro.setAutomatico(true);
					} else {
						carro.setAutomatico(false);
					}
					System.out.println("Escolha a marca do carro pelo código. Opções: ");
					sistema.listarTodasMarcas();
					carro.setMarca(sistema.buscarMarca(in.nextInt()));
					revendaAtual.adicionarCarro(carro);
				}
				if (tipoVeiculo == 2) {
					in.nextLine();
					System.out.println("Informe os dados para o novo Caminhão: ");
					System.out.println("Nome: ");
					caminhao.setNome(in.nextLine());
					System.out.println("Placa: ");
					caminhao.setPlaca(in.nextLine());
					System.out.println("Preço: ");
					caminhao.setPreco(in.nextDouble());
					System.out.println("Ano de fabricação: ");
					caminhao.setAno(in.nextInt());
					in.nextLine();
					System.out.println("Cor: ");
					caminhao.setCor(in.nextLine());
					System.out.println("Informe se o caminhão é importado. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						caminhao.setImportado(true);
					} else {
						caminhao.setImportado(false);
					}
					System.out.println("Informe a capacidade do caminhão: ");
					caminhao.setCapacidade(in.nextInt());
					System.out.println("Informe se o caminhão é truck. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						caminhao.setImportado(true);
					} else {
						caminhao.setImportado(false);
					}
					System.out.println("Escolha a marca do caminhão pelo código. Opções: ");
					sistema.listarTodasMarcas();
					caminhao.setMarca(sistema.buscarMarca(in.nextInt()));
					revendaAtual.adicionarCaminhao(caminhao);
				}
				break;
				
			case 2:
				System.out.println("Informe o tipo de veículo a ser alterado: ");
				System.out.println("1 - Carro       2 - Caminhão");
				tipoVeiculo = in.nextInt();
				
				if (tipoVeiculo == 1) {
					in.nextLine();
					System.out.println("Informe a placa do Carro: ");
					carro = revendaAtual.buscarCarro(in.nextLine());
					
					System.out.println("Informe os novos dados para o Carro: ");
					System.out.println("Nome: ");
					carro.setNome(in.nextLine());
					System.out.println("Preço: ");
					carro.setPreco(in.nextDouble());
					System.out.println("Ano de fabricação: ");
					carro.setAno(in.nextInt());
					in.nextLine();
					System.out.println("Cor: ");
					carro.setCor(in.nextLine());
					System.out.println("Informe se o carro é importado. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						carro.setImportado(true);
					} else {
						carro.setImportado(false);
					}
					System.out.println("Informe quantas portas o carro tem: ");
					carro.setPortas(in.nextInt());
					System.out.println("Informe se o carro é automático. \nOpções:  1 - Sim   0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						carro.setAutomatico(true);
					} else {
						carro.setAutomatico(false);
					}
					System.out.println("Escolha a marca do carro pelo código. Opções: ");
					sistema.listarTodasMarcas();
					carro.setMarca(sistema.buscarMarca(in.nextInt()));
					revendaAtual.alterarCarro(carro);
				}
				if (tipoVeiculo == 2) {
					in.nextLine();
					System.out.println("Informe a placa do Caminhão: ");
					caminhao = revendaAtual.buscarCaminhao(in.nextLine());
					
					System.out.println("Informe os novos dados para o Caminhão: ");
					System.out.println("Nome: ");
					caminhao.setNome(in.nextLine());
					System.out.println("Preço: ");
					caminhao.setPreco(in.nextDouble());
					System.out.println("Ano de fabricação: ");
					caminhao.setAno(in.nextInt());
					in.nextLine();
					System.out.println("Cor: ");
					caminhao.setCor(in.nextLine());
					System.out.println("Informe se o caminhão é importado. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						caminhao.setImportado(true);
					} else {
						caminhao.setImportado(false);
					}
					System.out.println("Informe a capacidade do caminhão: ");
					caminhao.setCapacidade(in.nextInt());
					System.out.println("Informe se o caminhão é truck. \nOpções:  1 - Sim  0 - Não ");
					converteBoolean = in.nextInt();
					if (converteBoolean == 1) {
						caminhao.setImportado(true);
					} else {
						caminhao.setImportado(false);
					}
					System.out.println("Escolha a marca do caminhão pelo código. Opções: ");
					sistema.listarTodasMarcas();
					caminhao.setMarca(sistema.buscarMarca(in.nextInt()));
					revendaAtual.alterarCaminhao(caminhao);
				}
				break;
				
			case 3:
				in.nextLine();
				System.out.println("Informe a placa do veículo a ser excluído: ");
				revendaAtual.excluirVeiculo(in.nextLine());
				break;
				
			case 4:
				in.nextLine();
				System.out.println("Informe a placa do veículo a ser pesquisada: ");
				revendaAtual.pesquisarPlaca(in.nextLine());
				break;
				
			case 5:
				in.nextLine();
				System.out.println("Informe o nome do veículo a ser pesquisado: ");
				revendaAtual.pesquisarNome(in.nextLine());
				break;
				
			case 6:
				System.out.println("Escolha a marca a ser pesquisada pelo seu código: ");
				sistema.listarTodasMarcas();
				revendaAtual.pesquisarMarcaVeiculo(sistema.buscarMarca(in.nextInt()));
				break;
				
			case 7:
				in.nextLine();
				System.out.println("Informe a cor do veículo a ser pesquisado: ");
				revendaAtual.pesquisarCor(in.nextLine());
				break;
				
			case 8:
				System.out.println("Informe o valor minimo e o máximo para o preço: ");
				revendaAtual.pesquisarFaixaPreco(in.nextDouble(), in.nextDouble());
				break;
				
			case 9:
				revendaAtual.listarTodosVeiculos();
				break;
				
			default :
				break;
			}

		} while(opcao != 10);
		return;
	}
}

