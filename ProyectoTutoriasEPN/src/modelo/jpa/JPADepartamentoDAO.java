package modelo.jpa;


import java.util.List;

import javax.persistence.Query;

import modelo.dao.DepartamentoDAO;
import modelo.entidades.Departamento;


public class JPADepartamentoDAO extends JPAGenericDAO<Departamento, Integer>
		implements DepartamentoDAO {

	public JPADepartamentoDAO() {
		super(Departamento.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Departamento getDepartamentoByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento getDepartamentoByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> getDepartamentoByNombreProfesor(String letraInicio) {
		// TODO Auto-generated method stub
		return null;
	}

}
