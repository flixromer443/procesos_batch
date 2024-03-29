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
 *         &lt;element name="ObtenerEDocumentoV3Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}RespuestaObtenerEDocumentoV3" minOccurs="0"/&gt;
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
    "obtenerEDocumentoV3Result"
})
@XmlRootElement(name = "ObtenerEDocumentoV3Response")
public class ObtenerEDocumentoV3Response {

    @XmlElement(name = "ObtenerEDocumentoV3Result")
    protected RespuestaObtenerEDocumentoV3 obtenerEDocumentoV3Result;

    /**
     * Obtiene el valor de la propiedad obtenerEDocumentoV3Result.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaObtenerEDocumentoV3 }
     *     
     */
    public RespuestaObtenerEDocumentoV3 getObtenerEDocumentoV3Result() {
        return obtenerEDocumentoV3Result;
    }

    /**
     * Define el valor de la propiedad obtenerEDocumentoV3Result.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaObtenerEDocumentoV3 }
     *     
     */
    public void setObtenerEDocumentoV3Result(RespuestaObtenerEDocumentoV3 value) {
        this.obtenerEDocumentoV3Result = value;
    }

}
