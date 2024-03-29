package ar.gov.anses.Sentencias.Model;

import ar.gov.anses.Sentencias.DTO.CuilDTO;
import ar.gov.anses.Sentencias.DTO.SentenciaDTO;
import ar.gov.anses.Sentencias.Util.NamespacesUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import javax.xml.datatype.XMLGregorianCalendar;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SentenciasModelImplTest {
    @Mock
    public SentenciasModel sentenciasModel;

    @Before
    public void setUp(){
        when(sentenciasModel.findSentenciasById(anyLong())).thenReturn(devolverUnaSentencia());
    }

    @Test
    public void DebePoderDevolverLosDatosDeUnaSentencia() throws Exception{
        Long sentenciaId = NamespacesUtil.toSentenciaId("256_IG.pdf");
        SentenciaDTO sentencia = sentenciasModel.findSentenciasById(sentenciaId);
        assertEquals(sentenciaId ,sentencia.getId());
        assertEquals("02424111111111150000001", sentencia.getExpedienteAdministrativo());
    }

    @Test
    public void DebePoderDevolverUnExpedienteAdministrativo() throws Exception{
        String expedienteAdminsitrativo = devolverUnExpedienteAdministrativo();
        assertEquals("02424111111111150000001", expedienteAdminsitrativo);
    }

    @Test
    public void DebePoderDevolverUnaSentenciaConExpedienteValido(){
        Long sentenciaId = NamespacesUtil.toSentenciaId("256_IG.pdf");
        SentenciaDTO sentencia = sentenciasModel.findSentenciasById(sentenciaId);
        String expedienteAdminsitrativo = devolverUnExpedienteAdministrativo();
        assertEquals(sentencia.getExpedienteAdministrativo(),expedienteAdminsitrativo);
    }

    @Test
    public void DebePoderDevolverUnExpedienteSinSecuencia(){
        Long sentenciaId = NamespacesUtil.toSentenciaId("256_IG.pdf");
        SentenciaDTO sentenciaDTO = sentenciasModel.findSentenciasById(sentenciaId);
        String expediente = NamespacesUtil.toExpedienteSinSecuencia(sentenciaDTO.getExpedienteAdministrativo());
        assertEquals("02424111111111150",expediente);
    }

    @Test
    public void DebePoderDevolverElUltimoDigitoDeLaSecuenciaDelExpediente(){
        Long sentenciaId = NamespacesUtil.toSentenciaId("256_IG.pdf");
        SentenciaDTO sentenciaDTO = sentenciasModel.findSentenciasById(sentenciaId);
        int secuencia = NamespacesUtil.extraerSecuencia(sentenciaDTO.getExpedienteAdministrativo());
        assertEquals(1,secuencia);
    }

    @Test
    public void DebePoderDevolverUnaFechaEnFormatoXmlGreogorianCalendar(){
        XMLGregorianCalendar fecha = NamespacesUtil.obtenerFechaIndexacion("2023-02-01 15:05:14.360");
    }

    private SentenciaDTO devolverUnaSentencia(){
        SentenciaDTO senteciaDTO = new SentenciaDTO();
        senteciaDTO.setId(256L);
        senteciaDTO.setExpedienteAdministrativo("02424111111111150000001");
        return senteciaDTO;
    }
    private String devolverUnExpedienteAdministrativo(){
        String entidad = "024";
        CuilDTO cuilDTO = new CuilDTO("24","11111111","1");
        String tramite = "150";
        int secuencia = 1;
        return NamespacesUtil.toExpedienteAdministrativo(entidad,cuilDTO,tramite,secuencia);

    }
}