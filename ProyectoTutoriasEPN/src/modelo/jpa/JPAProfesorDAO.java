package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.EstudianteDAO;
import modelo.dao.ProfesorDAO;
import modelo.entidades.Estudiante;
import modelo.entidades.Profesor;
import modelo.entidades.Usuario;

public class JPAProfesorDAO extends JPAGenericDAO<Profesor, Integer> implements
		ProfesorDAO {

	public JPAProfesorDAO() {
		// TODO Auto-generated constructor stub
		super(Profesor.class);
	}
@Override
	public Profesor getProfesorByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.username= :username");
		query.setParameter("username", username);
		Profesor profesor = (Profesor) query.getSingleResult();
		return profesor;
	}
	

	

}
