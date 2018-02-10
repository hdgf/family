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
        entityManagerFactoryRef = "shopEntityManagerFactory",
        transactionManagerRef = "shopTransactionManager",
        basePackages = {"com.universe.family.model.cronous.shop"})
public class ShopDbConfig {

  @Bean(name = "shopDataSource")
  @ConfigurationProperties(prefix = "datasource.datacenter")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "shopEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean shopEntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("shopDataSource") DataSource dataSource) {
    return builder
            .dataSource(dataSource)
            .packages("com.universe.family.model.cronous.shop")
            .persistenceUnit("shop")
            .build();
  }

  @Bean(name = "shopTransactionManager")
  public PlatformTransactionManager shopTransactionManager(
      @Qualifier("shopEntityManagerFactory") EntityManagerFactory shopEntityManagerFactory) {
    return new JpaTransactionManager(shopEntityManagerFactory);
  }

}
