package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatingUser {
    public static void main(String[] args) {
        /*SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setId(3);
        user.setEmail("mhaseeb@perscholas");
        user.setFullname("M haseeb");
        user.setPassword("123456");

        session.merge(user);
        session.getTransaction().commit();
        session.close();*/
        String s = "A,b,c";
        String ss = s.substring(0,0);
        System.out.println(ss);


    }
}
