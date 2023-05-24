package negocio;

import java.io.LineNumberInputStream;
import java.util.ArrayList;

public class Jogador {

	private String nome;
	private int pontuacao;
	private int numeroTentativa;
	private ArrayList<Integer> listaNumeros;

	public Jogador() {
	    listaNumeros= new ArrayList<Integer>();
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumeroTentativa() {
		return numeroTentativa;
	}

	public void setNumeroTentativa() {
		if (numeroTentativa == 1) {
		this.numeroTentativa++;
		}
	}
	
	public ArrayList<Integer> getListaNumeros(){
		return listaNumeros;
	}

	
	public void addNumero(int numeroApostado) {
		listaNumeros.add(numeroApostado);
	}
}