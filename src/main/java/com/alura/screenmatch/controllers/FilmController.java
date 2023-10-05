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

    @PutMapping("/{id}")
    public ResponseEntity<String> editFilms(@PathVariable Long id, @RequestBody Film film){
        Boolean verify = service.editFilm(film, id);
        return verify ?
                ResponseEntity.status(200).body("Filme editado") :
                ResponseEntity.status(400).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id){
        Boolean verify = service.deleteFilm(id);
        return verify ?
                ResponseEntity.status(200).body("Filme deletado") :
                ResponseEntity.status(400).build();
    }
}
