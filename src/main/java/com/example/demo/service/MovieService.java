package com.example.demo.service;

import com.example.demo.model.Movies;

import java.util.List;

public interface MovieService {
    List<Movies> getAll();
    void save (Movies movies);
    Movies getById(int id);
    void update (Movies movies);
    void delete(int id);
}
