package org.teonit.library.config;

import java.io.File;
import java.io.IOException;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.io.fs.FileUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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
	
	@Bean(destroyMethod = "shutdown")
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GraphDatabaseService graphDatabaseService() {
        try {
            FileUtils.deleteRecursively(new File("target/test-db"));
            return new GraphDatabaseFactory().newEmbeddedDatabase("target/test-db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
