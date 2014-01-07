// Aluno:		Victor Emmanuel Pires Pereira Mota Campos
// Matricula:	201220428211
// Turma:		Linguagen de Programacao 2 - 2013.2

package br.uerj.ime.lp2.texto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Frase {

	protected String frase;
	private int vogais;
	private int consoantes;
	private int espacos;

	public Frase(String frase) {
		setFrase(frase);
	}

	public void setFrase(String frase) {
		this.frase = frase;
		this.vogais = 0;
		this.consoantes = 0;
		this.espacos = 0;
		contarCaracteres();
	}

	public int getNumVogais() {
		return this.vogais;
	}

	public int getNumConsoantes() {
		return this.consoantes;
	}

	public int getNumEspacos() {
		return this.espacos;
	}

	private void contaVogais() {
		for (char caracter : frase.toCharArray()) {
			switch (Character.toLowerCase(caracter)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vogais++;
					break;
				default:
			}
		}

	}

	private void contaConsoantes() {
		for (char caracter : frase.toCharArray()) {
			switch (Character.toLowerCase(caracter)) {
				case 'b':
				case 'c':
				case 'd':
				case 'f':
				case 'g':
				case 'h':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z':
					consoantes++;
					break;
				default:
			}
		}
	}

	private void contaEspacos() {

		for (char caracter : frase.toCharArray()) {
			switch (caracter) {
				case ' ':
					espacos++;
					break;
				default:
			}
		}
	}

	protected void contarCaracteres() {
		contaVogais();
		contaConsoantes();
		contaEspacos();

	}

	public String ordena() {
		String fraseOrdenada = "";
		
		ArrayList<String> palavras = new ArrayList<String>();
		
		String[] temp = this.frase.split("[ .,;]");
		
		for (String palavra : temp)
			palavras.add(palavra);
		
		Collections.sort(palavras, new Comparator<String>(){
			public int compare(String a, String b) {
				return a.compareToIgnoreCase(b);
			}			
		});
		
		for (String palavra : palavras)
			fraseOrdenada += palavra + " ";
		
		//remove o espaco adicional a direita	
		return fraseOrdenada.substring(0, fraseOrdenada.length() - 1);			

	}
	
	public String toString(){
		return this.frase;
	}
}
