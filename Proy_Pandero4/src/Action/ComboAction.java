package Action;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
  











import Bean.DepartamentoBean;
import Bean.DistritoBean;
import Bean.EstCivilBean;
import Bean.ProvinciaBean;
import Bean.RolBean;
import Bean.SexoBean;
import Bean.SocioBean;
import Bean.TipoObligacion;
import Bean.UbigeoBean;
import Model.DepartamentoModel;
import Model.DistritoModel;
import Model.EstCivilModel;
import Model.ProvinciaModel;
import Model.RolModel;
import Model.SexoModel;
import Model.SocioModel;
import Model.TipoObligacionModel;
import Model.UbigeoModel;


@SessionScoped
@ManagedBean
public class ComboAction {

	private List<SexoBean> sex ;
	private List<EstCivilBean> estCivil;
	private List<DepartamentoBean> departamentos;
	private List<ProvinciaBean> provincias;
	private List<DistritoBean> distritos;
	private List<RolBean> roles;
	private List<SocioBean> socio;
	private List<TipoObligacion> tipoobligacion;
	
	public List<TipoObligacion> getTipoobligacion() {
		TipoObligacionModel model = new TipoObligacionModel();
		tipoobligacion = model.listaTipoObligacion();
		return tipoobligacion;
	}

	public void setTipoobligacion(List<TipoObligacion> tipoobligacion) {
		this.tipoobligacion = tipoobligacion;
	}

	
	 
	public List<SocioBean> getSocio() {
		SocioModel model = new SocioModel();
		socio = model.listaSocio();
		return socio;
	}

	public void setSocio(List<SocioBean> socio) {
		this.socio = socio;
	}


	public List<SexoBean> getSex() {
		SexoModel model = new SexoModel();
 		sex = model.listaSexo();
 		return sex;
	}
	public void setSex(List<SexoBean> sex) {
		this.sex = sex;
	}
	
	public List<EstCivilBean> getEstCivil() {
		EstCivilModel model = new EstCivilModel();
 		estCivil = model.listaEstadoCivil();
		return estCivil;
	}
	public List<DepartamentoBean> getDepartamentos() {
		DepartamentoModel model = new DepartamentoModel();
		departamentos = model.listaDepartamento();
		return departamentos;
	}
	public void setDepartamentos(List<DepartamentoBean> departamentos) {
		this.departamentos = departamentos;
	}
	public List<ProvinciaBean> getProvincias() {
		ProvinciaModel  model = new ProvinciaModel();
		provincias = model.listaProvincia();
		return provincias;
	}
	public void setProvincias(List<ProvinciaBean> provincias) {
		this.provincias = provincias;
	}
	public List<DistritoBean> getDistritos() {
		DistritoModel model = new DistritoModel();
		distritos = model.listaDistrito();
		return distritos;
	}
	public void setDistritos(List<DistritoBean> distritos) {
		this.distritos = distritos;
	}
	public void setEstCivil(List<EstCivilBean> estCivil) {
		this.estCivil = estCivil;
	}
	
 
	
	public List<RolBean> getRoles() {
		RolModel model = new RolModel();
 		roles = model.listaRol();
		return roles;
	}
	public void setRoles(List<RolBean> roles) {
		this.roles = roles;
	}
 
}
