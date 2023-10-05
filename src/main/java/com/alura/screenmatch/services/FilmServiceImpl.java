package com.alura.screenmatch.services;

import com.alura.screenmatch.models.Film;
import com.alura.screenmatch.repository.FilmRepository;
import com.alura.screenmatch.services.interfaces.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository repository;

    public List<Film> returnFilms(){
        return repository.findAll();
    }

    public void addFilm(Film requestData) {
        repository.save(requestData);
    }

    public Boolean editFilm(Film requestData, Long id){
        Optional<Film> film = repository.findById(id);

        if(film.isPresent()){
            Film movie = film.get();

            movie.setName(requestData.getName());
            movie.setDuration(requestData.getDuration());
            movie.setGenus(requestData.getGenus());

            repository.save(movie);
            return true;
        }else{
            return false;
        }
    };
}
