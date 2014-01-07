package br.uerj.ime.lp2.texto;

import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("Escreva A para dizer um nome de arquivo ou S para sair");
		scanner = new Scanner(System.in);
		
		char entrada = scanner.nextLine().toLowerCase().charAt(0);;
		while (entrada == 'a'){
			
			if (entrada != 'a' && entrada != 's')
				System.out.println("Opcao invalida");

			else if (entrada == 'a') {

				System.out.println("Escreva o nome do arquivo com o seu caminho completo:");
				TextoArquivo textoArquivo = new TextoArquivo(scanner.nextLine());
				String[] nome = textoArquivo.getNomeArquivo().split("[.]");
				String dirNovoArquivo = String.format("%s\\estatisticas(%s).%s", textoArquivo.getFileParent(),
						nome[0], nome[1]);
				String textoNovoArquivo = "";

				StringBuffer buffer = new StringBuffer();
				buffer.append("Numero de vogais: " + textoArquivo.getNumVogais());
				buffer.append("\nNumero de consoantes: " + textoArquivo.getNumConsoantes());
				buffer.append("\nNumero de espacos: " + textoArquivo.getNumEspacos());
				buffer.append("\nNumero de caracteres especiais: "
						+ textoArquivo.caracteresEspeciais(textoArquivo.toString()));
				buffer.append("\nTotal de caracteres: " + textoArquivo.toString().length());
				textoNovoArquivo = buffer.toString();

				textoArquivo.escreveArquivo(dirNovoArquivo, textoNovoArquivo);

				System.out.println(textoNovoArquivo);
			}
			else
				break;
			
			System.out.println("Escreva A para dizer um nome de arquivo ou S para sair");
			entrada = scanner.nextLine().toLowerCase().charAt(0);
		}


	}

}
