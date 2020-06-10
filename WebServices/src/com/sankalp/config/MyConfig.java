package com.sankalp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sankalp.model.User;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.sankalp" })
//@PropertySource(value = { "classpath:application.properties" })
public class MyConfig implements WebMvcConfigurer {

	/*@Autowired
	Environment environment;
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	 public DataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.class"));
	  dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	  dataSource.setUsername(environment.getRequiredProperty("jdbc.user"));
	  dataSource.setPassword(environment.getRequiredProperty("jdbc.pass"));
	  System.out.println("sankalp database " + dataSource);
	  return dataSource;
	 }
	
	@Bean
	 public LocalSessionFactoryBean sessionFactory() {
	  LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource());
	  // sessionFactory.setPackagesToScan(new String[] {"com.example.model"});
	  sessionFactory.setAnnotatedClasses(User.class);
	  sessionFactory.setHibernateProperties(hibernateProperties());
	  System.out.println("sankalp session " + sessionFactory);
	  return sessionFactory;
	 }
	
	private Properties hibernateProperties() {
		  Properties properties = new Properties();
		  //properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		  properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		  properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		  properties.put("hibernate.hbm2ddl.auto", 
		                environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		  System.out.println(properties);
		  return properties;
		 }
	
	 @Bean
	 public HibernateTransactionManager getTransactionManager() {
	  System.out.println("transaction "+"hello");
	  HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	  transactionManager.setSessionFactory(sessionFactory().getObject());
	  System.out.println("transaction "+transactionManager);
	  return transactionManager;
	 }
/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
		
	}*/

}
