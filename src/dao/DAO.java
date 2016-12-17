package dao;

import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import negocio.*;

public class DAO {
	private static DAO instancia = null;
	private static SessionFactory sf = null;

	public static DAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new DAO();
		} 
		return instancia;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<String> getLocalidadbyCP(int cp){
		Session session = sf.openSession();
		List<String> list = session.createQuery("	select	localidad.nombre "
													+ "	from Localidad localidad "
													+ "	join localidad.cp cp "
													+ "	where cp.cod_postal = ?")
				.setInteger(0, cp)
				.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getParajebyCP(int cp){
		Session session = sf.openSession();
		List<String> list = session.createQuery("	select	paraje.nombre "
													+ "	from Localidad localidad "
													+ "	join localidad.cp cp "
													+ "	join localidad.paraje paraje"
													+ "	where cp.cod_postal = ?")
				.setInteger(0, cp)
				.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCallebyCP(int cp){
		Session session = sf.openSession();
		List<String> list = session.createQuery("	select	DISTINCT calle.nombre "
													+ "	from Altura altura "
													+ " join altura.cp cp"
													+ "	join altura.calle calle "
													+ "	where cp.cod_postal = ?")
				.setInteger(0, cp)
				.list();
		session.close();
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCPA(int cp, String calle,int altura){
		Session session = sf.openSession();
		List<Object[]> list = session.createQuery("	select	DISTINCT calle.nombre, cpa.cpa "
													+ "	from Altura altura "
													+ " join altura.cp cp "
													+ " join altura.cpa cpa "
													+ "	join altura.calle calle "
													+ "	where cp.cod_postal = ? "
													+ " and calle.nombre like ? "
													+ " and altura.desde <= ? "
													+ "	and altura.hasta >= ? ")
				.setInteger(0, cp)
				.setString(1, "%"+calle+"%")
				.setInteger(2, altura)
				.setInteger(3, altura)
				.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCPAGui(int cp, String calle,int altura){
		Session session = sf.openSession();
		List<Object[]> list = session.createQuery("	select	DISTINCT provincia.nombre, paraje.nombre, localidad.nombre, calle.barrio, calle.nombre, altura.desde, altura.hasta, cp.cod_postal, cpa.cpa "
													+ "	from Altura altura "
													+ " join altura.calle calle "
													+ " join calle.localidad localidad "
													+ " join localidad.paraje paraje "
													+ " join paraje.provincia provincia "
													+ " join altura.cp cp "
													+ " join altura.cpa cpa "
													+ "	join altura.calle calle "
													+ "	where cp.cod_postal like ? "
													+ " and calle.nombre like ? "
													+ " and altura.desde <= ? "
													+ "	and altura.hasta >= ? ")
				
				.setString(0, "%"+String.valueOf(cp)+"%")
				.setString(1, "%"+calle+"%")
				.setInteger(2, altura)
				.setInteger(3, altura)
				.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCPAGuiBarrio(String barrio){
		Session session = sf.openSession();
		List<Object[]> list = session.createQuery("	select	DISTINCT provincia.nombre, paraje.nombre, localidad.nombre, calle.barrio, calle.nombre, altura.desde, altura.hasta, cp.cod_postal, cpa.cpa "
													+ "	from Altura altura "
													+ " join altura.calle calle "
													+ " join calle.localidad localidad "
													+ " join localidad.paraje paraje "
													+ " join paraje.provincia provincia "
													+ " join altura.cp cp "
													+ " join altura.cpa cpa "
													+ "	join altura.calle calle "
													+ "	where calle.barrio like ? ")
				
				.setString(0, "%"+barrio+"%")
				.list();
		session.close();
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCPAGui2(int cp, String calle,int altura){
		Session session = sf.openSession();
		List<Object[]> list = session.createQuery("	select	DISTINCT calle.nombre, altura.desde, altura.hasta, cpa.cpa "
													+ "	from Altura altura "
													+ " join altura.cp cp "
													+ " join altura.cpa cpa "
													+ "	join altura.calle calle "
													+ "	where cp.cod_postal like ? "
													+ " and calle.nombre like ? "
													+ " and altura.desde <= ? "
													+ "	and altura.hasta >= ? ")
				
				.setString(0, "%"+String.valueOf(cp)+"%")
				.setString(1, "%"+calle+"%")
				.setInteger(2, altura)
				.setInteger(3, altura)
				.list();
		session.close();
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getCPAsinAltura(int cp, String calle){
		Session session = sf.openSession();
		List<Object[]> list = session.createQuery("	select	DISTINCT calle.nombre, cpa.cpa "
													+ "	from Altura altura "
													+ " join altura.cp cp "
													+ " join altura.cpa cpa "
													+ "	join altura.calle calle "
													+ "	where cp.cod_postal = ? "
													+ " and calle.nombre like ? "
													+ " and altura.desde = 0 "
													+ "	and altura.hasta = 0 ")
				.setInteger(0, cp)
				.setString(1, "%"+calle+"%")
				.list();
		session.close();
		return list;
	}
	
	public List<Object[]> getCPAbyCP(int cp){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Object[]> list = session.createQuery("	select cpa.cpa, localidad.nombre"
													+ "	from Localidad localidad "
													+ " join localidad.cp cp "
													+ " join localidad.cpa cpa "
													+ "	where cp.cod_postal = ? ")
				.setInteger(0, cp)
				.list();
		session.close();
		return list;
	}
	

	
		
	@SuppressWarnings("unchecked")
	public List<Provincia> getProvincia(){
		Session session = sf.openSession();
		List<Provincia> provincias = session.createQuery("from Provincia ")
				.list();
		session.close();
		return provincias;
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	public List<String> getParajeByProvincia(String provincia){
		Session session = sf.openSession();
		List<String> lista = session.createQuery("	Select paraje.nombre "
												+ "	from Paraje paraje join paraje.provincia provincia "
												+ "	where provincia.nombre = ?")
				.setString(0, provincia)
				.list();
		session.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getLocalidadesByParaje(String paraje){
		Session session = sf.openSession();
		List<String> lista = session.createQuery("	Select localidad.nombre "
												+ "	from Localidad localidad join localidad.paraje paraje "
												+ "	where paraje.nombre like ?")
				.setString(0, paraje)
				.list();
		session.close();
		return lista;
	}


	
	
	
}
