package controlador.gestionTutoria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import controlador.autenticar.Autenticar;
import modelo.entidades.Profesor;
import modelo.entidades.Tutoria;
import modelo.jpa.JPADAOFactory;

@ManagedBean(name="solicitarTutoriaBean")
@SessionScoped
public class SolicitarTutoria {

	private Tutoria tutoria;
	private Profesor profesor;
	private List<Profesor> profesores = new ArrayList<Profesor>();
	private Date horaIni;
	private Date horaFin;
	@ManagedProperty(value = "#{autenticarBean}")
	private Autenticar  usuario;
	
	
	//CONSTRUCTOR
	public SolicitarTutoria(){

	}
	
	//GETTERS Y SETTERS
	
	public Tutoria getTutoria() {
		if(this.tutoria==null){
			return this.tutoria=new Tutoria();
		}
		return tutoria;
	}

	public Autenticar getUsuario() {
		return usuario;
	}

	public void setUsuario(Autenticar usuario) {
		this.usuario = usuario;
	}

	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public List<Profesor> getProfesores() {
		obtenerProfesores();
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor getProfesor() {
		if(this.profesor==null){
			return this.profesor=new Profesor();
		}
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	//ACCIONES
	public void obtenerProfesores(){
		setProfesores(JPADAOFactory.getFactory().getProfesorDAO().find());
	}
	
	public String solicitar(){
		System.out.println("Entró a guardar");
		System.out.println(usuario.getEstudianteBean().getUsername());
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");	 
		tutoria.setEstudiante(usuario.getEstudianteBean());
		tutoria.setProfesor(this.profesor);
		tutoria.setHoraInicio(format.format(horaIni));
		tutoria.setHoraFin(format.format(horaFin));
		JPADAOFactory.getFactory().getTutoriaDAO().create(this.tutoria);
		limpiarVariables();
		return "GestionTutoria/solicitarTutoria";
	}
	
	public String cancelar(){
		System.out.println("Entró a cancelar");
		limpiarVariables();
		return "GestionTutoria/solicitarTutoria";
	}
	
	//FUNCIONES
	public void limpiarVariables(){
		setHoraFin(null);
		setHoraIni(null);
		setTutoria(null);
	}
}
