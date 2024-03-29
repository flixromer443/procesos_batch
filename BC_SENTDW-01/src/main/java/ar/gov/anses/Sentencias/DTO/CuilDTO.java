package ar.gov.anses.Sentencias.DTO;



import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;


@SuppressWarnings("serial")

@XmlType(namespace="http://sicasent.anses.gov.ar/")
public class CuilDTO implements Serializable {

    private static final String CUIL_MAL_FORMADO = "Mal formado el cuil";

    private String preCuil;
    private String docCuil;
    private String digCuil;
    private String cuil;

    public CuilDTO(){

    }

    public CuilDTO(String preCuil, String docCuil, String digCuil){
        this.preCuil = preCuil;
        this.docCuil = docCuil;
        this.digCuil = digCuil;
    }

    public CuilDTO(Long cuil){
        this(cuil.toString());
    }

    public CuilDTO(String cuil){
        cuil = eliminarGuiones(cuil);
        if( cuil != null ){
            try {
                Long.valueOf( cuil.substring(0, 2) );
                Long.valueOf( cuil.substring(2, cuil.length() - 1) );
                Long.valueOf( cuil.substring( cuil.length() - 1 ) );

                this.preCuil = cuil.substring(0, 2);
                this.docCuil = cuil.substring(2, cuil.length() - 1);
                this.digCuil = cuil.substring( cuil.length() - 1 );
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El valor " + cuil + " no es un CUIL valido.");
            }
        }
    }

    private String eliminarGuiones(String cuil){
        if( cuil == null ){
            return null;
        } else if(cuil.indexOf('-') == -1 ){
            return cuil;
        }

        StringBuilder out = new StringBuilder();
        for( int i = 0; i < cuil.length(); i++ ){
            if( cuil.charAt(i) != '-' ){
                out.append(cuil.charAt(i));
            }
        }
        return out.toString();
    }

    public String getDigCuil() {
        return digCuil;
    }

    public void setDigCuil(String digCuil) {
        this.digCuil = digCuil;
    }

    public String getDocCuil() {
        return docCuil;
    }

    public void setDocCuil(String docCuil) {
        this.docCuil = docCuil;
    }

    public String getPreCuil() {
        return preCuil;
    }

    public void setPreCuil(String preCuil) {
        this.preCuil = preCuil;
    }


    /**
     * @return
     *
     * Retonar el valor de preCuil + DocCuil + digCuil como Long
     * Si el valor de preCuil + DocCuil + digCuil no tiene coherencia
     * numerica devuelve null.
     *
     */
    public Long obtenerCuilLong(){
        StringBuffer cuil = new StringBuffer(this.preCuil);
        cuil.append(this.docCuil);
        cuil.append(this.digCuil);
        Long cuilLong = null;
        try {
            cuilLong = Long.valueOf(cuil.toString());
        } catch (NumberFormatException ex){
            throw new NumberFormatException(CUIL_MAL_FORMADO);
        }
        return cuilLong;
    }

    /**
     * Implementacion Dummy para que funcione con Xfire
     */
    public void setCuilLong(Long cuilLong) {
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof CuilDTO ){
            CuilDTO other = (CuilDTO)obj;
            if( this.preCuil != null && this.preCuil.equals(other.getPreCuil())){
                if( this.docCuil != null && this.docCuil.equals( other.getDocCuil() ) ){
                    if( this.digCuil != null && this.digCuil.equals( other.getDigCuil() ) ){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*@Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }*/

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.preCuil);
        out.append("-");
        out.append(this.docCuil);
        out.append("-");
        out.append(this.digCuil);
        return out.toString();
    }


    public String getCuil() {
        if(cuil!=null && preCuil!=null || docCuil!=null || digCuil!=null )
            return preCuil+docCuil+digCuil;
        else
            return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
}

