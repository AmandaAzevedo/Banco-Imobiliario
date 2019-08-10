package ufpb.jogo;

import java.util.LinkedList;
import java.util.Scanner;

//ENTRADA ACEITAR APENAS N�MEROS INTEIROS SEM D� ERRO
//ENTRADA DE CORES SO ACEITAR O NOME DAS CORES CORRETAS


/**
 * Class that has the methods to starts and ends and other objects that make up the game.
 * @author Clebson
 */
public class Jogo {
	private static final Scanner input = new Scanner(System.in);
	private int numeroDeJogadores;
	private LinkedList<Jogador> listaJogadores;
	private int cont = 0;
	private Dado dado = new Dado();
	private Tabuleiro tabuleiro = new Tabuleiro();

	public Jogo() {
		listaJogadores = new LinkedList<Jogador>();
	}

	/**
	 * Starts the game
	 * @author Clebson
	 */
	public void iniciarJogo() {
		nJogadores();
		criarJogadores();
		System.out.println("O Banco Imobiliario vai comecar. Aproveite!");
		partida();

	}

	/**
	 * Defines the number of players
	 * @author Clebson
	 */
	private void nJogadores() {
		System.out.println("Digite o numero de jogadores [2 - 8]: ");
		int numero = Integer.parseInt(input.nextLine());
		if (numero > 8 || numero < 2) {
			nJogadores();
		} else {
			this.numeroDeJogadores = numero;
		}
	}

	/**
	 * Method that creates the player(name and color pawn/)
	 * @author Clebson
	 */
	private void criarJogadores() {
		int cont = 0;
		while (cont < numeroDeJogadores) {
			System.out.println("Digite o nome do jogador" + (cont + 1) + ":");
			String nome = input.nextLine();
			System.out.println("Digite a cor:");
			String cor = input.nextLine();
			this.listaJogadores.add(new Jogador(nome, cor));
			cont += 1;
		}
	}

	/**
	 * Method that shows the options available to the player.
	 * @author Joyce
	 */
	private void opcoes(Jogador j) {
		System.out.println("A jogada de " + j.toString() + "começou:");
		System.out.println("Comandos disponíveis: [jogar][sair]\n Entre com um comando:");
		String opcao = input.nextLine();
		switch (opcao) {
		case "jogar":
			j.jogada(this.dado, this.tabuleiro);
			break;
		case "sair":
			System.out.println("sim/nao");
			String sair = input.nextLine();
			if (sair.equals("sim") || sair.equals("s")) {
				if (this.listaJogadores.size() > 2) {
					this.numeroDeJogadores -= 1;
					listaJogadores.remove(this.cont);
					partida();
					break;
				} else {
					System.out.println("Jogo encerrado.");
					System.exit(0);
				}
			} else {
				opcoes(j);
				break;
			}

		}
	}

	/**
	 * The match
	 * @author Joyce
	 */
	private void partida() {
		while (this.cont < this.numeroDeJogadores) {
			System.out.println(this.cont);
			opcoes(listaJogadores.get(this.cont));
			cont += 1;
		}
		this.cont = 0;
		partida();

	}

}
