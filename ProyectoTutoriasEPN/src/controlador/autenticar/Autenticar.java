package controlador.autenticar;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.entidades.Estudiante;
import modelo.entidades.Profesor;
import modelo.entidades.Usuario;
import modelo.jpa.JPADAOFactory;

@ManagedBean(name="autenticarBean")
@SessionScoped
public class Autenticar {

	//Usuario
	private Usuario usuario;
	private Estudiante estudiante;
	private Profesor profesor;
	private Estudiante estudianteBean;
	private Profesor profesorBean;
	


	//variables para comprobación.
	private String username;
	private String password;

	//CONSTRUCTOR
	public Autenticar(){
		
		super();
		
		
	}

	//GETTERS Y SETTERS
	
	public Usuario getUsuario() {
		if(this.usuario==null){
			return this.usuario=new Usuario();
		}
		return usuario;
	}

	public Estudiante getEstudianteBean() {
		if(this.estudianteBean==null){
			return this.estudianteBean=new Estudiante();
		}
		return estudianteBean;
	}

	public void setEstudianteBean(Estudiante estudianteBean) {
		this.estudianteBean = estudianteBean;
	}

	public Profesor getProfesorBean() {
		if(this.profesorBean==null){
			return this.profesorBean=new Profesor();
		}
		return profesorBean;
	}

	public void setProfesorBean(Profesor profesorBean) {
		this.profesorBean = profesorBean;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Estudiante getEstudiante() {
		if(this.estudiante==null){
			return this.estudiante=new Estudiante();
		}

		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//ACCIONES
	public String autenticar(){
		System.out.println("Entró a autenticar");

		//Buscamos usuario y lo guardamos en usuario
		try{
			setUsuario(JPADAOFactory.getFactory().getUsuarioDAO().getUsuarioByUsername(username));
		}
		catch(Exception e)
		{
			return "index.xhtml";
		}

		//Verificar si es profesor o estudiante
		try
		{
			setProfesor(JPADAOFactory.getFactory().getProfesorDAO().getProfesorByUsername(username));
		}
		catch (Exception e)
		{
			System.out.println("es estudiante");
			if (getProfesor().getId()==null)
			{
				try
				{
					setEstudiante(JPADAOFactory.getFactory().getEstudianteDAO().getEstudianteByUsername(username));
				}
				catch(Exception e1){
					return "index.xhtml";
				}
			}

		}

		if(this.usuario.equals(new Usuario())){
			System.out.println("no existe usuario");
			return "index.xhtml";
		}else if(this.usuario.getUsername().equals(username) && this.usuario.getClave().equals(password)){

			if(getEstudiante().getId()==null)
			{
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoTutoriasEPN/GestionTutoria/listarSolicitudes.xhtml");
					setProfesorBean(profesor);
					System.out.println(profesorBean.getId());
					profesor=new Profesor();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else
			{
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoTutoriasEPN/menu/menuEstudiante.xhtml");
					estudianteBean= estudiante;
					System.out.println(estudianteBean.getId());
					estudiante=new Estudiante();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.println("Clave válida");

			return null;
		}else
		{
			System.out.println("Clave inválida");
			return "index.xhtml";
		}
	}
	//	public String autenticar(String username, String clave){
	//		System.out.println("Entró a autenticar");
	//		System.out.println("Username: " + username);
	//		setUsuario(JPADAOFactory.getFactory().getUsuarioDAO().getUsuarioByUsername(username));
	//		if(this.usuario.equals(new Usuario())){
	//			System.out.println("no existe usuario");
	//			return "index.xhtml";
	//		}else{
	//			if(this.usuario.getClave().equals(clave)){
	//				return "GestionTutoria/solicitarTutoria";
	//			}
	//			System.out.println("Clave inválida");
	//			return "index.xhtml";
	//		}
	//	}
}
