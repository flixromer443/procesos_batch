package ar.gov.anses.Config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class WebConfig {

    /** Base de datos **/
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "sicasent.datasource")
    public DataSource sicasentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.batch.datasource")
    public DataSource springBatchDataSource() {
        return DataSourceBuilder.create().build();
    }
}
