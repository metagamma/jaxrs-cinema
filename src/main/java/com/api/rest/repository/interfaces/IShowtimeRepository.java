package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Showtime;

public interface IShowtimeRepository {

	List<Showtime> getAllShowtimes();

	List<Showtime> getShowtimesByDateAndLocale(String fecha, Long local);

	Showtime getShowtimeById(Long id);

	boolean addShowtime(Showtime showtime);

	boolean updateShowtime(Showtime showtime);

	boolean deleteShowtime(Long id);

}