package Bean;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accesos")
@SessionScoped
public class AccesosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAcceso;
	
	@ManyToOne
	@JoinColumn(name="idRol")
	private RolBean rol;
	
	@ManyToOne
	@JoinColumn(name="idMenu")
	private MenuBean menu;

	public AccesosBean(){
		rol = new RolBean();
		menu = new MenuBean();
	}

	public int getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(int idAcceso) {
		this.idAcceso = idAcceso;
	}

	public RolBean getRol() {
		return rol;
	}

	public void setRol(RolBean rol) {
		this.rol = rol;
	}

	public MenuBean getMenu() {
		return menu;
	}

	public void setMenu(MenuBean menu) {
		this.menu = menu;
	}

	  
	
}
