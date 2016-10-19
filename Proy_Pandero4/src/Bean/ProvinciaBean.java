package Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
@SessionScoped
public class ProvinciaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idProvincia;
	private String nomProvincia;
	
	
	@OneToMany(mappedBy="provincia")
	private List<SocioBean> socios;
	
	public ProvinciaBean(){
		
	}

  
 
	public int getIdProvincia() {
		return idProvincia;
	}



	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

  
	public String getNomProvincia() {
		return nomProvincia;
	}
 
	public void setNomProvincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}



	public List<SocioBean> getSocios() {
		return socios;
	}

	public void setSocios(List<SocioBean> socios) {
		this.socios = socios;
	}

	public SocioBean addSocio(SocioBean socio){
		getSocios().add(socio);
		socio.setProvincia(this);
		return socio;
	}
	
	public SocioBean removeSocio(SocioBean socio){
		getSocios().remove(socios);
		socio.setProvincia(null);
		return socio;
	}
}
