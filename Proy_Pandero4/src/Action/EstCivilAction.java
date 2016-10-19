package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Bean.EstCivilBean;
 

@RequestScoped
@ManagedBean
public class EstCivilAction {

	private EstCivilBean estCivil;

	public EstCivilAction() {
		estCivil = new EstCivilBean();
	}

	public EstCivilBean getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(EstCivilBean estCivil) {
		this.estCivil = estCivil;
	}

	  

}
