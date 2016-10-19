package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.SexoBean;

public class SexoModel {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");

	
	public List<SexoBean> listaSexo(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<SexoBean> q = manager.createQuery("select s from SexoBean s", SexoBean.class);
		
		return q.getResultList();
	}
	
	
}
