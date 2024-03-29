package ar.gov.anses.Batch;

import ar.gov.anses.Batch.step1.Step1ItemProcessor;
import ar.gov.anses.Batch.step1.Step1ItemWriter;
import ar.gov.anses.Sentencias.DTO.UsuarioDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
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

    @Autowired @Qualifier("step1ItemProcessor")
    private Step1ItemProcessor step1ItemProcessor;

    @Autowired @Qualifier("step1ItemWriter")
    private Step1ItemWriter step1ItemWriter;


    @Bean("CRUCE")
    public Job cruce(){
        return jobBuilderFactory.get("REPROCESAR ESTADOS HISTORICOS")
                .start(step1(step1ItemReader, step1ItemProcessor, step1ItemWriter))
                .build();
    }

    public Step step1(@Qualifier("step1ItemReader") ItemReader<UsuarioDTO> itemReader,
                      @Qualifier("step1ItemProcessor") ItemProcessor<UsuarioDTO, UsuarioDTO> itemProcessor,
                      @Qualifier("step1ItemWriter") ItemWriter<UsuarioDTO> itemWriter){
        return stepBuilderFactory.get("procesar edocumentos")
                .<UsuarioDTO,UsuarioDTO>chunk(100000)
                .reader(itemReader)
                .processor(itemProcessor)
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
