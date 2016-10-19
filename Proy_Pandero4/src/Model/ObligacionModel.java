package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.ObligacionBean;

public class ObligacionModel {

	public static  EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public void registraObligacion(ObligacionBean s){
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
	
	public List<ObligacionBean> consultaObligacionXSocio(int idSocio) {
		EntityManager manager = emf.createEntityManager();
		TypedQuery<ObligacionBean> q = null;
		 
		if(idSocio == -1){
			q = manager.createQuery("select s from ObligacionBean s",ObligacionBean.class);
		}
		 else{
			q = manager.createQuery("select s from ObligacionBean s where " +
					"s.socio.idSocio = :param1",ObligacionBean.class);
			q.setParameter("param1", idSocio); 	
		}
		return q.getResultList();
	}
	
	
	public void modificarObligacion(ObligacionBean p){
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
	
	public void eliminarObligacion(ObligacionBean p){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			ObligacionBean aux = manager.find(ObligacionBean.class,	p.getIdpago());
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
	
	public List<ObligacionBean> listaObligacion(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<ObligacionBean> q = manager.createQuery("select p from ObligacionBean p",ObligacionBean.class);
		return q.getResultList();
	}
}
