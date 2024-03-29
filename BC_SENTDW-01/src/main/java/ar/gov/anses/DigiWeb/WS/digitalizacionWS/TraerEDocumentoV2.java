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
 *         &lt;element name="documentoId" type="{http://microsoft.com/wsdl/types/}guid"/&gt;
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
    "documentoId"
})
@XmlRootElement(name = "TraerEDocumentoV2")
public class TraerEDocumentoV2 {

    @XmlElement(required = true)
    protected String documentoId;

    /**
     * Obtiene el valor de la propiedad documentoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoId() {
        return documentoId;
    }

    /**
     * Define el valor de la propiedad documentoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoId(String value) {
        this.documentoId = value;
    }

}
