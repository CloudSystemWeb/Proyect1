package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
 
import Bean.ProvinciaBean;

public class ProvinciaModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<ProvinciaBean> listaProvincia(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<ProvinciaBean> q = manager.createQuery("select p from ProvinciaBean p", ProvinciaBean.class);
		return q.getResultList();
	}
	
	
	public List<ProvinciaBean> ListaProvinciaxDepartamento(int id_Departamento){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<ProvinciaBean> q = null;
		
		if(id_Departamento==-1){
			q = manager.createQuery("select p from ProvinciaBean p", ProvinciaBean.class);
		}else{
			q =manager.createQuery("Select p from ProvinciaBean p where p.departamento.id_Departamento=:param1",ProvinciaBean.class);
			q.setParameter("param1", id_Departamento);
		}
		
		return q.getResultList();
	}
	 
	
	
	
	
	
}
