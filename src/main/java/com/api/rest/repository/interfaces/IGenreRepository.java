package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Genre;

public interface IGenreRepository {

	List<Genre> getAllGenres();

	Genre getGenreById(Long id);

	boolean addGenre(Genre genre);

	boolean updateGenre(Genre genre);

	boolean deleteGenre(Long id);

}
