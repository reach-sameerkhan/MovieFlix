package io.movieflix.rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("io.movieflix.rest.model");
		JpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adaptor);
		emf.setJpaProperties(properties());
		return emf;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflix-db");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}

	@Bean 
	public PlatformTransactionManager txnManager(EntityManagerFactory emf){
		JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
		return txnMgr;
	}
	
	private Properties properties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop"); 	
		/*
		create: create the schema destroying previous data.
		validate: validate the schema. makes no changes in the database
		create-drop: drop the schema when session factory is closed.(when the application is closed)
		update: update the schema
		*/
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
}
