package modelo.jpa;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuarioByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT u FROM Usuario u WHERE u.username= :username");
		query.setParameter("username", username);
		Usuario user = (Usuario) query.getSingleResult();
		return user;
	}

}
