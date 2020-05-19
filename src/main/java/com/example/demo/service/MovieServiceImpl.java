package com.example.demo.service;

import com.example.demo.model.Movies;
import com.example.demo.model.MoviesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    @Autowired
    @Qualifier("NumberDAO")
    private MoviesDAO moviesDAO;

    @Override
    public List <Movies> getAll() {
        return moviesDAO.findEntities();
    }

    @Override
    public void save(Movies movies) {
        moviesDAO.insertEntity(movies);
    }

    @Override
    public Movies getById(int id) {
        return moviesDAO.findEntityByID(id);
    }

    @Override
    public void update(Movies movies) {
        moviesDAO.updateEntity(movies);
    }

    @Override
    public void delete(int id) {
        moviesDAO.removeEntityByID(id);
    }

}
