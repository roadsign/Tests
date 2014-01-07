package questao2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class EmpregadoDB implements BD {

	private Hashtable<String, Empregado> tabela;

	public EmpregadoDB() {
		tabela = new Hashtable<String, Empregado>();
	}
	
	public EmpregadoDB(Hashtable<String, Empregado> tabela){
		this.tabela = tabela;
	}
	

	public void cadastraEmpregado(Empregado empregado) {
		tabela.put(empregado.getCodigo(), empregado);
	}

	public Hashtable<String, Empregado> getCadastroEmpregado() {
		return tabela;
	}

	public void salvaArquivo(Hashtable<String, Empregado> hashTable, String nomeArquivo) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(tabela);
		out.close();
		fileOut.close();
	}

	@SuppressWarnings("unchecked")
	public void leArquivo(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(nomeArquivo);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		tabela = (Hashtable<String, Empregado>) in.readObject();
		in.close();
		fileIn.close();
	}
	
	public Empregado getEmpregado (String codigo){
		return tabela.get(codigo);
	}

}
