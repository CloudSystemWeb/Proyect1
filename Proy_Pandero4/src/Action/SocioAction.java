package Action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import Model.SocioModel;

import org.apache.commons.codec.binary.Base64;
import org.primefaces.component.api.UIData;
import org.primefaces.model.UploadedFile;

import Bean.SocioBean;


@ManagedBean
public class SocioAction {
	private SocioBean socio;
	
	private int dni;
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	//Este atributo es propio del primefaces
	private String fotoEn64;
	private String firmaEn64;
	
	private UploadedFile fotoPortada; //UploadedFile es de primefaces
	private UploadedFile firmas; //UploadedFile es de primefaces
	
	private UIData dttSocio;
	private List<SocioBean> listaSocio;
	private List<SocioBean> listaSocio2;
	
	public void setListaSocio2(List<SocioBean> listaSocio2) {
		this.listaSocio2 = listaSocio2;
	}

	public SocioAction() {
		socio = new SocioBean();
	}
	
	public String registraSocio() {
		SocioModel model = new SocioModel();
		
		//Se envian los bytes del archivo a la base de datos
		
		System.out.println("Antes de Cortar: " + fotoEn64);
		System.out.println("Antes de Cortar: " + firmaEn64);
		
		fotoEn64 = fotoEn64.substring(fotoEn64.indexOf(',')+1, fotoEn64.length()-1);
		firmaEn64 = firmaEn64.substring(firmaEn64.indexOf(',')+1, firmaEn64.length()-1);
		
		System.out.println("Despues de Cortar: " + fotoEn64);
		System.out.println("Despues de Cortar: " + firmaEn64);
		
		//De base 64 a binario
		byte[] bytes = new Base64().decode(fotoEn64);
		byte[] bytes2 = new Base64().decode(firmaEn64);
		
		socio.setFoto(bytes);
		socio.setFirma(bytes2);
	
		
		model.insertaSocio(socio);
		return "/ui/listaSocio.jsf";
	}

	public String consultaSocio(){
		SocioModel model = new SocioModel();
		listaSocio = model.consultaSocioXDni(dni);
		return "/ui/consultaSocio.jsf";
	}
	
	
	
	
	public String eliminaSocio() {
		socio = (SocioBean) dttSocio.getRowData();

		SocioModel model = new SocioModel();
		model.elimina(socio);
		return "/ui/listaSocio.jsf";
	}

	

	public List<SocioBean> getListaSocio() {
		SocioModel model = new SocioModel();
		listaSocio = model.listaSocio();
		
		return listaSocio;
	}
	
	public List<SocioBean> getListaSocio2(){
		SocioModel model = new SocioModel();
		listaSocio2 = model.listaSocio2();
		return listaSocio2;
	}
	
	public SocioBean getSocio() {
		return socio;
	}

	public void setSocio(SocioBean socio) {
		this.socio = socio;
	}

	public UploadedFile getFotoPortada() {
		return fotoPortada;
	}

	public void setFotoPortada(UploadedFile fotoPortada) {
		this.fotoPortada = fotoPortada;
	}

	public UIData getDttSocio() {
		return dttSocio;
	}

	public void setDttSocio(UIData dttSocio) {
		this.dttSocio = dttSocio;
	}

	public void setListaSocio(List<SocioBean> listaSocio) {
		this.listaSocio = listaSocio;
	}

	public String getFotoEn64() {
		return fotoEn64;
	}

	public void setFotoEn64(String fotoEn64) {
		this.fotoEn64 = fotoEn64;
	}

	public String getFirmaEn64() {
		return firmaEn64;
	}

	public void setFirmaEn64(String firmaEn64) {
		this.firmaEn64 = firmaEn64;
	}

	public UploadedFile getFirmas() {
		return firmas;
	}

	public void setFirmas(UploadedFile firmas) {
		this.firmas = firmas;
	}

	
	

}