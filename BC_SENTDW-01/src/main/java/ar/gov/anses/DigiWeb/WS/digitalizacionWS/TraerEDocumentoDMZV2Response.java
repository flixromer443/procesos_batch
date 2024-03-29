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
 *         &lt;element name="TraerEDocumentoDMZV2Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}EDocumentoOriginal" minOccurs="0"/&gt;
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
    "traerEDocumentoDMZV2Result"
})
@XmlRootElement(name = "TraerEDocumentoDMZV2Response")
public class TraerEDocumentoDMZV2Response {

    @XmlElement(name = "TraerEDocumentoDMZV2Result")
    protected EDocumentoOriginal traerEDocumentoDMZV2Result;

    /**
     * Obtiene el valor de la propiedad traerEDocumentoDMZV2Result.
     * 
     * @return
     *     possible object is
     *     {@link EDocumentoOriginal }
     *     
     */
    public EDocumentoOriginal getTraerEDocumentoDMZV2Result() {
        return traerEDocumentoDMZV2Result;
    }

    /**
     * Define el valor de la propiedad traerEDocumentoDMZV2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link EDocumentoOriginal }
     *     
     */
    public void setTraerEDocumentoDMZV2Result(EDocumentoOriginal value) {
        this.traerEDocumentoDMZV2Result = value;
    }

}
