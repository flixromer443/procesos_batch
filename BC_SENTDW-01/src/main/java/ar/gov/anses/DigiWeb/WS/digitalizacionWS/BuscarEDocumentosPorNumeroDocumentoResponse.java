package ar.gov.anses.DigiWeb.WS.digitalizacionWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BuscarEDocumentosPorNumeroDocumentoResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumento" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "buscarEDocumentosPorNumeroDocumentoResult"
})
@XmlRootElement(name = "BuscarEDocumentosPorNumeroDocumentoResponse")
public class BuscarEDocumentosPorNumeroDocumentoResponse {

    @XmlElement(name = "BuscarEDocumentosPorNumeroDocumentoResult")
    protected ArrayOfEDocumento buscarEDocumentosPorNumeroDocumentoResult;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorNumeroDocumentoResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public ArrayOfEDocumento getBuscarEDocumentosPorNumeroDocumentoResult() {
        return buscarEDocumentosPorNumeroDocumentoResult;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorNumeroDocumentoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public void setBuscarEDocumentosPorNumeroDocumentoResult(ArrayOfEDocumento value) {
        this.buscarEDocumentosPorNumeroDocumentoResult = value;
    }

}
