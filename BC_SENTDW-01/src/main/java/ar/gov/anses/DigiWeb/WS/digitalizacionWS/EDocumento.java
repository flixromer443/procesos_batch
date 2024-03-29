package ar.gov.anses.DigiWeb.WS.digitalizacionWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para EDocumento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EDocumento"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://microsoft.com/wsdl/types/}guid"/&gt;
 *         &lt;element name="CodigoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoEDocumentoId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EstadoEDocumentoId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Entidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PreCuil" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="NumeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DigitoVerificador" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/&gt;
 *         &lt;element name="TipoTramite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Secuencia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CodigoExterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Metadata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Ruta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaIndexacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Hash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDocumento", propOrder = {
    "id",
    "codigoSistema",
    "tipoEDocumentoId",
    "estadoEDocumentoId",
    "entidad",
    "preCuil",
    "numeroDocumento",
    "digitoVerificador",
    "tipoTramite",
    "secuencia",
    "codigoExterno",
    "metadata",
    "titulo",
    "descripcion",
    "nombre",
    "ruta",
    "fechaIndexacion",
    "hash"
})
public class EDocumento {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "CodigoSistema")
    protected String codigoSistema;
    @XmlElement(name = "TipoEDocumentoId")
    protected int tipoEDocumentoId;
    @XmlElement(name = "EstadoEDocumentoId")
    protected int estadoEDocumentoId;
    @XmlElement(name = "Entidad")
    protected String entidad;
    @XmlElement(name = "PreCuil", required = true, type = Short.class, nillable = true)
    @XmlSchemaType(name = "unsignedByte")
    protected Short preCuil;
    @XmlElement(name = "NumeroDocumento")
    protected String numeroDocumento;
    @XmlElement(name = "DigitoVerificador", required = true, type = Short.class, nillable = true)
    @XmlSchemaType(name = "unsignedByte")
    protected Short digitoVerificador;
    @XmlElement(name = "TipoTramite", required = true, type = Integer.class, nillable = true)
    protected Integer tipoTramite;
    @XmlElement(name = "Secuencia", required = true, type = Integer.class, nillable = true)
    protected Integer secuencia;
    @XmlElement(name = "CodigoExterno")
    protected String codigoExterno;
    @XmlElement(name = "Metadata")
    protected String metadata;
    @XmlElement(name = "Titulo")
    protected String titulo;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Ruta")
    protected String ruta;
    @XmlElement(name = "FechaIndexacion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaIndexacion;
    @XmlElement(name = "Hash")
    protected String hash;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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

    /**
     * Obtiene el valor de la propiedad tipoEDocumentoId.
     * 
     */
    public int getTipoEDocumentoId() {
        return tipoEDocumentoId;
    }

    /**
     * Define el valor de la propiedad tipoEDocumentoId.
     * 
     */
    public void setTipoEDocumentoId(int value) {
        this.tipoEDocumentoId = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEDocumentoId.
     * 
     */
    public int getEstadoEDocumentoId() {
        return estadoEDocumentoId;
    }

    /**
     * Define el valor de la propiedad estadoEDocumentoId.
     * 
     */
    public void setEstadoEDocumentoId(int value) {
        this.estadoEDocumentoId = value;
    }

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
     * Obtiene el valor de la propiedad preCuil.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getPreCuil() {
        return preCuil;
    }

    /**
     * Define el valor de la propiedad preCuil.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setPreCuil(Short value) {
        this.preCuil = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad digitoVerificador.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDigitoVerificador() {
        return digitoVerificador;
    }

    /**
     * Define el valor de la propiedad digitoVerificador.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDigitoVerificador(Short value) {
        this.digitoVerificador = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTramite.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Define el valor de la propiedad tipoTramite.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoTramite(Integer value) {
        this.tipoTramite = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSecuencia(Integer value) {
        this.secuencia = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoExterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoExterno() {
        return codigoExterno;
    }

    /**
     * Define el valor de la propiedad codigoExterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoExterno(String value) {
        this.codigoExterno = value;
    }

    /**
     * Obtiene el valor de la propiedad metadata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Define el valor de la propiedad metadata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadata(String value) {
        this.metadata = value;
    }

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad ruta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Define el valor de la propiedad ruta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuta(String value) {
        this.ruta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIndexacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaIndexacion() {
        return fechaIndexacion;
    }

    /**
     * Define el valor de la propiedad fechaIndexacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaIndexacion(XMLGregorianCalendar value) {
        this.fechaIndexacion = value;
    }

    /**
     * Obtiene el valor de la propiedad hash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHash() {
        return hash;
    }

    /**
     * Define el valor de la propiedad hash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHash(String value) {
        this.hash = value;
    }

}
