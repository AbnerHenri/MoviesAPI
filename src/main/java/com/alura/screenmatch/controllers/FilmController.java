package com.alura.screenmatch.controllers;

import com.alura.screenmatch.models.Film;
import com.alura.screenmatch.services.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/filmes")
public class FilmController {

    @Autowired
    private FilmServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Film>> returnFilms(){
        List<Film> films = service.returnFilms();
        return ResponseEntity.status(200).body(films);
    }

    @PostMapping
    public ResponseEntity<Film> registerFilms(@RequestBody Film film){
        service.addFilm(film);
        return ResponseEntity.status(200).body(film);
    }
}
