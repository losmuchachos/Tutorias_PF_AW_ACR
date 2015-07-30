package modelo.dao;


import java.util.List;

import modelo.entidades.Estudiante;
import modelo.entidades.Tutoria;

public interface EstudianteDAO extends GenericDAO<Estudiante, Integer> {

	
	public Estudiante getEstudianteByUsername(String username);
	
	
}
