package Bean;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletContext;

@Entity
@Table(name="Socios")
public class SocioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSocio;
	private String nombres;
	private String apellidos;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="idSexo")
	private SexoBean sexo;
	
	private String dni;
	
	@ManyToOne
	@JoinColumn(name="idEstadoCivil")
	private EstCivilBean estadoCivil; 
	
	private String conyuge;
	
	@ManyToOne
	@JoinColumn(name="idRol")
	private RolBean rol; 
	
//	@ManyToOne
//	@JoinColumn(name="idUbigeo")
//	private UbigeoBean ubigeo;
	
	
	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private DepartamentoBean departamento;

	@ManyToOne
	@JoinColumn(name = "idProvincia")
	private ProvinciaBean provincia;

	@ManyToOne
	@JoinColumn(name = "idDistrito")
	private DistritoBean distrito;
	
	
	private String direccion;
	private String telefono;
	private String email;
	private String usuario;
	private String clave;

	@Column(length = 100000)
	private byte[] foto;
	
	@Column(length = 100000)
	private byte[] firma;

	private String fotoPortadda;
	private String firmas;
  
	public SocioBean(){
		estadoCivil = new EstCivilBean();
		rol = new RolBean();
		sexo = new SexoBean();
		//ubigeo = new UbigeoBean();
		departamento = new DepartamentoBean();
		provincia = new ProvinciaBean();
		distrito = new DistritoBean();
	}
	 
	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public RolBean getRol() {
		return rol;
	}

	public void setRol(RolBean rol) {
		this.rol = rol;
	}

	public EstCivilBean getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstCivilBean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public SexoBean getSexo() {
		return sexo;
	}

	public void setSexo(SexoBean sexo) {
		this.sexo = sexo;
	}

	public DepartamentoBean getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoBean departamento) {
		this.departamento = departamento;
	}

	public ProvinciaBean getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaBean provincia) {
		this.provincia = provincia;
	}

	public DistritoBean getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoBean distrito) {
		this.distrito = distrito;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	 

	public String getConyuge() {
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	 

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

	public String getFotoPortadda() {
		
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String realPath = (String) servletContext.getRealPath("/");

		try {
			String rutaFile = realPath + "\\" + idSocio + ".jpg";
			fotoPortadda = idSocio + ".jpg";
			System.out.println("FotoPortadda -> " + rutaFile);

			FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
			fileOuputStream.write(foto);
			fileOuputStream.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return fotoPortadda;
	}

	public void setFotoPortadda(String fotoPortadda) {
		this.fotoPortadda = fotoPortadda;
	}

	public String getFirmas() {
		
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String realPath = (String) servletContext.getRealPath("/");

		try {
			String rutaFile = realPath + "\\" + idSocio + ".jpg";
			firmas = idSocio + ".jpg";
			System.out.println("firmas -> " + rutaFile);

			FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
			fileOuputStream.write(firma);
			fileOuputStream.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return firmas;
	}

	public void setFirmas(String firmas) {
		this.firmas = firmas;
	}
	
	
	
	

}
