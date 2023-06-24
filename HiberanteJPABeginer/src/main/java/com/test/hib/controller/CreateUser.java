package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        User user1 = new User();
        user1.setEmail("haseeb@gmail.com");
        user1.setFullname("Moh Haseeb");
        user1.setPassword("has123");
        user1.setSalary(2000.69);
        user1.setAge(20);
        user1.setCity("NYC");

        User uTwo = new User();
        uTwo.setEmail("James@gmail.com");
        uTwo.setFullname("James Santana");
        uTwo.setPassword("James123");
        uTwo.setSalary(2060.69);
        uTwo.setAge(25);
        uTwo.setCity("Dallas");

        User uThree = new User();
        uThree.setEmail("Shahparan@gmail.com");
        uThree.setFullname("AH Shahparan");
        uThree.setPassword("Shahparan123");
        uThree.setSalary(3060.69);
        uThree.setAge(30);
        uThree.setCity("Chicago");

        /*========= We can pass value/data into by using constructor =========*/
        User userFour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3, "NJ");
        User userfive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
        //Integer  userid = null;

        session.persist(user1);
        session.persist(uTwo);
        session.persist(uThree);
        session.persist(userFour);
        session.persist(userfive);

        transaction.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
