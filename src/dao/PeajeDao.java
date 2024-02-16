package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Manual;
import datos.Rodado;
import datos.TelePeaje;

public class PeajeDao {
	public static Session session;
	public Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	@SuppressWarnings("unchecked")
	public List<Manual> traerManual() {
		List<Manual> lstManual = null;
		try {
			iniciaOperacion();
			lstManual = session.createQuery("from Manual").list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return lstManual;
	}

	@SuppressWarnings("unchecked")
	public List<TelePeaje> traerTelePeaje() throws HibernateException {
		List<TelePeaje> lstTelePeaje = null;
		try {
			iniciaOperacion();
			lstTelePeaje = session.createQuery("from TelePeaje t inner join fetch t.rodado r inner join fetch r.abonado a").list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return lstTelePeaje;
	}

	@SuppressWarnings("unchecked")
	public List<Manual> traerManual(LocalDate fecha) {
		List<Manual> lstManual = null;
		try {
			iniciaOperacion();
			lstManual = session.createQuery("from Manual m where m.fecha= '" + fecha + "'").list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return lstManual;
	}

	public double cerrarCaja(LocalDate fecha) {
		double caja = 0;
		List<Manual> lstAux = traerManual(fecha);
		try {
			iniciaOperacion();
			for (int i = 0; i < lstAux.size(); i++) {
				caja = caja + lstAux.get(i).getPrecio();
			}
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return caja;
	}

	@SuppressWarnings("unchecked")
	public List<TelePeaje> traerTelePeaje(Rodado r) {
		List<TelePeaje> lstTelePeaje = null;
		try {
			iniciaOperacion();
			lstTelePeaje = session.createQuery(
					"from TelePeaje p inner join fecth p.rodado r inner join fetch r.abonado a where r.idRodado= "
							+ r.getId())
					.list();
		} finally {
			// TODO: handle finally clause
		}
		return lstTelePeaje;
	}

	@SuppressWarnings("unchecked")
	public List<TelePeaje> traerTelePeaje(Abonado abonado) {
		List<TelePeaje> lstTelePeaje = null;
		try {
			iniciaOperacion();
			lstTelePeaje = session.createQuery(
					"from TelePeaje t inner join fetch t.rodado r inner join fetch r.abonado a where a.id= "
							+ abonado.getId())
					.list();
		} finally {
			// TODO: handle finally clause
			session.close();
		}

		return lstTelePeaje;
	}

}
