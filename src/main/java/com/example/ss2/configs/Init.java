package com.example.ss2.configs;

import com.example.ss2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
@Transactional
public class Init {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public Init(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @PostConstruct
    @Transactional
    public void postConstruct() {
        User users = new User();
        users.setUsername("user");
        users.setPassword("pass");
        users.setName("Vasya");
        users.setLastname("Ivanov");
        users.setEmail("user@user.com");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(users);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
