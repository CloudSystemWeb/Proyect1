package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Bean.SexoBean;
 

@RequestScoped
@ManagedBean
public class SexoAction {

	private SexoBean sexo;

	public SexoAction() {
		sexo = new SexoBean();
	}

	public SexoBean getSexo() {
		return sexo;
	}

	public void setSexo(SexoBean sexo) {
		this.sexo = sexo;
	}
 

}
