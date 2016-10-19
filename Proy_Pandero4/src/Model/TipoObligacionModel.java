package Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Bean.TipoObligacion;

public class TipoObligacionModel {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proy_Pandero");

	public List<TipoObligacion> listaTipoObligacion(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<TipoObligacion> q = manager.createQuery("select t from TipoObligacion t", TipoObligacion.class);
		
		return q.getResultList();
	}
	
}
