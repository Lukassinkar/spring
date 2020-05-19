package com.example.demo.validator;

import com.example.demo.model.Movies;
import com.example.demo.model.User;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class FormValidator implements Validator {
    private static final Pattern TITLE_REGEX =
            Pattern.compile("^[a-zA-Z]$");
    private static final Pattern AUTHOR_REGEX =
            Pattern.compile("^[a-zA-Z]$");
    @Autowired
    private MovieService movieService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movies movies = (Movies) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (movies.getTitle() != null && !TITLE_REGEX.matcher(movies.getTitle()).matches()) {
            errors.rejectValue("email", "Regex.userform.title");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (movies.getAuthor() != null && !AUTHOR_REGEX.matcher(movies.getAuthor()).matches()) {
            errors.rejectValue("email", "Regex.userform.author");
        }

    }
}
