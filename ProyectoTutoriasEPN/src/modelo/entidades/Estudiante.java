package modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "numMatricula_est")
	private String numeroMatricula;
	@Column(name = "numUnico_est")
	private String numeroUnico;
	@OneToMany(mappedBy = "estudiante")
	List<Tutoria> tutorias;

	public Estudiante() {

	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNumeroUnico() {
		return numeroUnico;
	}

	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}

	public List<Tutoria> getTutorias() {
		return tutorias;
	}

	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
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
		return super.getNombre() + super.getApellido();
		// TODO Auto-generated method stub

	}

}
