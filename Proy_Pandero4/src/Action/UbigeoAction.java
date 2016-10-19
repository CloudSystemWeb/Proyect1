package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import Bean.UbigeoBean;
 
@RequestScoped
@ManagedBean
public class UbigeoAction {

	private UbigeoBean ubigeo;

	public UbigeoAction() {
		ubigeo = new UbigeoBean();
	}

	public UbigeoBean getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(UbigeoBean ubigeo) {
		this.ubigeo = ubigeo;
	}
	
	  
}
