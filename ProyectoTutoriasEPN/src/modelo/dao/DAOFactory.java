package modelo.dao;


import modelo.jpa.JPADAOFactory;


public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract EstudianteDAO getEstudianteDAO();
    public abstract ProfesorDAO getProfesorDAO();
    public abstract TutoriaDAO getTutoriaDAO();
    public abstract AdministradorDAO getdAdministradorDAO();
    public abstract DepartamentoDAO getDepartamentoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    


}