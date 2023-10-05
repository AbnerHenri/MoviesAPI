package com.alura.screenmatch.services.interfaces;

import com.alura.screenmatch.models.Film;

import java.util.List;

public interface FilmService {

    public void addFilm(Film film);

    public List<Film> returnFilms();

    public Boolean editFilm(Film film, Long id);

    public Boolean deleteFilm(Long id);
}
