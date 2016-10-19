package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.RolBean;

public class RolModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<RolBean> listaRol(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<RolBean> q = manager.createQuery("select r from RolBean r", RolBean.class);
		return q.getResultList();
	}
	
	
}
