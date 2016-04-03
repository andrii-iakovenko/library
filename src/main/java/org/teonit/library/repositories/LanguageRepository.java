package org.teonit.library.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.teonit.library.domain.Language;

/**
 * Language repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface LanguageRepository extends GraphRepository<Language> {
	
	Language findOneByCode(String code);

}
