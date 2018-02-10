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
        entityManagerFactoryRef = "season2EntityManagerFactory",
        transactionManagerRef = "season2TransactionManager",
        basePackages = {"com.universe.family.model.cronous.season2"})
public class SeasonIIDbConfig {

  @Bean(name = "season2DataSource")
  @ConfigurationProperties(prefix = "datasource.first")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "season2EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean season2EntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("season2DataSource") DataSource dataSource) {
    return builder
            .dataSource(dataSource)
            .packages("com.universe.family.model.cronous.season2")
            .persistenceUnit("PersonalAccount")
            .build();
  }

  @Bean(name = "season2TransactionManager")
  public PlatformTransactionManager season2TransactionManager(
      @Qualifier("season2EntityManagerFactory") EntityManagerFactory season2EntityManagerFactory) {
    return new JpaTransactionManager(season2EntityManagerFactory);
  }

}
