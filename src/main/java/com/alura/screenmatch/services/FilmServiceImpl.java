package com.alura.screenmatch.services;

import com.alura.screenmatch.models.Film;
import com.alura.screenmatch.repository.FilmRepository;
import com.alura.screenmatch.services.interfaces.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository repository;

    public List<Film> returnFilms(){
        return repository.findAll();
    }

    public void addFilm(Film film) {
        repository.save(film);
    }
}
