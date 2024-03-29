package ar.gov.anses.Batch.step1;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.Ejecucion.ModoEjecucion;
import ar.gov.anses.Sentencias.Util.ModoEjecucionUtil;
import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import ar.gov.anses.Sentencias.Util.MultiResourceItemWriterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Clase que se encarga de guardar un estado por registro en base a la
 ** respuesa que se obtuvo del llamado al WebService **/

public class Step1ItemWriter implements ItemWriter<EDocumentoOriginalDTO> {

    private Logger logger =  LoggerFactory.getLogger(Step1ItemWriter.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ModoEjecucion modoEjecucion;

    @Override
    public void write(List<? extends EDocumentoOriginalDTO> list) throws Exception {
        String modo =  environment.getProperty("modo.ejecucion");
        logger.info("Generando nuevo archivo BAJADA_EDOCUMENTO.csv");
        logger.info("Modo de ejecucion seleccionado: " + ModoEjecucionUtil.obtenerModoEjecucionStr(modo));
        List<EDocumentoOriginalDTO> edocumentosActualizados = modoEjecucion.ejecutar(list, modo);
        multiResourceItemWriter().write(edocumentosActualizados);
    }


    public MultiResourceItemWriter multiResourceItemWriter(){
        String raiz = environment.getProperty("carpeta.raiz");
        MultiResourceItemWriter multiResourceItemWriter = new MultiResourceItemWriter();
        multiResourceItemWriter.setResource(new FileSystemResource(NamespacesUtil.obtenerUrl(raiz,"/SALIDA/BAJADA_EDOCUMENTO.csv")));
        multiResourceItemWriter.setDelegate(flatFileItemWriter());
        return new MultiResourceItemWriterUtil().setParameters(multiResourceItemWriter);
    }

    public FlatFileItemWriter flatFileItemWriter(){
        FlatFileItemWriter flatFileItemWriter = new FlatFileItemWriter();
        flatFileItemWriter.setShouldDeleteIfExists(true);
        flatFileItemWriter.setLineAggregator(lineAgregartor());
        return flatFileItemWriter;
    }

    public DelimitedLineAggregator lineAgregartor(){
        DelimitedLineAggregator delimitedLineAggregator = new DelimitedLineAggregator();
        delimitedLineAggregator.setDelimiter(",");
        delimitedLineAggregator.setFieldExtractor(fieldExtractor());
        return delimitedLineAggregator;
    }
    public BeanWrapperFieldExtractor fieldExtractor(){
        BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
        beanWrapperFieldExtractor.setNames(Constantes.names);
        return beanWrapperFieldExtractor;
    }



}
