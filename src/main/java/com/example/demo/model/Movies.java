package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "movies")
public class Movies {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

    @Column(name = "title")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Letters allowed")
    private String title;

    @Column(name = "author")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Letters allowed")
    private String author;

    @Column(name = "rating")
    @Pattern(regexp = "^-?\\d+$", message = "Only numbers allowed")
    private String rating;


    @Column(name = "genres")
    private String genres;



    public Movies() {
    }

    public Movies(String title, String author, String rating, String genres) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.genres = genres;
    }



    public Movies(int id, String title, String author, String rating, String genres){
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
