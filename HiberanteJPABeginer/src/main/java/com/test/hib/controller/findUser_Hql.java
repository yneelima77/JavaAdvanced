package com.test.hib.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.test.hib.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.From;
import java.util.List;

public class findUser_Hql {
    public void findUser() {
        SessionFactory Factory = new Configuration().configure().buildSessionFactory();
        Session session = Factory.openSession();

        String hql = "From User"; //Example of HQL to get all records of user class
        TypedQuery query = session.createQuery(hql);
        List<User> list = query.getResultList();
        for (User u : list) {
            System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() +
                    "|" + "Email: " + u.getEmail() + "|" + "password" + u.getPassword());
        }
    }

    public void findUserSelect() {
        SessionFactory Factory = new Configuration().configure().buildSessionFactory();
        Session session = Factory.openSession();

        /* ------------  Example of HQL to get all the records------- */
        String hql = "Select u From User u";
        Query query = session.createQuery(hql);
        List<User> list = query.getResultList();

        for (User u : list) {
            System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() +
                    "|" + "Email: " + u.getEmail() + "|" + "password" + u.getPassword());
        }
    }

    public void getRecordbyId() {
        SessionFactory Factory = new Configuration().configure().buildSessionFactory();
        Session session = Factory.openSession();

        /* ------------  Example of HQL to get the records using where and group by clause------- */
        String hql = "From User e where e.id > 2 order by e.salary desc";
        TypedQuery query = session.createQuery(hql);
        List<User> results = query.getResultList();
        for (User u : results) {
            System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() +
                    "|" + "Email: " + u.getEmail() + "|" + "password" + u.getPassword());
        }
    }

    public void getrecords() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery<Object[]> queryy = session.createQuery("Select u.salary, u.fullname from User u", Object[].class);
        List<Object[]> resultss = queryy.getResultList();
        for (Object[] a : resultss) {
            System.out.println("Salary: " + a[0] + ", City: " + a[1]);
        }
    }

    public void getmaxSalary() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery query = session.createQuery("SELECT MAX(u.salary) FROM User u");
        double result = (double) query.getSingleResult();
        System.out.println(result);
    }

    public void getcountofUsers() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery query = session.createQuery("SELECT COUNT(*) FROM User u");
        List result = query.getResultList();
        System.out.println(result);
    }

    public void getmaxSalaryGroupBy() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery query = session.createQuery("SELECT MAX(u.salary), u.city FROM User u GROUP BY u.city");
        List<Object[]> result = query.getResultList();
        for (Object[] o : result) {
            System.out.println("Total salary " + o[0] + " | city: " + o[1]);
        }
    }

    public void NamedQueryExample() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery query = session.createQuery("FROM User u where u.id = :id ");
        query.setParameter("id", 2);
        List<User> result = query.getResultList();
        for (User u : result) {
            System.out.println("User Id: " + u.getId() + "|" + " Full name:" + u.getFullname() +
                    "|" + "Email: " + u.getEmail() + "|" + "password" + u.getPassword());

        }

    }
}