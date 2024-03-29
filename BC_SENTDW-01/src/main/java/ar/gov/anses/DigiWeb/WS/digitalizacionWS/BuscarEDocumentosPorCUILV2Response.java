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
 *         &lt;element name="BuscarEDocumentosPorCUILV2Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumentoOriginal" minOccurs="0"/&gt;
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
    "buscarEDocumentosPorCUILV2Result"
})
@XmlRootElement(name = "BuscarEDocumentosPorCUILV2Response")
public class BuscarEDocumentosPorCUILV2Response {

    @XmlElement(name = "BuscarEDocumentosPorCUILV2Result")
    protected ArrayOfEDocumentoOriginal buscarEDocumentosPorCUILV2Result;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorCUILV2Result.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public ArrayOfEDocumentoOriginal getBuscarEDocumentosPorCUILV2Result() {
        return buscarEDocumentosPorCUILV2Result;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorCUILV2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public void setBuscarEDocumentosPorCUILV2Result(ArrayOfEDocumentoOriginal value) {
        this.buscarEDocumentosPorCUILV2Result = value;
    }

}
