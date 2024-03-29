package ar.gov.anses.DigiWeb.WS.digitalizacionWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfEDocumentoOriginal complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEDocumentoOriginal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EDocumentoOriginal" type="{http://Anses.gov.ar/DigitalizacionServicios/}EDocumentoOriginal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEDocumentoOriginal", propOrder = {
    "eDocumentoOriginal"
})
public class ArrayOfEDocumentoOriginal {

    @XmlElement(name = "EDocumentoOriginal", nillable = true)
    protected List<EDocumentoOriginal> eDocumentoOriginal;

    /**
     * Gets the value of the eDocumentoOriginal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eDocumentoOriginal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDocumentoOriginal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDocumentoOriginal }
     * 
     * 
     */
    public List<EDocumentoOriginal> getEDocumentoOriginal() {
        if (eDocumentoOriginal == null) {
            eDocumentoOriginal = new ArrayList<EDocumentoOriginal>();
        }
        return this.eDocumentoOriginal;
    }

}
