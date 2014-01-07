package questao2;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	private static EmpregadoDB banco = new EmpregadoDB();
	private static Hashtable<String, Empregado> tabela;
	
	public static void main(String[] args) {		
		System.out.println("Digite a opção desejada:");
		System.out.println("----------------------\n");
		System.out.println("A - Abrir arquivo\n");
		System.out.println("N - Novo cadastro\n");
		System.out.println("S - Salvar arquivo\n");
		System.out.println("C - Cadastrar empregado\n");
		System.out.println("Q - Consultar cadastro\n");
		System.out.println("X - Sair\n");
		System.out.println("----------------------\n");
		
		scanner = new Scanner(System.in);
		char opcao = ' ';
		
		while (opcao != 'x'){
  		opcao = scanner.nextLine().toLowerCase().charAt(0);
  		switch (opcao){
  			case 'a': abrirArquivo();
  			case 'n': novoCadastro();
  			case 's': salvarArquivo();
  			case 'c': cadastrarEmpregado();
  			case 'q': consultarCadastro();
  		}
		}
		
		System.out.println("Fim do programa");
				
	}
	
	private static void abrirArquivo (){
		System.out.println("Digite o nome do arquivo:");
		String nomeArquivo = scanner.nextLine();
		
		try {
			banco.leArquivo(nomeArquivo);
		}
		catch (ClassNotFoundException | IOException e) {
			System.out.println("Erro ao ler o arquivo");
			e.printStackTrace();
		}
	}
	
	private static void novoCadastro (){
		banco = new EmpregadoDB(tabela);
	}
	
	private static void salvarArquivo (){
		System.out.println("Digite o nome do arquivo:");
		String nomeArquivo = scanner.nextLine();
		
		try {
			banco.salvaArquivo(tabela, nomeArquivo);
		}
		catch (IOException e) {
			System.out.println("Erro ao salvar o arquivo");
			e.printStackTrace();
		}
	}
	
	private static void cadastrarEmpregado (){
		System.out.println("Digite a opção desejada:");
		System.out.println("----------------------\n");
		System.out.println("1 - Cadastrar empregado\n");
		System.out.println("2 - Cadastrar empregado contratado\n");
		System.out.println("----------------------\n");
		
		char opcao = scanner.next().toLowerCase().charAt(0);
		
		String codigo = "", nome = "";
		double salario = 0.0;
		int numeroDependentes = 0;
		
		if (opcao == '1' || opcao == '2'){
			System.out.print("Codigo:");
			codigo = scanner.next();
			System.out.print("\nNome:");
			nome = scanner.nextLine();
			System.out.print("\nSalario:");
			salario = scanner.nextDouble();
		}
		if (opcao == '1'){
			banco.cadastraEmpregado(new Empregado(nome, codigo, salario));
		}
		else if (opcao == '2'){
			System.out.print("\nNumero de dependentes:");
			numeroDependentes = scanner.nextInt();
			banco.cadastraEmpregado(new EmpregadoContratado(nome, codigo, salario, numeroDependentes));
		}
		else
			System.out.println("Opcao invalida");
	}
	
	private static void consultarCadastro (){
		System.out.println("Digite o codigo do usuario:");
		String codigo = scanner.next();
		
		Empregado empregado = banco.getEmpregado(codigo);
		
		if (empregado == null)		
			System.out.println("Empregado nao consta no banco de dados");
		else
			System.out.println(empregado);
	}
	

}
