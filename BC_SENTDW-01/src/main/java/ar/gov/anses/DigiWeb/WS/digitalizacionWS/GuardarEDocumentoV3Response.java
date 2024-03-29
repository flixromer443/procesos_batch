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
 *         &lt;element name="GuardarEDocumentoV3Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}RespuestaGuardarEDocumentoV3" minOccurs="0"/&gt;
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
    "guardarEDocumentoV3Result"
})
@XmlRootElement(name = "GuardarEDocumentoV3Response")
public class GuardarEDocumentoV3Response {

    @XmlElement(name = "GuardarEDocumentoV3Result")
    protected RespuestaGuardarEDocumentoV3 guardarEDocumentoV3Result;

    /**
     * Obtiene el valor de la propiedad guardarEDocumentoV3Result.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaGuardarEDocumentoV3 }
     *     
     */
    public RespuestaGuardarEDocumentoV3 getGuardarEDocumentoV3Result() {
        return guardarEDocumentoV3Result;
    }

    /**
     * Define el valor de la propiedad guardarEDocumentoV3Result.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaGuardarEDocumentoV3 }
     *     
     */
    public void setGuardarEDocumentoV3Result(RespuestaGuardarEDocumentoV3 value) {
        this.guardarEDocumentoV3Result = value;
    }

}
