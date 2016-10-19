package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.EstCivilBean;

public class EstCivilModel {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<EstCivilBean> listaEstadoCivil(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<EstCivilBean> q = manager.createQuery("select ec from EstCivilBean ec", EstCivilBean.class);
		
		return q.getResultList();
	}
	
}
