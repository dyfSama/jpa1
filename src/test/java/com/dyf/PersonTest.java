package com.dyf;

import junit.framework.TestCase;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class PersonTest extends TestCase {


    @Test
    public void testPerson(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new Person("杜亚飞",10, new Date(), new Date()));

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}