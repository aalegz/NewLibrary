package com.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBook {
    public static void main(String[] args) {
        Book book =
                new Book("Voina i mir", "About Russia1", "Tolstoi",
                        "1254", 1860, false);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("library");

        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

            //em.persist(book);

        Book book1 = em.find(Book.class, 3);

        //System.out.println(book1.getDescription());

        book1.setAuthor("Sanya");

        transaction.commit();

        em.close();

        factory.close();


    }
}
