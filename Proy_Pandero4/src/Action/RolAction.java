package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Bean.RolBean; 


@RequestScoped
@ManagedBean
public class RolAction {

	private RolBean rols;

	public RolAction() {
		rols = new RolBean();
	}

	public RolBean getRols() {
		return rols;
	}

	public void setRols(RolBean rols) {
		this.rols = rols;
	}

	 

}
