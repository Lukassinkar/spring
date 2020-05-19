package com.example.demo.model;

import java.util.List;

public interface MoviesDAO {
    void insertEntity(Movies movies);
    Movies findEntityByID(int id);
    List<Movies> findEntities();
    void updateEntity(Movies movies);
    void removeEntityByID(int id);
}
