package Model;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Bean.SocioBean;

public class SocioModel {
	
	public static  EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("Proy_Pandero");

	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> obtenerPermisos(Map<String, Object> map)throws Exception {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select a from AccesosBean a , RolBean r  where r.idRol = :rol", Map.class);
		q.setParameter("rol", map.get("rol"));
		List<Map<String, Object>> salida = q.getResultList();		
		em.close();
		return salida;
	}
	 
	@SuppressWarnings("unchecked")
	public List<SocioBean> validarSocio(Map<String, Object>map)throws Exception {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT s FROM SocioBean s where s.usuario = :usuario and s.clave = :clave");
		q.setParameter("usuario", map.get("usuario"));
		q.setParameter("clave", map.get("clave"));    
		List<SocioBean> lista = q.getResultList();
		em.close();
		return lista;
	}
	 
	public void insertaSocio(SocioBean s){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(s);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public List<SocioBean> consultaSocioXDni(int dni) {
		EntityManager manager = emf.createEntityManager();
		TypedQuery<SocioBean> q = null;
		 
		if(dni == -1){
			q = manager.createQuery("select s from SocioBean s",SocioBean.class);
			return q.getResultList();
		}
		 else{
			q = manager.createQuery("select s from SocioBean s where " +
					"s.dni LIKE :param1",SocioBean.class);
			q.setParameter("param1", dni); 
			return q.getResultList();	
		}
				
	}
	
	public void elimina(SocioBean p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			SocioBean aux = manager.find(SocioBean.class, p.getIdSocio());
			manager.getTransaction().begin();
			manager.remove(aux);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	
	public void actualiza(SocioBean p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(p);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public List<SocioBean> listaSocio(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<SocioBean> q = manager.createQuery("select p from SocioBean p", SocioBean.class);
		return q.getResultList();
	}
	
	public List<SocioBean> listaSocio2(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<SocioBean> q = manager.createQuery("select p.idSocio,p.nombres from SocioBean p", SocioBean.class);
		return q.getResultList();
	}
}
