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
 *         &lt;element name="TraerEDocumentoDMZResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}EDocumento" minOccurs="0"/&gt;
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
    "traerEDocumentoDMZResult"
})
@XmlRootElement(name = "TraerEDocumentoDMZResponse")
public class TraerEDocumentoDMZResponse {

    @XmlElement(name = "TraerEDocumentoDMZResult")
    protected EDocumento traerEDocumentoDMZResult;

    /**
     * Obtiene el valor de la propiedad traerEDocumentoDMZResult.
     * 
     * @return
     *     possible object is
     *     {@link EDocumento }
     *     
     */
    public EDocumento getTraerEDocumentoDMZResult() {
        return traerEDocumentoDMZResult;
    }

    /**
     * Define el valor de la propiedad traerEDocumentoDMZResult.
     * 
     * @param value
     *     allowed object is
     *     {@link EDocumento }
     *     
     */
    public void setTraerEDocumentoDMZResult(EDocumento value) {
        this.traerEDocumentoDMZResult = value;
    }

}
