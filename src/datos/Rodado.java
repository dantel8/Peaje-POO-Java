package datos;

public class Rodado {
	private int id;
	private String dominio;
	private int categoria;
	private Abonado abonado;

	public Rodado() {

	}

	public Rodado(String dominio, int categoria, Abonado abonado) {
		this.dominio = dominio;
		this.categoria = categoria;
		this.abonado = abonado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Abonado getAbonado() {
		return abonado;
	}

	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}

	@Override
	public String toString() {
		return "Rodado [id=" + id + ", dominio=" + dominio + ", categoria=" + categoria + ", abonado=" + abonado + "]";
	}

}
