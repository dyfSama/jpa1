package com.dyf;

import javax.persistence.*;

@Entity
@Table(name = "jpa_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_name")
    private String name;

    //多对一 属性加载策略
   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;*/

    public Order() {
    }

 /*   public Order(String name, Person person) {
        this.name = name;
        this.person = person;
    }*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
