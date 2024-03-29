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
 *         &lt;element name="BuscarEDocumentosIdPorRutaResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfGuid" minOccurs="0"/&gt;
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
    "buscarEDocumentosIdPorRutaResult"
})
@XmlRootElement(name = "BuscarEDocumentosIdPorRutaResponse")
public class BuscarEDocumentosIdPorRutaResponse {

    @XmlElement(name = "BuscarEDocumentosIdPorRutaResult")
    protected ArrayOfGuid buscarEDocumentosIdPorRutaResult;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosIdPorRutaResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuid }
     *     
     */
    public ArrayOfGuid getBuscarEDocumentosIdPorRutaResult() {
        return buscarEDocumentosIdPorRutaResult;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosIdPorRutaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuid }
     *     
     */
    public void setBuscarEDocumentosIdPorRutaResult(ArrayOfGuid value) {
        this.buscarEDocumentosIdPorRutaResult = value;
    }

}
