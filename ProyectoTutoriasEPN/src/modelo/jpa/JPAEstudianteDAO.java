package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.EstudianteDAO;
import modelo.entidades.Estudiante;
import modelo.entidades.Profesor;
import modelo.entidades.Usuario;

public class JPAEstudianteDAO extends JPAGenericDAO<Estudiante, Integer>
implements EstudianteDAO {

	public JPAEstudianteDAO() {
		super(Estudiante.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Estudiante getEstudianteByUsername(String username) {
		// TODO Auto-generated method stub
				Query query = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.username= :username");
				query.setParameter("username", username);
				Estudiante estudiante = (Estudiante) query.getSingleResult();
				return estudiante;
		
	}

	

		

	


	
}
