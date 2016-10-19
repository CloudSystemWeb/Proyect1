package Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departamento")
@SessionScoped
public class DepartamentoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idDepartamento;
	private String nomDepartamento;
	
	@OneToMany(mappedBy="departamento")
	private List<SocioBean> socios;
	
	public DepartamentoBean(){
		
	}
  
	 


	public int getIdDepartamento() {
		return idDepartamento;
	}




	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
  
	public String getNomDepartamento() {
		return nomDepartamento;
	} 
	
	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}
 
	public List<SocioBean> getSocios() {
		return socios;
	}

	public void setSocios(List<SocioBean> socios) {
		this.socios = socios;
	}
	
	public SocioBean addSocio(SocioBean socio){
		getSocios().add(socio);
		socio.setDepartamento(this);
		return socio;
	}
	
	public SocioBean removeSocio(SocioBean socio){
		getSocios().remove(socios);
		socio.setDepartamento(null);
		return socio;
	}
}
