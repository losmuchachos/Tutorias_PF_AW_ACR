package modelo.jpa;


import javax.persistence.Query;

import modelo.dao.AdministradorDAO;
import modelo.entidades.Administrador;


public class JPAAdministradorDAO extends JPAGenericDAO<Administrador, Integer>
		implements AdministradorDAO {

	public JPAAdministradorDAO() {
		super(Administrador.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Administrador getAdministradorBycodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
