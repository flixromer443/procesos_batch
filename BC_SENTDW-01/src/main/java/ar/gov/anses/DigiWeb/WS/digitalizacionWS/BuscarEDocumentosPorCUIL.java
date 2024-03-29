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
 *         &lt;element name="preCUIIL" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="documentoCUIL" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="digito" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "preCUIIL",
    "documentoCUIL",
    "digito",
    "codigoSistema"
})
@XmlRootElement(name = "BuscarEDocumentosPorCUIL")
public class BuscarEDocumentosPorCUIL {

    protected int preCUIIL;
    protected int documentoCUIL;
    protected int digito;
    protected String codigoSistema;

    /**
     * Obtiene el valor de la propiedad preCUIIL.
     * 
     */
    public int getPreCUIIL() {
        return preCUIIL;
    }

    /**
     * Define el valor de la propiedad preCUIIL.
     * 
     */
    public void setPreCUIIL(int value) {
        this.preCUIIL = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoCUIL.
     * 
     */
    public int getDocumentoCUIL() {
        return documentoCUIL;
    }

    /**
     * Define el valor de la propiedad documentoCUIL.
     * 
     */
    public void setDocumentoCUIL(int value) {
        this.documentoCUIL = value;
    }

    /**
     * Obtiene el valor de la propiedad digito.
     * 
     */
    public int getDigito() {
        return digito;
    }

    /**
     * Define el valor de la propiedad digito.
     * 
     */
    public void setDigito(int value) {
        this.digito = value;
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
