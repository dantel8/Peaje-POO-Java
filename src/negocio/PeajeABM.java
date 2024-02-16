package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PeajeDao;
import datos.Abonado;
import datos.Manual;
import datos.Rodado;
import datos.TelePeaje;

public class PeajeABM {
	PeajeDao dao = new PeajeDao();
	
	public List<Manual> traerManual(){
		return dao.traerManual();
	}
	
	public List<TelePeaje> traerTelePeaje(){
		return dao.traerTelePeaje();
	}
	
	public List<Manual> traerManual(LocalDate fecha){
		return dao.traerManual(fecha);
	}
	
	public double cerrarCaja(LocalDate fecha) {
		return dao.cerrarCaja(fecha);
	}
	
	public List<TelePeaje> traerTelePeaje(Rodado r){
		return dao.traerTelePeaje(r);
	}
	
	public List<TelePeaje> traerTelePeaje(Abonado abonado){
		return dao.traerTelePeaje(abonado);
	}
}
