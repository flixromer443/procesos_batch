package ar.gov.anses.Batch;

import ar.gov.anses.Batch.step1.Step1ItemWriter;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class ProcesoBatch extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired @Qualifier("step1ItemReader")
    private FlatFileItemReader step1ItemReader;

    @Autowired @Qualifier("step1ItemWriter")
    private Step1ItemWriter step1ItemWriter;



    @Bean("CRUCE")
    public Job cruce(){
        return jobBuilderFactory.get("GENERAR NUEVOS ARCHIVO")
                .start(step1(step1ItemReader, step1ItemWriter))
                .build();
    }

    public Step step1(@Qualifier("step1ItemReader") ItemReader<EDocumentoOriginalDTO> itemReader,
                      @Qualifier("step1ItemWriter") ItemWriter<EDocumentoOriginalDTO> itemWriter){
        return stepBuilderFactory.get("procesar edocumentos")
                .<EDocumentoOriginalDTO,EDocumentoOriginalDTO>chunk(100000)
                .reader(itemReader)
                .writer(itemWriter)
                .allowStartIfComplete(true)
                .build();
    }

    @Override
    @Autowired(required = false)
    public void setDataSource(@Qualifier("springBatchDataSource") DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
