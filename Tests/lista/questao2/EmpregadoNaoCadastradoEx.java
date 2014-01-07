package questao2;

public class EmpregadoNaoCadastradoEx extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EmpregadoNaoCadastradoEx() {
		throw new RuntimeException("Nao ha empregado cadastrado com esse codigo");
	}

}
