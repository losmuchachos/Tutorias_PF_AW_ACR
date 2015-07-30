package modelo.dao;

import java.util.List;

import modelo.entidades.Administrador;


public interface AdministradorDAO extends GenericDAO<Administrador, Integer> {

	public Administrador getAdministradorBycodigo(String codigo);

}