package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.DepartamentoBean;

public class DepartamentoModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<DepartamentoBean> listaDepartamento(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<DepartamentoBean> q = manager.createQuery("select d from DepartamentoBean d", DepartamentoBean.class);
		return q.getResultList();
	}

}
