package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Rodado;

public class RodadoDao {
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

	public Rodado traerRodado(String dominio) {
		Rodado r = null;
		try {
			iniciaOperacion();
			r = (Rodado) session.createQuery("from Rodado r where r.dominio= '" + dominio + "'").uniqueResult();
			Hibernate.initialize(r.getAbonado());
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return r;
	}
	
	public Abonado traerAbonado(long dni) {
		Abonado a = null;
		try {
			iniciaOperacion();
			a = (Abonado)session.createQuery("from Abonado a where a.dni= " + dni).uniqueResult();
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		
		return a;
	}
}
