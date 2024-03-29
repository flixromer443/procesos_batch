package ar.gov.anses.Sentencias.Util;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

/**Clase util de los readers para no repetir mucho codigo**/

public class ItemReaderUtilImpl{


    public DefaultLineMapper getlineMapper(){
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(lineTokenizer(Constantes.namesReader1));
        lineMapper.setFieldSetMapper(fieldSetMapper());
        return lineMapper;
    }
    public DefaultLineMapper getFinalLineMapper(){
        DefaultLineMapper lineMapper = new DefaultLineMapper();
        lineMapper.setLineTokenizer(lineTokenizer(Constantes.names));
        lineMapper.setFieldSetMapper(fieldSetMapper());
        return lineMapper;
    }

    private DelimitedLineTokenizer lineTokenizer(String[] names){
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setNames(names);
        return delimitedLineTokenizer;
    }

    private BeanWrapperFieldSetMapper fieldSetMapper() {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(EDocumentoOriginalDTO.class);
        return fieldSetMapper;
    }
}
