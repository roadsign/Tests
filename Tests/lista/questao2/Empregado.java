// Aluno:		Victor Emmanuel Pires Pereira Mota Campos
// Matricula:	201220428211
// Turma:		Linguagen de Programacao 2 - 2013.2

package questao2;

public class Empregado {
	
	protected String nome;
	protected String codEmpregado;
	protected double salario;
	protected double salarioLiq;
	
	public Empregado (String name, String cod, double sal){
		nome = name;
		codEmpregado = cod;
		salario = sal;
		salarioLiq = sal;
	}
	
	public double calculaSalario (double desconto){
		return (salario - salario*desconto);
	}
	
	public String getCodigo(){
		return codEmpregado;
	}
	
	public String toString(){
		return ("Nome: " + nome + ", codigo:" + codEmpregado + ", Salario base:" + salario);
	}	

}
