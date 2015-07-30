package modelo.dao;

import java.util.List;


import modelo.entidades.Departamento;


public interface DepartamentoDAO extends GenericDAO<Departamento, Integer> {

	public Departamento getDepartamentoByCodigo(String codigo);
	public Departamento getDepartamentoByNombre(String nombre);
	public List<Departamento> getDepartamentoByNombreProfesor(String letraInicio);
	

}