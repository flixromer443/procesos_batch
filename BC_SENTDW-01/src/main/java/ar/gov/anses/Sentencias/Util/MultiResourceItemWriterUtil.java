package ar.gov.anses.Sentencias.Util;

import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.SimpleResourceSuffixCreator;

/**Clase util de los writers para no repetir mucho codigo**/

public class MultiResourceItemWriterUtil {

    public MultiResourceItemWriter setParameters(MultiResourceItemWriter multiResourceItemWriter){
        multiResourceItemWriter.setResourceSuffixCreator(new SimpleResourceSuffixCreator());
        multiResourceItemWriter.setSaveState(false);
        return multiResourceItemWriter;
    }
}
