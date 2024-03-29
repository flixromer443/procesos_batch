package ar.gov.anses.DigiWeb.WS.digitalizacionWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CodigoAnsesV2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CodigoAnsesV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Entidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreCUIL" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocumentoCUIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DigitoVerificador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TipoTramite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Secuencia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodigoAnsesV2", propOrder = {
    "entidad",
    "preCUIL",
    "documentoCUIL",
    "digitoVerificador",
    "tipoTramite",
    "secuencia"
})
public class CodigoAnsesV2 {

    @XmlElement(name = "Entidad")
    protected String entidad;
    @XmlElement(name = "PreCUIL")
    protected int preCUIL;
    @XmlElement(name = "DocumentoCUIL")
    protected String documentoCUIL;
    @XmlElement(name = "DigitoVerificador")
    protected int digitoVerificador;
    @XmlElement(name = "TipoTramite")
    protected int tipoTramite;
    @XmlElement(name = "Secuencia")
    protected int secuencia;

    /**
     * Obtiene el valor de la propiedad entidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * Define el valor de la propiedad entidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidad(String value) {
        this.entidad = value;
    }

    /**
     * Obtiene el valor de la propiedad preCUIL.
     * 
     */
    public int getPreCUIL() {
        return preCUIL;
    }

    /**
     * Define el valor de la propiedad preCUIL.
     * 
     */
    public void setPreCUIL(int value) {
        this.preCUIL = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoCUIL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentoCUIL() {
        return documentoCUIL;
    }

    /**
     * Define el valor de la propiedad documentoCUIL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentoCUIL(String value) {
        this.documentoCUIL = value;
    }

    /**
     * Obtiene el valor de la propiedad digitoVerificador.
     * 
     */
    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    /**
     * Define el valor de la propiedad digitoVerificador.
     * 
     */
    public void setDigitoVerificador(int value) {
        this.digitoVerificador = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTramite.
     * 
     */
    public int getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Define el valor de la propiedad tipoTramite.
     * 
     */
    public void setTipoTramite(int value) {
        this.tipoTramite = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencia.
     * 
     */
    public int getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     */
    public void setSecuencia(int value) {
        this.secuencia = value;
    }

}
