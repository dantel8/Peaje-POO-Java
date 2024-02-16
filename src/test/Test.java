package test;

import java.time.LocalDate;
import java.util.List;

import dao.RodadoDao;
import datos.Abonado;
import datos.TelePeaje;
import negocio.AbonadoABM;
import negocio.PeajeABM;
import negocio.RodadoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeajeABM peajeABM = new PeajeABM();
		RodadoABM rodadoABM = new RodadoABM();
		AbonadoABM abonadoABM = new AbonadoABM();

		System.out.println("1)");
		System.out.println(peajeABM.traerManual());
		System.out.println("2)");
		System.out.println(peajeABM.traerTelePeaje());
		System.out.println("3)");
		System.out.println(peajeABM.traerTelePeaje());
		System.out.println("4)");
		System.out.println(peajeABM.traerManual(LocalDate.of(2020, 11, 1)));
		System.out.println("5)");
		System.out.println(rodadoABM.traerRodado("AAA111"));
		System.out.println("6)");
		List<TelePeaje> lstTelePeaje = peajeABM.traerTelePeaje(rodadoABM.traerAbonado(11111111));
		System.out.println(lstTelePeaje.toString());
		for (int i = 0; i < lstTelePeaje.size(); i++) {
			System.out.println(lstTelePeaje.get(i).calcularDescuento(50));
		}
		System.out.println("7)");
		System.out.println(rodadoABM.traerAbonado(11111111));
		System.out.println("8)");
		System.out.println(peajeABM.traerTelePeaje(abonadoABM.traerAbonado(11111111)));
	}

}
