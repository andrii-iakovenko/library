package org.teonit.library.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.teonit.library.domain.Book;

/**
 * Book repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface BookRepository extends GraphRepository<Book> {
	
	@Query("MATCH (b:Book) WHERE b.name =~ ('(?i).*'+{name}+'.*') RETURN b")
	Iterable<Book> findByNameContaining(@Param("name") String name);

}
