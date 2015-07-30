package controlador.gestionTutoria;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import controlador.autenticar.Autenticar;
import modelo.entidades.Tutoria;
import modelo.jpa.JPADAOFactory;

@ManagedBean(name="listarSolicitudesBean")
@SessionScoped
public class ListarSolicitudes {
	
	@ManagedProperty(value = "#{autenticarBean}")
	private Autenticar  usuario;
	private Tutoria tutoria;
	private List<Tutoria> tutorias=new ArrayList<Tutoria>();
	
	public Autenticar getUsuario() {
		return usuario;
	}
	public void setUsuario(Autenticar usuario) {
		this.usuario = usuario;
	}
	public Tutoria getTutoria() {
		return tutoria;
	}
	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}
	public List<Tutoria> getTutorias() {
		obtenerListaTutorias();
		return tutorias;
	}
	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}
	
	public void obtenerListaTutorias(){
		System.out.println(usuario.getProfesorBean().getId());
		setTutorias(JPADAOFactory.getFactory().getTutoriaDAO().getTutoriasByProfesor(usuario.getProfesorBean().getId()));
		
	}
	
	public ListarSolicitudes(){
		super();
		usuario=new Autenticar();
	}
	
	@PostConstruct
	public void init() {
		
		getTutorias();
		
	}

}
