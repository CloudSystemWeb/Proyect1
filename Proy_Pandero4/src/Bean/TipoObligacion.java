package Bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tipoobligacion")
public class TipoObligacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoObligacion;
	
	private String Descripcion;

	public int getIdTipoObligacion() {
		return idTipoObligacion;
	}

	public void setIdTipoObligacion(int idTipoObligacion) {
		this.idTipoObligacion = idTipoObligacion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
