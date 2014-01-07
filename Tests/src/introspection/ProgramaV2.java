package introspection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//getDeclaredMethods: os metodos publicos da classe
//getMethods: os metodos publicos da classe + os metodos herdados da classe pai
public class ProgramaV2 {

	public static void chamaMetodo(Object o, String nomeDoMetodo, String valor) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?>[] tiposDosArgumentos = { String.class };
		Object[] listaDeArgumentos = { valor };

		Method m = o.getClass().getMethod(nomeDoMetodo, tiposDosArgumentos);
		m.invoke(o, listaDeArgumentos);

	}

	public static void main(String[] args) {
		Object o;

		try {
			o = novaClasse("introspection.FilmeBean");
			System.out.println(o.getClass().getName());

			chamaMetodo(o, "setId", "1");
			chamaMetodo(o, "setTitulo", "Toy story");
			chamaMetodo(o, "setAnoDeLancamento", "1997");

			FilmeBean bean = (FilmeBean) o;
			System.out.println(bean.getId());
			System.out.println(bean.getTitulo());
			System.out.println(bean.getAnoDeLancamento());

			imprimeMetodos(o);

		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void imprimeMetodos(Object o) {
		for (Method m : o.getClass().getMethods()) {
			System.out.println(m.getName());
		}
	}

	public static Object novaClasse(String nomeDaClasse) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		return Class.forName(nomeDaClasse).newInstance();
	}

}
