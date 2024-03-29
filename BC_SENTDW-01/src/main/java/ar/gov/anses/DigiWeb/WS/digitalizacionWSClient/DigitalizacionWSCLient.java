package ar.gov.anses.DigiWeb.WS.digitalizacionWSClient;

import ar.gov.anses.Sentencias.DTO.EDocumentoOriginalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ar.gov.anses.DigiWeb.WS.digitalizacionWS.*;


public class DigitalizacionWSCLient extends WebServiceGatewaySupport{

    public static final String URL_BASE_SERVICIO = "http://Anses.gov.ar/DigitalizacionServicios/";

    @Autowired
    private Environment environment;

    public void guardarEDocumentoV2(EDocumentoOriginalDTO documento) {
        GuardarEDocumentoV2 parametros = new GuardarEDocumentoV2();
        EDocumentoOriginal doc = DTOaDocumentoOriginal(documento);
        parametros.setDocumento(doc);
        try {
            getWebServiceTemplate().marshalSendAndReceive(environment.getProperty("digiweb.webservice"), parametros,
                    new SoapActionCallback(URL_BASE_SERVICIO + "GuardarEDocumentoV2"));
        } catch (java.lang.Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String calcularRutaSistema(java.lang.String codigoSistema) {
        CalcularRutaSistemaResponse response;
        CalcularRutaSistema parametros = new CalcularRutaSistema();
        parametros.setCodigoSistema(codigoSistema);
        try {
            response = (CalcularRutaSistemaResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(environment.getProperty("digiweb.webservice"), parametros,
                            new SoapActionCallback(URL_BASE_SERVICIO + "CalcularRutaSistema"));
            return response.getCalcularRutaSistemaResult();
        } catch (java.lang.Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<EDocumentoOriginalDTO> buscarEDocumentosPorCUILV2(int preCUIIL, String documentoCUIL,int digito, String codigoSistema) {
        BuscarEDocumentosPorCUILV2Response response;
        BuscarEDocumentosPorCUILV2 parametros = new BuscarEDocumentosPorCUILV2();
        parametros.setPreCUIIL(preCUIIL);
        parametros.setDocumentoCUIL(documentoCUIL);
        parametros.setDigito(digito);
        parametros.setCodigoSistema(codigoSistema);

        try {
            response = (BuscarEDocumentosPorCUILV2Response) getWebServiceTemplate()
                    .marshalSendAndReceive(environment.getProperty("digiweb.webservice"), parametros,
                            new SoapActionCallback(URL_BASE_SERVICIO + "BuscarEDocumentosPorCUILV2"));
            return crearListaEDocumentosOriginalDTO(response.getBuscarEDocumentosPorCUILV2Result().getEDocumentoOriginal());
        } catch (java.lang.Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void actualizarEDocumentoV2(EDocumentoOriginalDTO documento) {
        ActualizarEDocumentoV2 parametros = new ActualizarEDocumentoV2();
        parametros.setDocumento(DTOaDocumentoOriginal(documento));
        try {
            getWebServiceTemplate().marshalSendAndReceive(environment.getProperty("digiweb.webservice"), parametros,
                    new SoapActionCallback(URL_BASE_SERVICIO + "ActualizarEDocumentoV2"));
        } catch (java.lang.Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<EDocumentoOriginalDTO> crearListaEDocumentosOriginalDTO(List<EDocumentoOriginal> documentos) {
        return documentos.stream().map(this::docOriginalADTO).collect(Collectors.toList());
    }

    private EDocumentoOriginal DTOaDocumentoOriginal(EDocumentoOriginalDTO documento) {
        EDocumentoOriginal docOriginal = new EDocumentoOriginal();
        docOriginal.setId(documento.getId());
        docOriginal.setCodigoSistema(documento.getCodigoSistema());
        docOriginal.setTipoEDocumentoId(documento.getTipoEDocumentoId());
        docOriginal.setEstadoEDocumentoId(documento.getEstadoEDocumentoId());
        docOriginal.setEntidad(documento.getEntidad());
        docOriginal.setPreCuil(documento.getPreCuil());
        docOriginal.setNumeroDocumento(documento.getNumeroDocumento());
        docOriginal.setDigitoVerificador(documento.getDigitoVerificador());
        docOriginal.setTipoTramite(documento.getTipoTramite());
        docOriginal.setSecuencia(documento.getSecuencia());


        if(documento.getCodigoExterno()=="" || documento.getCodigoExterno().length()<1){
            docOriginal.setCodigoExterno(null);
        }else {
            docOriginal.setCodigoExterno(documento.getCodigoExterno());

        }

        if(documento.getMetadata()=="" || documento.getMetadata().length()<1){
            docOriginal.setMetadata(null);
        }else {
            docOriginal.setMetadata(documento.getMetadata());

        }

        if(documento.getTitulo()=="" || documento.getTitulo().length()<1){
            docOriginal.setTitulo(null);
        }else {
            docOriginal.setTitulo(documento.getTitulo());

        }

        if(documento.getDescripcion() == "" || documento.getDescripcion().length()<1){
            docOriginal.setDescripcion(null);
        }else {
            docOriginal.setDescripcion(documento.getDescripcion());

        }


        docOriginal.setNombre(documento.getNombre());
        docOriginal.setRuta(documento.getRuta());
        docOriginal.setFechaIndexacion(documento.getFechaIndexacion());
        return docOriginal;
    }


    private EDocumentoOriginalDTO docOriginalADTO(EDocumentoOriginal documento) {
        EDocumentoOriginalDTO docDTO = new EDocumentoOriginalDTO();
        docDTO.setId(documento.getId());
        docDTO.setCodigoSistema(documento.getCodigoSistema());
        docDTO.setTipoEDocumentoId(documento.getTipoEDocumentoId());
        docDTO.setEstadoEDocumentoId(documento.getEstadoEDocumentoId());
        docDTO.setEntidad(documento.getEntidad());
        docDTO.setPreCuil(documento.getPreCuil());
        docDTO.setNumeroDocumento(documento.getNumeroDocumento());
        docDTO.setDigitoVerificador(documento.getDigitoVerificador());
        docDTO.setTipoTramite(documento.getTipoTramite());
        docDTO.setSecuencia(documento.getSecuencia());
        docDTO.setCodigoExterno(documento.getCodigoExterno());
        docDTO.setMetadata(documento.getMetadata());
        docDTO.setTitulo(documento.getTitulo());
        docDTO.setDescripcion(documento.getDescripcion());
        docDTO.setNombre(documento.getNombre());
        docDTO.setRuta(documento.getRuta());
        docDTO.setFechaIndexacion(documento.getFechaIndexacion());
        return docDTO;
    }
}


