package com.dyf;


import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "jpa_person")
public class Person {

    /**
     * 可以加在 field上 ,也可以加在getter
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;

    //@Column(name = "s_name")
    private String name;

   // @Column(name = "i_age")
    private Integer age;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Person() {
    }

    public Person(String name, Integer age, Date birth, Date createTime) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.createTime = createTime;
    }



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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", createTime=" + createTime +
                '}';
    }
}
