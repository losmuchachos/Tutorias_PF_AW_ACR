package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.TutoriaDAO;
import modelo.entidades.Profesor;
import modelo.entidades.Tutoria;

public class JPATutoriaDAO extends JPAGenericDAO<Tutoria, Integer> implements TutoriaDAO{

	public JPATutoriaDAO() {
		super(Tutoria.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Tutoria> getTutoriasByProfesor(Integer idProfesor) {
		
		Query query = this.em.createNamedQuery("Tutoria.findByProfesor");
		query.setParameter("idPro", idProfesor);
		@SuppressWarnings("unchecked")
		List <Tutoria> tutorias= query.getResultList();
        return tutorias;
	}
	
	

}
