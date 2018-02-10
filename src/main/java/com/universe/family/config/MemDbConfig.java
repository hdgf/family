package com.universe.family.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "memEntityManagerFactory",
        transactionManagerRef = "memTransactionManager",
        basePackages = {"com.universe.family.model.cronous.member"})
public class MemDbConfig {

  @Bean(name = "primaryDataSource")
  @Primary
  @ConfigurationProperties(prefix = "datasource.primary")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "memEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean memEntityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("primaryDataSource") DataSource dataSource) {
    return builder
            .dataSource(dataSource)
            .packages("com.universe.family.model.cronous.member")
            .persistenceUnit("DB_Member")
            .build();
  }

  @Primary
  @Bean(name = "memTransactionManager")
  public PlatformTransactionManager memTransactionManager(
      @Qualifier("memEntityManagerFactory") EntityManagerFactory memEntityManagerFactory) {
    return new JpaTransactionManager(memEntityManagerFactory);
  }
}