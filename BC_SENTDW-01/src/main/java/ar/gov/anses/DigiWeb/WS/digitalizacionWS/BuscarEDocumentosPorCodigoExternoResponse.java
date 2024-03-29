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
 *         &lt;element name="BuscarEDocumentosPorCodigoExternoResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumento" minOccurs="0"/&gt;
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
    "buscarEDocumentosPorCodigoExternoResult"
})
@XmlRootElement(name = "BuscarEDocumentosPorCodigoExternoResponse")
public class BuscarEDocumentosPorCodigoExternoResponse {

    @XmlElement(name = "BuscarEDocumentosPorCodigoExternoResult")
    protected ArrayOfEDocumento buscarEDocumentosPorCodigoExternoResult;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorCodigoExternoResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public ArrayOfEDocumento getBuscarEDocumentosPorCodigoExternoResult() {
        return buscarEDocumentosPorCodigoExternoResult;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorCodigoExternoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumento }
     *     
     */
    public void setBuscarEDocumentosPorCodigoExternoResult(ArrayOfEDocumento value) {
        this.buscarEDocumentosPorCodigoExternoResult = value;
    }

}
