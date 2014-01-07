// Aluno:		Victor Emmanuel Pires Pereira Mota Campos
// Matricula:	201220428211
// Turma:		Linguagen de Programacao 2 - 2013.2

package questao2;

public class EmpregadoContratado extends Empregado {
	
	private int numDeps = 0;
	private double salarioFam;
	private final double valorPorDep = 9.58;
	private final double aliquotaIR = 0.15;
	
	EmpregadoContratado (String nom, String cod, double salario, int nDep){
		super (nom, cod, salario);
		numDeps = nDep;
	}
	
	void calculaSalario(){
		salarioLiq = (super.calculaSalario(aliquotaIR));
	}
	
	void calculaSalario (int numeroDependentes){
		salarioFam = valorPorDep * numeroDependentes;
		salario += salarioFam;
		salarioLiq = super.calculaSalario(aliquotaIR);
	}
	
	public String toString(){
		return ("Nome: " + nome +"\nCodigo: " + codEmpregado + "\nSalario base: " + salario + "\nSalario liquido: " + salarioLiq + "\nDependentes: " + numDeps);
	
	}

}
