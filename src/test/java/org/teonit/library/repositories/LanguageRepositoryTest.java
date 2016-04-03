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
import org.teonit.library.domain.Language;
import org.teonit.library.repositories.LanguageRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
@Transactional
public class LanguageRepositoryTest {
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Before
	@Rollback(false)
	public void setUp() {
		languageRepository.save(new Language("en", "English"));
		languageRepository.save(new Language("ua", "Ukrainian"));
		languageRepository.save(new Language("pl", "Poland"));
	}
	
	@Test
	public void testCount() {
		long count = languageRepository.count();
		
		assertEquals(3, count);
	}
	
	@Test
	public void testFindAll() {
		Iterable<Language> languages = languageRepository.findAll();
		for (Language language : languages) {
			assertNotNull(language.getId());
			assertNotNull(language.getCode());
			assertNotNull(language.getName());
		}
	}
	
	@Test
	public void testFindByCode() {
		Language language = languageRepository.findOneByCode("en");
		assertNotNull(language);
		assertEquals("English", language.getName());
	}

}
