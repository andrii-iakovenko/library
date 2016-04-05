package org.teonit.library.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.teonit.library.config.TestApplicationConfig;
import org.teonit.library.domain.Organization;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestApplicationConfig.class })
@Transactional
public class OrganizationRepositoryTest {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Before
	@Rollback(false)
	public void setUp() {
		organizationRepository.save(new Organization("First organization"));
		organizationRepository.save(new Organization("Second organization"));
		organizationRepository.save(new Organization("Third organization"));
	}

	@Test
	public void testCount() {
		long count = organizationRepository.count();

		assertEquals(3, count);
	}

	@Test
	public void testFindAll() {
		Iterable<Organization> organizations = organizationRepository.findAll();
		assertNotNull(organizations);
		organizations.forEach(org -> {
			assertNotNull(org.getId());
			assertNotNull(org.getName());
		});
	}

	@Test
	public void testFindByName() {
		Iterable<Organization> organizations = organizationRepository.findByNameLike(".*ook.*");
		assertNotNull(organizations);
		organizations.forEach(org -> {
			assertNotNull(org.getId());
			assertNotNull(org.getName());
		});
	}

}
