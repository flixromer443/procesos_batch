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
 *         &lt;element name="BuscarEDocumentosPorCodigoAnsesV2Result" type="{http://Anses.gov.ar/DigitalizacionServicios/}ArrayOfEDocumentoOriginal" minOccurs="0"/&gt;
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
    "buscarEDocumentosPorCodigoAnsesV2Result"
})
@XmlRootElement(name = "BuscarEDocumentosPorCodigoAnsesV2Response")
public class BuscarEDocumentosPorCodigoAnsesV2Response {

    @XmlElement(name = "BuscarEDocumentosPorCodigoAnsesV2Result")
    protected ArrayOfEDocumentoOriginal buscarEDocumentosPorCodigoAnsesV2Result;

    /**
     * Obtiene el valor de la propiedad buscarEDocumentosPorCodigoAnsesV2Result.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public ArrayOfEDocumentoOriginal getBuscarEDocumentosPorCodigoAnsesV2Result() {
        return buscarEDocumentosPorCodigoAnsesV2Result;
    }

    /**
     * Define el valor de la propiedad buscarEDocumentosPorCodigoAnsesV2Result.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEDocumentoOriginal }
     *     
     */
    public void setBuscarEDocumentosPorCodigoAnsesV2Result(ArrayOfEDocumentoOriginal value) {
        this.buscarEDocumentosPorCodigoAnsesV2Result = value;
    }

}
