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
        entityManagerFactoryRef = "videoEntityManagerFactory",
        transactionManagerRef = "videoTransactionManager",
        basePackages = {"com.universe.family.model.video"})
public class VideoDbConfig {

  @Bean(name = "videoDataSource")
  @ConfigurationProperties(prefix = "datasource.master")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "videoEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean videoEntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("videoDataSource") DataSource dataSource) {
    return builder
            .dataSource(dataSource)
            .packages("com.universe.family.model.video")
            .persistenceUnit("User")
            .build();
  }

  @Bean(name = "videoTransactionManager")
  public PlatformTransactionManager videoTransactionManager(
      @Qualifier("videoEntityManagerFactory") EntityManagerFactory videoEntityManagerFactory) {
    return new JpaTransactionManager(videoEntityManagerFactory);
  }

}
