package modelo.entidades;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "esTitular_pro")
	private Boolean titular;
	@Column(name = "codigo_pro")
	private String codigo;
	@Column(name= "oficinaTutoria_pro")
	private String oficinaTutoria;
	@OneToMany(mappedBy = "profesor")
	List<Tutoria> tutorias;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dep")
	private Departamento departamento;
	
	
	public Profesor() {

	}

	public Boolean getTitular() {
		return titular;
	}

	public void setTitular(Boolean titular) {
		this.titular = titular;
	}

	public List<Tutoria> getTutorias() {
		return tutorias;
	}

	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOficinaTutoria() {
		return oficinaTutoria;
	}

	public void setOficinaTutoria(String oficinaTutoria) {
		this.oficinaTutoria = oficinaTutoria;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getNombre() + " " + super.getApellido();
	}

}
