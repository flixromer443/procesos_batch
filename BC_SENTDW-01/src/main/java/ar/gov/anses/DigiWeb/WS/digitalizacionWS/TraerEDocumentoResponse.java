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
 *         &lt;element name="TraerEDocumentoResult" type="{http://Anses.gov.ar/DigitalizacionServicios/}EDocumento" minOccurs="0"/&gt;
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
    "traerEDocumentoResult"
})
@XmlRootElement(name = "TraerEDocumentoResponse")
public class TraerEDocumentoResponse {

    @XmlElement(name = "TraerEDocumentoResult")
    protected EDocumento traerEDocumentoResult;

    /**
     * Obtiene el valor de la propiedad traerEDocumentoResult.
     * 
     * @return
     *     possible object is
     *     {@link EDocumento }
     *     
     */
    public EDocumento getTraerEDocumentoResult() {
        return traerEDocumentoResult;
    }

    /**
     * Define el valor de la propiedad traerEDocumentoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link EDocumento }
     *     
     */
    public void setTraerEDocumentoResult(EDocumento value) {
        this.traerEDocumentoResult = value;
    }

}
