package Action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;


import Bean.ObligacionBean;
import Model.ObligacionModel;

@ManagedBean
public class ObligacionAction {

	private ObligacionBean obligacion;
	private int socio;
	

	public int getSocio() {
		return socio;
	}

	public void setSocio(int socio) {
		this.socio = socio;
	}


	private List<ObligacionBean> listaObligacion;
	
	private UIData dttObligaciones;
	
	public UIData getDttObligaciones() {
		return dttObligaciones;
	}

	public void setDttObligaciones(UIData dttObligaciones) {
		this.dttObligaciones = dttObligaciones;
	}

	public ObligacionBean getObligacion() {
		
		return obligacion;
	}

	public void setObligacion(ObligacionBean obligacion) {
		this.obligacion = obligacion;
	}

	public List<ObligacionBean> getListaObligacion() {
		ObligacionModel model = new ObligacionModel();
		listaObligacion = model.listaObligacion();
		return listaObligacion;
	}

	public String consultaObligacion(){
		ObligacionModel model = new ObligacionModel();
		listaObligacion = model.consultaObligacionXSocio(socio);
		return "/ui/consultaPago.jsf";
	}
	
	public void setListaObligacion(List<ObligacionBean> listaObligacion) {
		this.listaObligacion = listaObligacion;
	}

	public ObligacionAction(){
		obligacion = new ObligacionBean();
	}
	
	public String registraObligacion(){
		ObligacionModel model = new ObligacionModel();
		model.registraObligacion(obligacion);
		return "/ui/listaObligacion.jsf";
	}
	
	public String modificarObligacion(){
		ObligacionModel model = new ObligacionModel();
		model.modificarObligacion(obligacion);
		return "/ui/listaObligacion.jsf";
	}
	
	public String buscaObligacion(){
		//getRowData(); --> Obtiene el objeto seleccionado
		obligacion = (ObligacionBean) dttObligaciones.getRowData();
		return "/ui/modificarPago.jsf";
	}
	
}
