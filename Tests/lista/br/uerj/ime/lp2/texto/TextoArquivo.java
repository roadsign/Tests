package br.uerj.ime.lp2.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextoArquivo extends Frase {

	private int caracteresEspeciais;
	private String nomeArquivo;
	private String parent;

	public TextoArquivo(String nomeArquivo) {
		super("");
		try {
			setFrase(leArquivo(nomeArquivo));
		}
		catch (ArquivoVazioEx excecao) {
			System.out.println(excecao);
		}
		finally {
			caracteresEspeciais = 0;
		}
	}

	public String leArquivo(String nomeArquivo) throws ArquivoVazioEx {
		String entrada = "";
		File file = new File(nomeArquivo);

		this.nomeArquivo = file.getName();
		this.parent = file.getParent();

		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
			e.printStackTrace();
		}

		if (file.length() == 0)
			throw new ArquivoVazioEx("Esse arquivo nao contem texto");

		while (scanner.hasNext())
			entrada += scanner.next() + " ";

		scanner.close();

		setFrase(entrada);

		return entrada;

	}

	public void escreveArquivo(String nomeArquivo, String texto) {
		System.out.println(nomeArquivo);
		File file = new File(nomeArquivo);
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(file);
			printer.write(texto);
		}
		catch (FileNotFoundException e) {
			System.out.println("Nome de arquivo ilegal.");
			e.printStackTrace();
		}
		finally {
			printer.close();
		}

	}

	public int caracteresEspeciais(String frase) {
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
				case ' ':
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					break;
				default:
					caracteresEspeciais++;
			}
		}

		return caracteresEspeciais;
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public String getFileParent() {
		return this.parent;
	}
}
