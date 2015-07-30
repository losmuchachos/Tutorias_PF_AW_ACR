package modelo.dao;

import java.util.List;

import modelo.entidades.Tutoria;

public interface TutoriaDAO extends GenericDAO<Tutoria, Integer>{
	
	public List<Tutoria> getTutoriasByProfesor(Integer idProfesor);
	
	
	

}
