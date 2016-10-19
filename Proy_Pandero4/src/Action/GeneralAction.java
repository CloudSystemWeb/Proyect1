package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class GeneralAction {

	public String salir() {
		return "/ui/principal.jsf";
	}

	public String principal () {
		return "/ui/principal.jsf";
	}
	
}
