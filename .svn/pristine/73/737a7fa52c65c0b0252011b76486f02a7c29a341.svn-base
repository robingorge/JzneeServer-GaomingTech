package com.gmkw.jznee.configuration;

import com.gmkw.jznee.repository.read.ToolReadRepository;
import com.gmkw.jznee.repository.write.ToolWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;


/**
 * 数据库相关操作配置
 */
@Configuration
public class DataAccessConfiguration {

    @Autowired
    private JpaProperties properties;


    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.write")
    public DataSourceProperties writeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.write")
    public DataSource writeDataSource() {
        return writeDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.read")
    public DataSourceProperties readDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.read")
    public DataSource readDataSource() {
        return readDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean writeEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("writeDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.gmkw.jznee.entity")
                .properties(getVendorProperties())
                .persistenceUnit("write")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("readDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.gmkw.jznee.entity")
                .properties(getVendorProperties())
                .persistenceUnit("read")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager writeTransactionManager(@Qualifier("writeEntityManagerFactory") LocalContainerEntityManagerFactoryBean writeEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(writeEntityManagerFactory.getObject());
        return transactionManager;
    }

    @Bean
    public PlatformTransactionManager readTransactionManager(@Qualifier("readEntityManagerFactory") LocalContainerEntityManagerFactoryBean readEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(readEntityManagerFactory.getObject());
        return transactionManager;
    }

    @EnableJpaRepositories(basePackageClasses = ToolWriteRepository.class,
            entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef = "writeTransactionManager")
    @Primary
    public class WriteConfiguration {
    }


    @EnableJpaRepositories(basePackageClasses = ToolReadRepository.class,
            entityManagerFactoryRef = "readEntityManagerFactory", transactionManagerRef = "readTransactionManager")
    public class ReadConfiguration {
    }

    protected Map<String, Object> getVendorProperties() {
        return properties.getHibernateProperties(new HibernateSettings());
    }

}
