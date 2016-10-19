package Bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pago_obligacion")
public class ObligacionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpago;
	
	@ManyToOne
	@JoinColumn(name="idSocio")
	private SocioBean socio; 
	
	private String descripcion;
	
	private Double monto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaemision;
	
	@ManyToOne
	@JoinColumn(name="idTipoObligacion")
	private TipoObligacion tipoobligacion;

	public TipoObligacion getTipoobligacion() {
		return tipoobligacion;
	}

	public void setTipoobligacion(TipoObligacion tipoobligacion) {
		this.tipoobligacion = tipoobligacion;
	}

	@Temporal(TemporalType.DATE)
	private Date fechavencimiento;
	
	public ObligacionBean(){
		socio = new SocioBean();
		tipoobligacion = new TipoObligacion();
	}

	public int getIdpago() {
		return idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public SocioBean getSocio() {
		return socio;
	}

	public void setSocio(SocioBean socio) {
		this.socio = socio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(Date fechaemision) {
		this.fechaemision = fechaemision;
	}


	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	
	
}
