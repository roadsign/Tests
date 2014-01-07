package questao2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public interface BD {
	public void cadastraEmpregado(Empregado empregado);
	public Hashtable<String,Empregado> getCadastroEmpregado();
	public void salvaArquivo(Hashtable<String,Empregado> hashTable, String nomeArquivo) throws IOException;
	public void leArquivo(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException;
}
