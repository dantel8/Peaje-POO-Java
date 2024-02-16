package datos;

import java.time.LocalDate;
import java.time.LocalTime;

import funciones.Funciones;

public class TelePeaje extends Peaje {
	private Rodado rodado;
	private String lector;

	public TelePeaje() {

	}

	public TelePeaje(LocalDate fecha, LocalTime hora, double precio, Rodado rodado, String lector) {
		super(fecha, hora, precio);
		this.rodado = rodado;
		this.lector = lector;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	public String getLector() {
		return lector;
	}

	public void setLector(String lector) {
		this.lector = lector;
	}

	@Override
	public String toString() {
		return "TelePeaje" + super.toString() + "[rodado=" + rodado + ", lector=" + lector + "]";
	}

	public double calcularDescuento(double porcentajeDescuento) {
		double precio = 0;
		if (!Funciones.esDiaHabil(super.fecha)
				|| (super.hora.isBefore(LocalTime.of(7, 0)) || super.hora.isAfter(LocalTime.of(19, 0)))) {
			precio = precio - (porcentajeDescuento * precio / 100);
		}
		return precio;
	}

}
