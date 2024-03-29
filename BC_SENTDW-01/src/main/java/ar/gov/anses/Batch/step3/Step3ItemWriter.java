package ar.gov.anses.Batch.step3;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
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

import java.util.ArrayList;
import java.util.List;

/** Clase que se encarga de grabar los registros no procesados por el servicio di **/

public class Step3ItemWriter implements ItemWriter<EDocumentoOriginalDTO> {
    private Logger logger =  LoggerFactory.getLogger(Step3ItemWriter.class);

    @Autowired
    private Environment environment;

    @Override
    public void write(List<? extends EDocumentoOriginalDTO> list) throws Exception {
        List<EDocumentoOriginalDTO> edocumentosNoProcesados = new ArrayList<>();
        for(EDocumentoOriginalDTO eDocumentoOriginalDTO : list){
            int estadoProceso = eDocumentoOriginalDTO.getEstadoProceso();
            if(estadoProceso == Constantes.CARGA_GENERADA || estadoProceso == Constantes.NO_PROCESADO){
                eDocumentoOriginalDTO.setEstadoProcesoStr(determinarEstadoProcesoStr(estadoProceso));
                edocumentosNoProcesados.add(eDocumentoOriginalDTO);
            }
        }

        logger.info("ESCRIBIENDO " + edocumentosNoProcesados.size() + " REGISTROS EN EL ARCHIVO DE ELEMENTOS NO PROCESADOS");
        multiResourceItemWriter().write(edocumentosNoProcesados);
    }

    private String determinarEstadoProcesoStr(Integer estadoProceso){
        if(estadoProceso == Constantes.CARGA_GENERADA){
            return Constantes.ESTADO_1;
        }else {
            return Constantes.ESTADO_0;
        }

    }

    public MultiResourceItemWriter multiResourceItemWriter(){
        String raiz = environment.getProperty("carpeta.raiz");
        MultiResourceItemWriter multiResourceItemWriter = new MultiResourceItemWriter();
        multiResourceItemWriter.setResource(new FileSystemResource(NamespacesUtil.obtenerUrl(raiz,"/TRAMITES/NO_PROCESADOS.txt")));
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
        beanWrapperFieldExtractor.setNames(Constantes.namesFinalWriters);
        return beanWrapperFieldExtractor;
    }

}
