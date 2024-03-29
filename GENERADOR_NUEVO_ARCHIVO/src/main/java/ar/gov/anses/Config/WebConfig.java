package ar.gov.anses.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class WebConfig {

    /** Base de datos **/
    @Bean
    @ConfigurationProperties(prefix = "spring.batch.datasource")
    public DataSource springBatchDataSource() {
        return DataSourceBuilder.create().build();
    }
}
