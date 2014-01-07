/*
 introspec��o: acessar os metodos e campos em uma classe durante execu��o
 reflex�o: alterar campos e metodos de uma classe durante a execu��o  
 */

package introspection;

public class Programa {

	public static void main(String[] args) {
		Object o = novaClasse("FilmeBean");

		System.out.println(o.getClass().getName());
	}

	public static Object novaClasse(String nomeDaClasse) {
		if (nomeDaClasse.equals("FilmeBean"))
			return new FilmeBean();
		else
			return null;
	}
	//Manuten��o dif�cil - a cada classe nova temos de criar mais uma perna no IF

}
