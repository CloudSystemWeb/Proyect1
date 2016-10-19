package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
 
import Bean.DistritoBean;

public class DistritoModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");
	
	public List<DistritoBean> listaDistrito(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<DistritoBean> q = manager.createQuery("select d from DistritoBean d", DistritoBean.class);
		return q.getResultList();
	}
	
	
	public List<DistritoBean> ListaDistritoxProvincia(int id_Provincia){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<DistritoBean> q = null;
		
		if(id_Provincia==-1){
			q = manager.createQuery("select d from DistritoBean d", DistritoBean.class);
		}else{
			q =manager.createQuery("Select d from DistritoBean d where d.provincia.Id_Provincia=:param1",DistritoBean.class);
			q.setParameter("param1", id_Provincia);
		}
		
		return q.getResultList();
	}
	 
}
