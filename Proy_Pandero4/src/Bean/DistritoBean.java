package Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
@SessionScoped
public class DistritoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idDistrito;
	private String nomDistrito;
	
	@OneToMany(mappedBy="distrito")
	private List<SocioBean> socios;
	
	
	public DistritoBean(){
		
	}


	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
 
	public String getNomDistrito() {
		return nomDistrito;
	}
 
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}


	public List<SocioBean> getSocios() {
		return socios;
	}


	public void setSocios(List<SocioBean> socios) {
		this.socios = socios;
	}
	
	
	public SocioBean addSocio(SocioBean socio){
		getSocios().add(socio);
		socio.setDistrito(this);
		return socio;
	}
	
	public SocioBean removeSocio(SocioBean socio){
		getSocios().remove(socios);
		socio.setDistrito(null);
		return socio;
	}
	
	
	
}
