package com.alura.screenmatch.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "db_films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer duration;
    private String genus;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id.equals(film.id) && name.equals(film.name) && duration.equals(film.duration) && genus.equals(film.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, genus);
    }
}
