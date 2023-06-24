package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FindingUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        int USER_ID =2;
        //gets the user with id =2 from user table
        User user = session.load(User.class, USER_ID);
        System.out.println("FullName: "+user.getFullname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("password: " + user.getPassword());

        //Close resources
        transaction.commit();
        factory.close();
        session.close();
    }
}
