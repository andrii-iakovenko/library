package org.teonit.library.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.teonit.library.domain.Organization;

/**
 * Organization repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface OrganizationRepository extends GraphRepository<Organization> {

	Iterable<Organization> findByNameLike(String name);

}
