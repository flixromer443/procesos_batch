package ar.gov.anses.Sentencias.Util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import javax.xml.datatype.XMLGregorianCalendar;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ModoEjecucionUtilTest {

    @Test
    public void debePoderCorrejirElCampoRuta() throws Exception{

        String path = "\\\\cluster.isilon.anses.gov.ar\\ServicioDigitalizacion\\Digitalizacion\\sicasent\\2022\\12\\06";
        String nombre = "817794_3.pdf";
        String pathEsperado = "\\\\cluster.isilon.anses.gov.ar\\ServicioDigitalizacion\\Digitalizacion\\sicasent\\2022\\12\\06\\817794_3.pdf";

        assertEquals(pathEsperado, ModoEjecucionUtil.obtenerNuevoPath(path, nombre));
    }

    @Test
    public void noDebePoderCorrejirElCampoRuta() throws Exception{

        String path = "\\\\cluster.isilon.anses.gov.ar\\ServicioDigitalizacion\\Digitalizacion\\sicasent\\2022\\12\\06\\817794_3.pdf";
        String nombre = "817794_3.pdf";
        String pathEsperado = "\\\\cluster.isilon.anses.gov.ar\\ServicioDigitalizacion\\Digitalizacion\\sicasent\\2022\\12\\06\\817794_3.pdf";

        assertEquals(pathEsperado, ModoEjecucionUtil.obtenerNuevoPath(path, nombre));
    }
}