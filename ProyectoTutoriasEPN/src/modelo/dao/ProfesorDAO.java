package modelo.dao;

import java.util.List;

import modelo.entidades.Profesor;

public interface ProfesorDAO extends GenericDAO<Profesor, Integer> {

	public Profesor getProfesorByUsername(String username);
	
}
