package ar.gov.anses.Sentencias.Carga;

import ar.gov.anses.Sentencias.Constantes;
import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import ar.gov.anses.Sentencias.DTO.SentenciaDTO;
import ar.gov.anses.Sentencias.Model.SentenciasModelImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GeneradorCargaTramiteImplTest {

    @Mock
    private SentenciasModelImpl sentenciasModel;

    @InjectMocks
    private GeneradorCargaTramiteImpl generadorCargaTramite;

    @Before
    public void setUp(){
        when(sentenciasModel.findSentenciasById(27L)).thenReturn(devolverUnaSentenciaQueNoCoincidaConElTipoDeTramiteDelEdocumentoYseaGrabableAlaPrimera());
        when(sentenciasModel.findSentenciasById(26L)).thenReturn(devolverUnaSentenciaQueNoCoincidaConElTipoDeTramiteDelEdocumento());
        when(sentenciasModel.findSentenciasById(25L)).thenReturn(devolverUnaSentenciaQueContengaElCuilDelCausanteEnElExpediente());
        when(sentenciasModel.findSentenciasById(24L)).thenReturn(devolverUnaSentenciaQueCoincidanLosExpedientes());
        when(sentenciasModel.findSentenciasById(23L)).thenReturn(devolverUnaSentenciaQueNoCoincidanLosExpedientes());
        when(sentenciasModel.findSentenciasById(22L)).thenReturn(null);
    }

    @Test
    public void debePoderDevolverUnEdocumentoConSecuenciaActualizadaYEstadoProceso1() {
        EDocumentoOriginalDTO eDocumentoActualizado = generadorCargaTramite.generarCarga(devolverUnEdocumentoValidoDelArchivoDeEntrada());
        assertEquals(Integer.valueOf(1),eDocumentoActualizado.getSecuencia());
        assertEquals(Constantes.CARGA_GENERADA,eDocumentoActualizado.getEstadoProceso());
    }

    @Test
    public void debePoderDevolverUnEdocumentoQueNoCoincidaConElExpedienteDeSentenciasYhayaSidoReacondicionado() {
        EDocumentoOriginalDTO eDocumentoActualizado = generadorCargaTramite.generarCarga(devolverUnEdocumentoNoValidoDelArchivoDeEntrada());
        assertEquals(Integer.valueOf(1), eDocumentoActualizado.getSecuencia());
        assertEquals(Constantes.CARGA_GENERADA, eDocumentoActualizado.getEstadoProceso());
    }

    @Test
    public void noDebePoderDebePoderEncontrarLaSentenciaParaElEdocumento(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = generadorCargaTramite.generarCarga(devolverUnEdocumentoSinSentencia());
        assertEquals(Short.valueOf("20"),eDocumentoOriginalDTO.getPreCuil());
        assertEquals("48000002",eDocumentoOriginalDTO.getNumeroDocumento());
        assertEquals(Short.valueOf("1"),eDocumentoOriginalDTO.getDigitoVerificador());
        assertEquals(null, eDocumentoOriginalDTO.getSecuencia());
        assertEquals(Constantes.NO_PROCESADO, eDocumentoOriginalDTO.getEstadoProceso());
    }

    @Test
    public void debePoderSetearElCuilDelCausanteTraidoDelExpedienteDeSentencias(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = generadorCargaTramite.generarCarga(devolverUnEdocumentoQueContengaElCuilDelTitular());
        assertEquals(Short.valueOf("20"),eDocumentoOriginalDTO.getPreCuil());
        assertEquals("48000002",eDocumentoOriginalDTO.getNumeroDocumento());
        assertEquals(Short.valueOf("7"),eDocumentoOriginalDTO.getDigitoVerificador());
        assertEquals(Integer.valueOf(1), eDocumentoOriginalDTO.getSecuencia());
        assertEquals(Constantes.CARGA_GENERADA, eDocumentoOriginalDTO.getEstadoProceso());
    }

    @Test
    public void noDebePoderSetearElCuilDelCausanteTraidoDelExpedienteDeSentencias(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = generadorCargaTramite.generarCarga(devolverUnEdocumentoQueContengaElCuilDelTitularYtipoTramite155());
        assertEquals(null, eDocumentoOriginalDTO.getSecuencia());
        assertEquals(Constantes.NO_PROCESADO, eDocumentoOriginalDTO.getEstadoProceso());
    }

    @Test
    public void debePoderSetearElTipoDeTramiteTraidoDelExpedienteDeSentenciasYSerGrabadoAlaPrimera(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = generadorCargaTramite.generarCarga(devolverUnEdocumentoQueContengaElCuilDelTitularYtipoTramite232());
        assertEquals(Integer.valueOf(150),eDocumentoOriginalDTO.getTipoTramite());
        assertEquals(Integer.valueOf(1), eDocumentoOriginalDTO.getSecuencia());
        assertEquals(Constantes.CARGA_GENERADA, eDocumentoOriginalDTO.getEstadoProceso());
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoValidoDelArchivoDeEntrada(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("48000002");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("2"));
        eDocumentoOriginalDTO.setTipoTramite(150);
        eDocumentoOriginalDTO.setNombre("24_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoNoValidoDelArchivoDeEntrada(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("48000002");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("2"));
        eDocumentoOriginalDTO.setTipoTramite(232);
        eDocumentoOriginalDTO.setNombre("23_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoSinSentencia(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("48000002");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("1"));
        eDocumentoOriginalDTO.setTipoTramite(150);
        eDocumentoOriginalDTO.setNombre("22_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoQueContengaElCuilDelTitular(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("06073545");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("0"));
        eDocumentoOriginalDTO.setTipoTramite(150);
        eDocumentoOriginalDTO.setNombre("25_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoQueContengaElCuilDelTitularYtipoTramite155(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("06073545");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("0"));
        eDocumentoOriginalDTO.setTipoTramite(155);
        eDocumentoOriginalDTO.setNombre("26_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private EDocumentoOriginalDTO devolverUnEdocumentoQueContengaElCuilDelTitularYtipoTramite232(){
        EDocumentoOriginalDTO eDocumentoOriginalDTO = new EDocumentoOriginalDTO();
        eDocumentoOriginalDTO.setId("5D6D66CE-791E-43D4-BAB7-96769C58B3D2");
        eDocumentoOriginalDTO.setCodigoSistema("sicasent");
        eDocumentoOriginalDTO.setTipoEDocumentoId(17);
        eDocumentoOriginalDTO.setEstadoEDocumentoId(102);
        eDocumentoOriginalDTO.setEntidad("024");
        eDocumentoOriginalDTO.setPreCuil(Short.valueOf("20"));
        eDocumentoOriginalDTO.setNumeroDocumento("06073545");
        eDocumentoOriginalDTO.setDigitoVerificador(Short.valueOf("0"));
        eDocumentoOriginalDTO.setTipoTramite(232);
        eDocumentoOriginalDTO.setNombre("27_3.pdf");
        eDocumentoOriginalDTO.setRuta("\\ANSESDIGI\\ARQNAS\\PDFs\\sicasent\\2023\\02\\01");

        return eDocumentoOriginalDTO;
    }

    private SentenciaDTO devolverUnaSentenciaQueCoincidanLosExpedientes(){
        SentenciaDTO sentenciaDTO = new SentenciaDTO();
        sentenciaDTO.setId(24L);
        sentenciaDTO.setBeneficioTitular(1075500020L);
        sentenciaDTO.setCuilTitular(20480000022L);
        sentenciaDTO.setExpedienteAdministrativo("02420480000022150000001");

        return sentenciaDTO;
    }

    private SentenciaDTO devolverUnaSentenciaQueNoCoincidanLosExpedientes(){
        SentenciaDTO sentenciaDTO = new SentenciaDTO();
        sentenciaDTO.setId(23L);
        sentenciaDTO.setBeneficioTitular(1075500020L);
        sentenciaDTO.setCuilTitular(20480000022L);
        sentenciaDTO.setExpedienteAdministrativo("02420480000027150000001");

        return sentenciaDTO;
    }


    private SentenciaDTO devolverUnaSentenciaQueContengaElCuilDelCausanteEnElExpediente(){
        SentenciaDTO sentenciaDTO = new SentenciaDTO();
        sentenciaDTO.setId(25L);
        sentenciaDTO.setBeneficioTitular(1075500020L);
        sentenciaDTO.setCuilTitular(20480000022L);
        sentenciaDTO.setExpedienteAdministrativo("02420480000027150000001");

        return sentenciaDTO;
    }

    private SentenciaDTO devolverUnaSentenciaQueNoCoincidaConElTipoDeTramiteDelEdocumento(){
        SentenciaDTO sentenciaDTO = new SentenciaDTO();
        sentenciaDTO.setId(26L);
        sentenciaDTO.setBeneficioTitular(1075500020L);
        sentenciaDTO.setCuilTitular(20480000022L);
        sentenciaDTO.setExpedienteAdministrativo("02420480000027151000001");

        return sentenciaDTO;
    }

    private SentenciaDTO devolverUnaSentenciaQueNoCoincidaConElTipoDeTramiteDelEdocumentoYseaGrabableAlaPrimera(){
        SentenciaDTO sentenciaDTO = new SentenciaDTO();
        sentenciaDTO.setId(27L);
        sentenciaDTO.setBeneficioTitular(1075500020L);
        sentenciaDTO.setCuilTitular(20060735450L);
        sentenciaDTO.setExpedienteAdministrativo("02420060735450150000001");

        return sentenciaDTO;
    }
}