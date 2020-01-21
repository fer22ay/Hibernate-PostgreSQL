package com.fernando.crud;

import com.fernando.entidades.Personas;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
//import java.text.ParseException;
//import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pruebas {

    public static void main(String[] args) throws NoSuchAlgorithmException {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
//        EntityManager em = factory.createEntityManager();
//        Personas personas = em.find(Personas.class, 7);
//        System.out.println(personas);
//        em.close();
//        factory.close();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
        EntityManager em = factory.createEntityManager();
        Personas personas = new Personas();
        personas.setNombrePersona("FERNANDO");
        personas.setApellidoPersona("AMBROSIO");
        personas.setFechaIngreso(new Date());
        em.getTransaction().begin();
        em.persist(personas);
        em.getTransaction().commit();
        em.close();
        factory.close();


//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
//        EntityManager em = factory.createEntityManager();
//        Personas personas = em.find(Personas.class, 1);
//        if (personas != null) {
//            personas.setNombrePersona("OSCAR");
//            personas.setApellidoPersona("GRAMAJO");
//            personas.setFechaIngreso(new Date());
//            em.getTransaction().begin();
//            em.merge(personas);
//            em.getTransaction().commit();
//        }
//        em.close();
//        factory.close();



//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_APPPU");
//        EntityManager em = factory.createEntityManager();
//        Personas personas = em.find(Personas.class, 8);
//        if (personas != null) {
//            em.getTransaction().begin();
//            em.remove(personas);
//            em.getTransaction().commit();
//        }
//        em.close();
//        factory.close();
//        List<Personas> list = PersonasCRUD.selectAll();
//        for (int i = 0; list.size() < 10; i++) {
//            System.out.println(list.get(i));
//        }
        /**
         * *
         * Metodo forEach anterior
         */
//  List<Personas> list = PersonasCRUD.selectAll();
//        for (Personas personas : list) {
//            System.out.println(personas);
//        }
        /**
         * *
         * Metodo forEach mejorado
         */
//        List<Personas> list = PersonasCRUD.selectAll();
//        list.forEach((personas) -> {
//            System.out.println(personas);
//        });
    }

}
