package ar.gov.anses.Config;


import ar.gov.anses.Batch.step1.Step1ItemProcessor;
import ar.gov.anses.Batch.step1.Step1ItemWriter;

import ar.gov.anses.Sentencias.Carga.GeneradorCargaImpl;
import ar.gov.anses.Sentencias.Constantes.CarpetasArchivos;

import ar.gov.anses.Sentencias.DTO.UsuarioDTO;
import ar.gov.anses.Sentencias.Util.ItemReaderUtilImpl;

import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import org.springframework.batch.core.configuration.annotation.StepScope;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class BatchConfig {

    @Autowired
    private Environment environment;

    /** Componentes del proceso BATCH **/

    /** Readers **/

    @Bean("step1ItemReader")
    @StepScope
    public FlatFileItemReader<UsuarioDTO> step1ItemReader(){
        String raiz = environment.getProperty("carpeta.raiz");
        FlatFileItemReader flatFileItemReader = new FlatFileItemReader();
        ItemReaderUtilImpl itemReaderUtil = new ItemReaderUtilImpl();
        flatFileItemReader.setResource(NamespacesUtil.obtenerArchivo(raiz, CarpetasArchivos.ARCHIVO_ENTRADA));
        flatFileItemReader.setLineMapper(itemReaderUtil.getlineMapper());
        flatFileItemReader.setStrict(false);

        return flatFileItemReader;
    }


    /** Processor **/
    @Bean
    public Step1ItemProcessor step1ItemProcessor(){
        return new Step1ItemProcessor();
    }

    /** Writers **/

    @Bean
    public Step1ItemWriter step1ItemWriter(){
        return new Step1ItemWriter();
    }

    @Bean
    public GeneradorCargaImpl generadorCarga(){
        return new GeneradorCargaImpl();
    }

}
