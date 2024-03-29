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
 *         &lt;element name="BuscarEDocumentosPorCodigoExternoV2Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumentoOriginal" minOccurs="0"/&gt;
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
    "buscarEDocumentosPorCodigoExternoV2Result"
})
@XmlRootElement(name = "BuscarEDocumentosPorCodigoExternoV2Response")
public class BuscarEDocumentosPorCodigoExternoV2Response {

    @XmlElement(name = "BuscarEDocumentosPorCodigoExternoV2Result")
    protected ArrayOfEDocumentoOriginal buscarEDocumentosPorCodigoExternoV2Result;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorCodigoExternoV2Result.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public ArrayOfEDocumentoOriginal getBuscarEDocumentosPorCodigoExternoV2Result() {
        return buscarEDocumentosPorCodigoExternoV2Result;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorCodigoExternoV2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public void setBuscarEDocumentosPorCodigoExternoV2Result(ArrayOfEDocumentoOriginal value) {
        this.buscarEDocumentosPorCodigoExternoV2Result = value;
    }

}
