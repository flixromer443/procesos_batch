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
 *         &lt;element name="BuscarEDocumentosPorCodigoAnsesResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumento" minOccurs="0"/&gt;
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
    "buscarEDocumentosPorCodigoAnsesResult"
})
@XmlRootElement(name = "BuscarEDocumentosPorCodigoAnsesResponse")
public class BuscarEDocumentosPorCodigoAnsesResponse {

    @XmlElement(name = "BuscarEDocumentosPorCodigoAnsesResult")
    protected ArrayOfEDocumento buscarEDocumentosPorCodigoAnsesResult;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorCodigoAnsesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public ArrayOfEDocumento getBuscarEDocumentosPorCodigoAnsesResult() {
        return buscarEDocumentosPorCodigoAnsesResult;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorCodigoAnsesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public void setBuscarEDocumentosPorCodigoAnsesResult(ArrayOfEDocumento value) {
        this.buscarEDocumentosPorCodigoAnsesResult = value;
    }

}
