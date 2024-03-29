package ar.gov.anses.Config;

import ar.gov.anses.Batch.step1.Step1ItemProcessor;
import ar.gov.anses.Batch.step1.Step1ItemWriter;
import ar.gov.anses.Batch.step2.Step2ItemWriter;
import ar.gov.anses.Batch.step3.Step3ItemWriter;
import ar.gov.anses.Sentencias.Carga.GeneradorCargaImpl;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.Util.ItemReaderUtilImpl;
import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class BatchConfig {

    @Autowired
    private Environment environment;

    /** Componentes del proceso BATCH **/

    /** Readers **/

    /**Es el encargado de leer el archivo @BAJADA_EDOCUMENTO.csv**/

    @Bean("step1ItemReader")
    @StepScope
    public FlatFileItemReader<EDocumentoOriginalDTO> step1ItemReader(){
        String raiz = environment.getProperty("carpeta.raiz");
        FlatFileItemReader flatFileItemReader = new FlatFileItemReader();
        ItemReaderUtilImpl itemReaderUtil = new ItemReaderUtilImpl();
        flatFileItemReader.setResource(new FileSystemResource(NamespacesUtil.obtenerUrl(raiz,"/BAJADAS/BAJADA_EDOCUMENTO.csv")));
        flatFileItemReader.setLineMapper(itemReaderUtil.getlineMapper());
        flatFileItemReader.setStrict(false);

        return flatFileItemReader;
    }

    /** Va a ser el encargado de traer los registros grabados en el archivo de salida
     ** para poder generar los archivos PROCESADOS.txt y NO_PROCESADOS.txt **/

    @Bean("finalItemReader")
    @StepScope
    public FlatFileItemReader<EDocumentoOriginalDTO> finalItemReader(){
        String raiz = environment.getProperty("carpeta.raiz");
        FlatFileItemReader flatFileItemReader = new FlatFileItemReader();
        ItemReaderUtilImpl itemReaderUtil = new ItemReaderUtilImpl();
        flatFileItemReader.setResource(new FileSystemResource(NamespacesUtil.obtenerUrl(raiz,"/TRAMITES/SALIDA.txt.1")));
        flatFileItemReader.setLineMapper(itemReaderUtil.getFinalLineMapper());
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
    public Step2ItemWriter step2ItemWriter(){
        return new Step2ItemWriter();
    }

    @Bean
    public Step3ItemWriter step3ItemWriter(){
        return new Step3ItemWriter();
    }

    @Bean
    public GeneradorCargaImpl generadorCarga(){
        return new GeneradorCargaImpl();
    }


}
