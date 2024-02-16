package negocio;

import dao.RodadoDao;
import datos.Abonado;
import datos.Rodado;

public class RodadoABM {
	RodadoDao dao = new RodadoDao();
	
	public Rodado traerRodado(String dominio) {
		return dao.traerRodado(dominio);
	}
	
	public Abonado traerAbonado(long dni) {
		return dao.traerAbonado(dni);
	}
}
