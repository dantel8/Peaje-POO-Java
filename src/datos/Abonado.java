package datos;

public class Abonado {
	private int id;
	private String apellido;
	private String nombre;
	private long dni;

	public Abonado() {

	}

	public Abonado(String apellido, String nombre, long dni) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Abonado [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

}
