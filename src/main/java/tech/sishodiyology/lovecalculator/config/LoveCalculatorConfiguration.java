package tech.sishodiyology.lovecalculator.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import tech.sishodiyology.lovecalculator.formatter.PhoneFormatter;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { 
		"tech.sishodiyology.lovecalculator.controllers",
		"tech.sishodiyology.lovecalculator.dao",
		"tech.sishodiyology.lovecalculator.service"})
public class LoveCalculatorConfiguration implements WebMvcConfigurer {

	// Constructor
	public LoveCalculatorConfiguration() {
		System.out.println("*************** In CONFIGURATION CLASS ***************");
	}

	// View Resolver Configuration
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		System.out.println("VIEW RESOLVER CREATED");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//Java Mail Sender
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(25);
		mailSender.setUsername("sishodiya.official@gmail.com");
		mailSender.setPassword("Gmail@9790");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	// Formatter Registry into container
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("REGISTERED PHONE FORMATTER");
		registry.addFormatter(new PhoneFormatter());
	}

	// Configuring Custom Validation Annotation Messages from property file
	@Override
	public Validator getValidator() {
		System.out.println("PROPERTY FILE FETCHED FOR @CUSTOM VALIDATION");
		return validator();
	}

	// Creating LocalValidationFactoryBean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validatorFactory = new LocalValidatorFactoryBean();
		validatorFactory.setValidationMessageSource(messageSource());
		return validatorFactory;
	}

	// Creating message source with resource bundle (Property file)
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("validationmessages");
		return messageSource;
	}

	// Creating Spring JDBC Template
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		System.out.println("JDBC TEMPLATE CREATED");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	//Configuring Hibernate in spring mvc
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/love_calculator");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("tech.sishodiyology.lovecalculator.model");
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}
	
	@Bean
	 public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
	      return new HibernateTransactionManager(sessionFactory);
	 }
	
	public Properties getHibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		hibernateProperties.setProperty("not-found", "ignore");
		return hibernateProperties;
	}
	
}
