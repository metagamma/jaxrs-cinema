package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Format;

public interface IFormatRepository {

	List<Format> getAllFormats();

	Format getFormatById(Long id);

	boolean addFormat(Format format);

	boolean updateFormat(Format format);

	boolean deleteFormat(Long id);

}
