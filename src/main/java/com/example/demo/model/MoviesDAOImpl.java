package com.example.demo.model;

import com.example.demo.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MoviesDAOImpl implements MoviesDAO {
    public void insertEntity(Movies movies) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(movies);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Movies findEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Movies> movies = entityManager.
                createQuery("Select n FROM Movies n WHERE n.id = :id")
                .setParameter("id", id)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return movies.get(0);
    }

    public List<Movies> findEntities() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Movies> movies = entityManager.createQuery("SELECT n FROM Movies n")
                .getResultList();

        return movies;
    }

    public void updateEntity(Movies movies) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Movies movies2 = entityManager.find(Movies.class, movies.getId());
        movies2.setTitle(movies.getTitle());
        movies2.setAuthor(movies.getAuthor());
        movies2.setRating(movies.getRating());
        movies2.setGenres(movies.getGenres());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Movies movies = entityManager.find(Movies.class, id);
        entityManager.remove(movies);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    

}
