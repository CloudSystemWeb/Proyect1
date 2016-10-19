package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
 

import Bean.AccesosBean;

public class AccesosModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<AccesosBean> listaAccesos(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<AccesosBean> q = manager.createQuery("select a from AccesosBean a", AccesosBean.class);
		return q.getResultList();
	}
	 
	 
}
