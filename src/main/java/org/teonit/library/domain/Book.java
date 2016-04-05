package org.teonit.library.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * This class represents Book.
 * 
 * {@link https://schema.org/Book Book}
 * 
 * @author Andrii Iakovenko
 *
 */
@NodeEntity
public class Book {

	@GraphId
	private Long id;

	@Index(unique = true)
	private String isbn;
	
	private String name;

	private String url;

	private String description;

	@Relationship(type = "PUBLISHER", direction = Relationship.UNDIRECTED)
	private Organization publisher;

	@Relationship(type = "LANGUAGE", direction = Relationship.UNDIRECTED)
	private Language inLanguage;

	private Long numberOfPages;
	
	/**
	 * Create a new instance of {@code Book}
	 *
	 */
	public Book() {
	}
	
	/**
	 * Create a new instance of {@code Book}
	 *
	 * @param name the book name.
	 */
	public Book(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the publisher
	 */
	public Organization getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Organization publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the inLanguage
	 */
	public Language getInLanguage() {
		return inLanguage;
	}

	/**
	 * @param inLanguage the inLanguage to set
	 */
	public void setInLanguage(Language inLanguage) {
		this.inLanguage = inLanguage;
	}

	/**
	 * @return the numberOfPages
	 */
	public Long getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(Long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
