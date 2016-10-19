package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.UbigeoBean;

public class UbigeoModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<UbigeoBean> listaUbigeo(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<UbigeoBean> q = manager.createQuery("Select u from UbigeoBean u", UbigeoBean.class);
		
		return q.getResultList();
	}
	
	
	public List<UbigeoBean> listaUbigeoProvin(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<UbigeoBean> q = manager.createQuery("Select u from UbigeoBean u", UbigeoBean.class);
		
		return q.getResultList();
	}
	
	
	public List<UbigeoBean> listaUbigeoDistri(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<UbigeoBean> q = manager.createQuery("Select u from UbigeoBean u", UbigeoBean.class);
		
		return q.getResultList();
	}
	
	
 
	
}
