package ar.gov.anses.Config;

import ar.gov.anses.DigiWeb.WS.digitalizacionWSClient.DigitalizacionWSCLient;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

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


    /** Servicio Web **/
    @Bean(name = "digitalizacionMarshaller")
    public Jaxb2Marshaller digitalizacionMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ar.gov.anses.DigiWeb.WS.digitalizacionWS");
        return marshaller;
    }

    @Bean
    public DigitalizacionWSCLient digitalizacionServicioClient(Jaxb2Marshaller digitalizacionMarshaller) {
        DigitalizacionWSCLient client = new DigitalizacionWSCLient ();
        client.setMarshaller(digitalizacionMarshaller);
        client.setUnmarshaller(digitalizacionMarshaller);
        return client;
    }

}
