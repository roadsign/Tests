package introspection;

public class FilmeBean {
	private String id;
	private String titulo;
	private String anoDeLancamento;

	public FilmeBean() {
		// tem que ter um construtor vazio
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(String anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

}
