package Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Bean.SocioBean;
import Model.SocioModel;
 

@RequestScoped
@ManagedBean
public class LoginAction {
	private String usuario, clave;
	

	//Permite obtener un Map de los objetos en sesion
	private Map<String, Object> mapSession =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	public String salir(){
		
		//limpiamos los objetos de sesion
		mapSession.clear();
		
		//mensajes del primefaces
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Se salió de sesión"));
		
		return "/ui/login";
	}
 
	
	public String verificarUsuario(){
		Map<String,	Object> maps = new HashMap<String,	Object>();
		maps.put("usuario", usuario);
		maps.put("clave", clave);
		
		SocioModel model = new SocioModel();
		try {
			List<SocioBean> socioU = model.validarSocio(maps);
			if(socioU != null && socioU.size()>0){
				mapSession.put("USUARIO_LOGEADO", socioU.get(0));
				
				maps.put("idRol", socioU.get(0).getRol());
				List<Map<String, Object>> listaPermisos = 
						model.obtenerPermisos(maps);
				
				mapSession.put("USUARIO_ACCESO", listaPermisos);
				return "/ui/principal";
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuario incorrecto"));
				return "/ui/login";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/ui/login";
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
}
