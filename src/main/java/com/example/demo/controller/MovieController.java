package com.example.demo.controller;




import com.example.demo.model.Movies;
import com.example.demo.model.User;
import com.example.demo.service.MovieService;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


@Controller

@EnableAutoConfiguration
public class MovieController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    @Autowired

    @Qualifier("NumberService")
    public MovieService movieService;

    @GetMapping({"/", "/movie"})
    String home(Model model) {

        model.addAttribute("number", new Movies());

        return "movie";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/movieShow")
    String movieShow(@Valid @ModelAttribute("number") Movies e, BindingResult br,
                            @RequestParam HashMap<String, String> movieTable, ModelMap modelMap) {

        if (br.hasErrors()) {
            return "movie";
        } else {
            String title = movieTable.get("title");
            String author = movieTable.get("author");
            String rating = movieTable.get("rating");
            String genres = movieTable.get("genres");




            modelMap.put("title", title);
            modelMap.put("author", author);
            modelMap.put("rating", rating);
            modelMap.put("genres", genres);


            movieService.save(new Movies(title, author, rating, genres));

            return "movie";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/movieTable")
    public String getAllNumbers(Model model) {
        model.addAttribute("movieTable", movieService.getAll());
        return "movieTable";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show{id}")
    public String getById(@RequestParam("id") int id, Model model) {
        model.addAttribute("movies", movieService.getById(id));
        return "movies";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleting{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        movieService.delete(id);
        model.addAttribute("movieTable", movieService.getAll());
        return "movieTable";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateMovie{id}")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("movies", movieService.getById(id));
        return "updateMovie";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateMovies")
    public String updateNumber(@ModelAttribute("id") Movies movies) {
    movieService.update(movies);
    return "redirect:/show?id=" + movies.getId();
    }


    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect://localhost:8090";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Username or password is incorrect");

        if (logout != null)
            model.addAttribute("message", "Successfullly logged out");

            return "login";
    }


}



