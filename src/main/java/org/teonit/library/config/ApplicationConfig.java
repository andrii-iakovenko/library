package org.teonit.library.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableNeo4jRepositories(basePackages = "org.teonit.library.repositories")
@EnableTransactionManagement
public class ApplicationConfig extends Neo4jConfiguration {

	public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL")
			: "http://localhost:7474";

	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory("org.teonit.library.domain");
	}

	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer(URL);
	}
}
