package org.teonit.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.server.InProcessServer;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TestApplicationConfig extends ApplicationConfig {
	
	@Override
	public Neo4jServer neo4jServer() {
		return new InProcessServer();
	}

}
