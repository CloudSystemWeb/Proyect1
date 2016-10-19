package Action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Bean.TipoObligacion;

@RequestScoped
@ManagedBean
public class TipoObligacionAction {

	private TipoObligacion tipoObligacion;
	
	public TipoObligacionAction() {
		tipoObligacion = new TipoObligacion();
	}

	public TipoObligacion getTipoObligacion() {
		return tipoObligacion;
	}

	public void setTipoObligacion(TipoObligacion tipoObligacion) {
		this.tipoObligacion = tipoObligacion;
	}
	
	
}
