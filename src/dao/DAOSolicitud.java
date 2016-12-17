package dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.*;

public class DAOSolicitud {
	private static DAOSolicitud instancia = null;
	private static SessionFactory sf = null;

	public static DAOSolicitud getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new DAOSolicitud();
		} 
		return instancia;
	}

	
	public Solicitud getSolicitud(int idSolicitud){
		Session session = sf.openSession();
		Solicitud aux = (Solicitud) session.get(Solicitud.class, idSolicitud);
		return aux;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> getSolicitudes(){
		Session session = sf.openSession();
		List<Solicitud> solicitudes = session.createQuery("from Solicitud ")
				.list();
		session.close();
		return solicitudes;
	}

	
	public void guardarSolicitud(Solicitud solicitud){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(solicitud);
		session.getTransaction().commit();
		session.close();
	}
	
	
}
