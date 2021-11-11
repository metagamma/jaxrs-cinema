package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Film;

public interface IFilmRepository {
	
	List<Film> getAllFilms();

	Film getFilmById(Long id);

	boolean addFilm(Film film);

	boolean updateFilm(Film film);

	boolean deleteFilm(Long id);

}
