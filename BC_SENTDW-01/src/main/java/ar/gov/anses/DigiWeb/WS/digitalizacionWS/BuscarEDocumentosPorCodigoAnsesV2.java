package ar.gov.anses.DigiWeb.WS.digitalizacionWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="tramite" type="{http://Anses.gov.ar/DigitalizacionServicios/}CodigoAnsesV2" minOccurs="0"/&gt;
 *         &lt;element name="codigoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "tramite",
    "codigoSistema"
})
@XmlRootElement(name = "BuscarEDocumentosPorCodigoAnsesV2")
public class BuscarEDocumentosPorCodigoAnsesV2 {

    protected CodigoAnsesV2 tramite;
    protected String codigoSistema;

    /**
     * Obtiene el valor de la propiedad tramite.
     * 
     * @return
     *     possible object is
     *     {@link CodigoAnsesV2 }
     *     
     */
    public CodigoAnsesV2 getTramite() {
        return tramite;
    }

    /**
     * Define el valor de la propiedad tramite.
     * 
     * @param value
     *     allowed object is
     *     {@link CodigoAnsesV2 }
     *     
     */
    public void setTramite(CodigoAnsesV2 value) {
        this.tramite = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSistema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSistema() {
        return codigoSistema;
    }

    /**
     * Define el valor de la propiedad codigoSistema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSistema(String value) {
        this.codigoSistema = value;
    }

}
