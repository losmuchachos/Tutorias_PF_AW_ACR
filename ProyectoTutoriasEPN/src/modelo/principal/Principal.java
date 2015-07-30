package modelo.principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidades.Departamento;
import modelo.entidades.Estudiante;
import modelo.entidades.Profesor;
import modelo.entidades.Tutoria;
import modelo.entidades.Usuario;
import modelo.jpa.JPADAOFactory;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Crear el EntityManagerFactory
		EntityManagerFactory emf;
		//Crear el EntityManager
		EntityManager em;

		emf= Persistence.createEntityManagerFactory("ProyectoTutoriasEPN");
		em=emf.createEntityManager();
		//Creamos Un Departamento
		Departamento dep=new Departamento();
		dep.setNombre("Ingenieria de Software");
		dep.setFacultad("Facultad de Sistemas");
		dep.setCodigo("FIS001");
		System.out.println(dep.getNombre());
		//Insertamos el Departamento
		em.getTransaction().begin();
		em.persist(dep);
		em.getTransaction().commit();

		//Creamos Un Profesor
		Profesor prof=new Profesor();
		prof.setNombre("Carlos");
		prof.setApellido("Iñiquez");
		prof.setCedula("0123456789");
		prof.setClave("12345");
		prof.setDepartamento(dep);
		prof.setTitular(true);
		prof.setUsername("carlos");
		prof.setCodigo("01");
		//creamos estudiante
		Estudiante use= new Estudiante();
		use.setApellido("Aldas");
		use.setNombre("Wally");
		use.setCedula("1234567890");
		use.setClave("jojoj");
		use.setUsername("Wally");
		use.setNumeroMatricula("123456");
		use.setNumeroUnico("2873645342");
		//Insertamos el Departamento y el profesor
		em.getTransaction().begin();
		em.persist(dep);
		em.persist(prof);
		em.persist(use);
		em.getTransaction().commit();
		List<Tutoria> tutorias = new ArrayList<Tutoria>();
		tutorias=JPADAOFactory.getFactory().getTutoriaDAO().find();
		for(Tutoria i: tutorias){
			System.out.println("ID" + i.getId() +"\n");
		}
	}

}
