package com.universe.family.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "gameEntityManagerFactory",
        transactionManagerRef = "gameTransactionManager",
        basePackages = {"com.universe.family.model.cronous.game"})
public class GameDbConfig {

  @Bean(name = "gameDataSource")
  @ConfigurationProperties(prefix = "datasource.secondary")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "gameEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean gameEntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("gameDataSource") DataSource dataSource) {
    return builder
            .dataSource(dataSource)
            .packages("com.universe.family.model.cronous.game")
            .persistenceUnit("PersonalAccount")
            .build();
  }

  @Bean(name = "gameTransactionManager")
  public PlatformTransactionManager gameTransactionManager(
      @Qualifier("gameEntityManagerFactory") EntityManagerFactory gameEntityManagerFactory) {
    return new JpaTransactionManager(gameEntityManagerFactory);
  }

}
