package ar.gov.anses.Batch.step1;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.Constantes.CamposArchivo;
import ar.gov.anses.Sentencias.Constantes.CarpetasArchivos;
import ar.gov.anses.Sentencias.Constantes.Situaciones;

import ar.gov.anses.Sentencias.DTO.EstadoHistoricoDTO;
import ar.gov.anses.Sentencias.DTO.UsuarioDTO;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Clase que se encarga de guardar un estado por registro en base a la
 ** respuesa que se obtuvo del llamado al WebService **/

public class Step1ItemWriter implements ItemWriter<UsuarioDTO> {

    private Logger logger =  LoggerFactory.getLogger(Step1ItemWriter.class);

    @Autowired
    private Environment environment;

    @Override
    public void write(List<? extends UsuarioDTO> list) throws Exception {
        logger.info("ESCRIBIENDO " + list.size() + " REGISTROS EN EL ARCHIVO DE SALIDA");

        logger.info("Se han actualizado los estados historicos de "
           + obtenerCantidadPorCasuistica(list, Situaciones.ACTUALIZADO) + "/"+ list.size()+
               " usuarios del sistema");

        multiResourceItemWriter().write(ordenarPorSituacion(list));
    }

    public MultiResourceItemWriter multiResourceItemWriter(){
        String raiz = environment.getProperty("carpeta.raiz");
        MultiResourceItemWriter multiResourceItemWriter = new MultiResourceItemWriter();
        multiResourceItemWriter.setResource(NamespacesUtil.obtenerArchivo(raiz,CarpetasArchivos.ARCHIVO_SALIDA));
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
        beanWrapperFieldExtractor.setNames(CamposArchivo.SALIDA);
        return beanWrapperFieldExtractor;
    }

    private List<UsuarioDTO> ordenarPorSituacion(List<? extends UsuarioDTO> list){
        List<UsuarioDTO> nuevaLista= new ArrayList<>();
        for(UsuarioDTO usuario : list){
            if(usuario.getSituacion().equals(Situaciones.ACTUALIZADO)){
                nuevaLista.add(usuario);
            }
        }
        for(UsuarioDTO usuario : list){
            if(usuario.getSituacion().equals(Situaciones.NO_ACTUALIZADO)){
                nuevaLista.add(usuario);
            }
        }
        return nuevaLista;
    }

    private Integer obtenerCantidadPorCasuistica(List<? extends UsuarioDTO> list, String casuistica){
        return  list
               .stream()
               .filter(e->((UsuarioDTO) e).getSituacion().equals(casuistica))
               .collect(Collectors.toList())
                .size();
    }
}
