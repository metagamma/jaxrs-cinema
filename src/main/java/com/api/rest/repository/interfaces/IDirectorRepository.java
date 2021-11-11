package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Director;

public interface IDirectorRepository {
	
	List<Director> getAllDirectors();

	Director getDirectorById(Long id);

	boolean addDirector(Director director);

	boolean updateDirector(Director director);

	boolean deleteDirector(Long id);

}
