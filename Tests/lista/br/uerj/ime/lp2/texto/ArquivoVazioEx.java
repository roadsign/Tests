package br.uerj.ime.lp2.texto;

public class ArquivoVazioEx extends Exception {

	private static final long serialVersionUID = 1L;

	private String erro;
	
	public ArquivoVazioEx(String erro) {
		this.erro = erro;
	}

	public String toString() {
		return erro;
	}	

}
