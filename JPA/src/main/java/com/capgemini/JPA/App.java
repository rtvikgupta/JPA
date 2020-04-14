package com.capgemini.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
      	EntityManager em = emf.createEntityManager();
      	
      	// Create
        Student s = new Student();
        s.setSid(3);
        s.setSname("Ramesh");
        s.setMarks(80);
      	em.getTransaction().begin();
      	em.persist(s);
      	em.getTransaction().commit();
      	System.out.println(s);
      	
      	//get data
      	Student s1 = em.find(Student.class, 1);
      	System.out.println(s1);
      	
      	//update
      	em.getTransaction().begin();
      	Student s2 = em.find(Student.class, 1);
      	System.out.println(s2);
      	s2.setSname("RTVIK");
      	em.getTransaction().commit();
      	
      	//delete
      	em.getTransaction().begin();
      	Student s3 = em.find(Student.class, 3);
      	System.out.println(s3);
      	em.remove(s3);
      	em.getTransaction().commit();
    }
}
