package org.teonit.library.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * This class represents organization such as a school, NGO, corporation, club,
 * etc.
 *
 * 
 * {@link https://schema.org/Organization}
 * 
 * @author Andrii Iakovenko
 *
 */
@NodeEntity
public class Organization {

	@GraphId
	private Long id;

	private String name;

	/**
	 * Create a new instance of {@code Organization}
	 *
	 */
	public Organization() {
	}

	/**
	 * Create a new instance of {@code Organization}
	 *
	 * @param name
	 *            the organization name.
	 */
	public Organization(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
