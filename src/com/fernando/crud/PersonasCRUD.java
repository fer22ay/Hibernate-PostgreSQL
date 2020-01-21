package com.fernando.crud;

import com.fernando.entidades.Personas;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase CRUD de la tabla Persona para realizar las operaciones de agregar,
 * eliminar, modificar y seleccionar de la tabla Persona.
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
public class PersonasCRUD implements Serializable{

    private static final long serialVersionUID = 4853307154095463840L;
    
    /***
     * Metodo para seleccionar un registro de la tabla Persona
     * @param pk tipo Integer
     * @return toString de la clase Personas: id, nombre, apellido y fecha.
     */
    public static Personas selectToPerson(Integer pk) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        Personas personas = em.find(Personas.class, pk);
        System.out.println(personas);
        em.close();
        factory.close();
        return personas;
    }

    /***
     * Metodo para insertar en la tabla Persona
     * @param name tipo String
     * @param lastName tipo String
     * @param date tipo Date
     */
    public void addToPerson(String name, String lastName, Date date) throws NoSuchAlgorithmException{
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        Personas personas = new Personas();
        personas.setNombrePersona(name);
        personas.setApellidoPersona(lastName);
        personas.setFechaIngreso(date);
        em.getTransaction().begin();
        em.persist(personas);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /***
     * Metodo para actualizar Persona
     * @param pk id de la persona
     * @param name nombre de la persona
     * @param lastName apellido de la persona
     * @param date fecha de ingreso de la persona
     */
    public void updateToPerson(Integer pk, String name, String lastName, Date date) throws NoSuchAlgorithmException{
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        Personas personas = em.find(Personas.class, pk);
        if (personas != null) {
            personas.setNombrePersona(name);
            personas.setApellidoPersona(lastName);
            personas.setFechaIngreso(date);
            em.getTransaction().begin();
            em.merge(personas);
            em.getTransaction().commit();
        }
        em.close();
        factory.close();
        
    }
    
    /***
     * Metodo para eliminar Persona de la base de datos
     * @param pkg identificador de la persona
     */
    public void deleteToPerson(Integer pkg){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        Personas personas = em.find(Personas.class, pkg);
        if (personas != null) {
            em.getTransaction().begin();
            em.remove(personas);
            em.getTransaction().commit();
        }
        em.close();
        factory.close();
    }
    
    /***
     * Metodo para seleccionar todos los registros de la 
     * tabla Persona
     * @return Lista de personas
     */
    public static List<Personas> selectAll(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Personas> criteriaQuery = criteriaBuilder.createQuery(Personas.class);
        Root<Personas> root = criteriaQuery.from(Personas.class);
        criteriaQuery = criteriaQuery.select(root);
        Query query = em.createQuery(criteriaQuery);
        List<Personas> list = query.getResultList();
        em.close();
        factory.close();
        return list;
    }
    
    
}
