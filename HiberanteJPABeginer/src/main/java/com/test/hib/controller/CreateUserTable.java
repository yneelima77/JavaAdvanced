package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.UnknownServiceException;

public class CreateUserTable {
    public static void main(String[] args) {
        SessionFactory factory =  new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        User user1 = new User();
        transaction.commit();
        System.out.println("successfully created user table");
        factory.close();
        session.close();
    }
}
