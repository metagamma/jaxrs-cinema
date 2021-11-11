package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Rating;

public interface IRatingRepository {

	List<Rating> getAllRatings();

	Rating getRatingById(Long id);

	boolean addRating(Rating rating);

	boolean updateRating(Rating rating);

	boolean deleteRating(Long id);

}
