package com.dyf;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPATest  {


    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    @Test
    public void testMandytoOne(){

    }


    @Test
    public void  testManyToOneUpdate(){
        Order order = entityManager.find(Order.class, 2);
       /* order.getPerson().setName("一打");*/
    }

    @Test
    public void testManyToOneRemoe(){
        Order order = entityManager.find(Order.class,1);
        entityManager.remove(order);

        Person person = entityManager.find(Person.class,1);
        entityManager.remove(person);//外键约束删不掉
    }

    @Test
    public void testManyToOneFind(){
        Order order = entityManager.find(Order.class,1);
        System.out.println(order);
    }

    /**
     * 保存多对一时.建议先保存1的一段,后保存n的一段,这样不会的多出额外的update语句
     */
    @Test
    public void testManyToOnePersist(){
        Person p = new Person();
        p.setAge(123);
        p.setBirth(new Date());
        p.setName("诸葛小亮");
        p.setCreateTime(new Date());


      /*  Order order1 = new Order("o4",p);
        Order order2 = new Order("o6",p);

        entityManager.persist(order1);
        entityManager.persist(order2);
        entityManager.persist(p);
*/
    }





    @Test
    public void  testMerge1(){
        Person p = new Person();
        p.setAge(123);
        p.setBirth(new Date());
        p.setName("sdfsdf");
        p.setCreateTime(new Date());

        Person p2 = entityManager.merge(p);

        System.out.println(p.getId());//null
        System.out.println(p2.getId());//有值

    }




    //delete
    //改方法只能移除持久化对象,但hibernate的delete还可以移除游离对象
    @Test
    public void testRemove(){
        //游离对象
        Person p = new Person();
        p.setId(2);
        //持久化对象
        Person p2 = entityManager.find(Person.class,2);


        entityManager.remove(p2);
    }



    //类似hibernate的save方法
    //不同之处,jpa: 若对象有id,则不能执行insert操作,跑出异常
    @Test
    public void testPersistence(){
        Person p = new Person();
        p.setAge(123);
        p.setBirth(new Date());
        p.setCreateTime(new Date());
        p.setName("dskfk ");

//        p.setId(12);
        entityManager.persist(p);
        System.out.println(p.getId());
    }




    //类似于hibernate中session的load方法
    @Test
    public void testgetReference(){
        Person p1 = entityManager.getReference(Person.class,3);
        System.out.println(p1.getClass().getName());
        System.out.println("---------------------------");

        System.out.println(p1);
    }


    //类似于hibernate中session的get方法
    @Test
    public void testFind(){
        Person p1 = entityManager.find(Person.class,3);

        System.out.println("---------------------------");

        System.out.println(p1);
    }




    @After
    public void destory(){
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}