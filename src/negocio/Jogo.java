package negocio;

import apresentacao.*;
import java.util.Random;

public class Jogo {

	private Jogador jogador;
	private Tela tela;
	private Terminal terminal;
	private int numeroEscolhido;
	private boolean jogando;
	private Random gerador = new Random();
	
	public Jogo() {
		tela = new Tela();
		terminal = new Terminal();
		jogador = new Jogador();
		numeroEscolhido = gerador.nextInt(50);
		jogando = true;
	}

	public void inciarJogoTerminal() {
		jogador.setNome(terminal.entradaNome());
		terminal.mesagem("Seja bem vindo: " + jogador.getNome());
	}

	public void inciarJogoGUI() {
		jogador.setNome(tela.entradaDados("Qual he o seu nome?"));
		tela.mesagem("Seja bem vindo: " + jogador.getNome());
		jogadas();
	}

	public int solicitarNumero() {
//		if (jogador.getNumeroTentativa() == 1) {
		String numero = tela.entradaDados("Tente um numero:");
		return Integer.parseInt(numero);
//		} else if (verificarMenor(numero)) {
//			String numero = tela.entradaDados("Deu ruim,  voce errou! \n Tente novamente com um numero maior");
//			return Integer.parseInt(numero);
//
//	} else {
//			tela.mesagem("Deu ruim,  voce errou! \n Tente novamente com um numero menor");
//			jogador.setNumeroTentativa();
//
//		}
	}
	
//	public int solicitarNumeroMaior() {
//		String numero = tela.entradaDados("Deu ruim,  voce errou! \n Tente um numero maior");
//		return Integer.parseInt(numero);
//	}
//	
//	public int solicitarNumeroMenor() {
//		String numero = tela.entradaDados("Deu ruim,  voce errou! \n Tente numero menor");
//		return Integer.parseInt(numero);
//	}

	public void jogadas() {
		do {
			verificarAcerto();
		} while (jogando);

		fimDoJogo();
	}

	private void fimDoJogo() {

		String numeros = "";
		for (Integer numero : jogador.getListaNumeros()) {
			numeros += " - " + numero;
		}
		tela.mesagem("Numeros apostados: " + numeros);

	}

	public boolean verificarMenor(int numero) {
		if (numero < numeroEscolhido)
			return true;

		return false;
	}

	public void verificarAcerto() {
		
		int numero = solicitarNumero();
		jogador.addNumero(numero);
		if (numero == numeroEscolhido) {
			tela.mesagem("Parabens voce acertou! numero de tentativas: " + jogador.getNumeroTentativa());
			jogando = false;
		}else if (verificarMenor(numero)) {
				tela.mesagem("Deu ruim,  voce errou! \n Tente novamente com um numero maior");
				jogador.setNumeroTentativa();
				//solicitarNumeroMaior();
//				String numero2 = tela.entradaDados("Informe um numero:");
//				Integer.parseInt(numero2);
				
		} else {
				tela.mesagem("Deu ruim,  voce errou! \n Tente novamente com um numero menor");
				jogador.setNumeroTentativa();
				//solicitarNumeroMenor();
			}
		}
	}

