using System;
using System.Collections.Generic;
using System.Text;

namespace PruebaBatch01.Sentencias.DTO
{
    class EdocumentoOriginalDTO
    {
        protected string id;
        protected string codigoSistema;
        protected int tipoEDocumentoId;
        protected int estadoEDocumentoId;
        protected string entidad;
        protected short preCuil;
        protected string numeroDocumento;
        protected short digitoVerificador;
        protected int tipoTramite;
        protected int secuencia;
        protected string codigoExterno;
        protected string metadata;
        protected string titulo;
        protected string descripcion;
        protected string nombre;
        protected string ruta;
        protected DateTime fechaIndexacion;

        /*********************************************************/

        protected int estadoProceso = 0;
        protected string estadoProcesoStr = "NO_PROCESADO";
        protected string fechaIndexacionStr;
        protected string tmpExpedienteAdministrativo;

        public int getEstadoProceso()
        {
            return estadoProceso;
        }

        public void setEstadoProceso(int estadoProceso)
        {
            this.estadoProceso = estadoProceso;
        }

        public string getEstadoProcesoStr()
        {
            return estadoProcesoStr;
        }

        public void setEstadoProcesoStr(string estadoProcesoStr)
        {
            this.estadoProcesoStr = estadoProcesoStr;
        }

        public string getFechaIndexacionStr()
        {
            return fechaIndexacionStr;
        }

        public void setFechaIndexacionStr(string fechaIndexacionStr)
        {
            this.fechaIndexacionStr = fechaIndexacionStr;
        }

        public string getTmpExpedienteAdministrativo()
        {
            return tmpExpedienteAdministrativo;
        }

        public void setTmpExpedienteAdministrativo(string tmpExpedienteAdministrativo)
        {
            this.tmpExpedienteAdministrativo = tmpExpedienteAdministrativo;
        }

        /*********************************************************/
        public string getId()
        {
            return id;
        }
        public void setId(string value)
        {
            this.id = value;
        }

        public string getCodigoSistema()
        {
            return codigoSistema;
        }
        public void setCodigoSistema(string value)
        {
            this.codigoSistema = value;
        }

        public int getTipoEDocumentoId()
        {
            return tipoEDocumentoId;
        }
        public void setTipoEDocumentoId(int value)
        {
            this.tipoEDocumentoId = value;
        }

        public int getEstadoEDocumentoId()
        {
            return estadoEDocumentoId;
        }
        public void setEstadoEDocumentoId(int value)
        {
            this.estadoEDocumentoId = value;
        }

        public string getEntidad()
        {
            return entidad;
        }
        public void setEntidad(string value)
        {
            this.entidad = value;
        }

        public short getPreCuil()
        {
            return preCuil;
        }
        public void setPreCuil(short value)
        {
            this.preCuil = value;
        }

        public string getNumeroDocumento()
        {
            return numeroDocumento;
        }
        public void setNumeroDocumento(string value)
        {
            this.numeroDocumento = value;
        }

        public short getDigitoVerificador()
        {
            return digitoVerificador;
        }
        public void setDigitoVerificador(short value)
        {
            this.digitoVerificador = value;
        }

        public int getTipoTramite()
        {
            return tipoTramite;
        }
        public void setTipoTramite(int value)
        {
            this.tipoTramite = value;
        }

        public int getSecuencia()
        {
            return secuencia;
        }
        public void setSecuencia(int value)
        {
            this.secuencia = value;
        }

        public string getCodigoExterno()
        {
            return codigoExterno;
        }
        public void setCodigoExterno(string value)
        {
            this.codigoExterno = value;
        }

        public string getMetadata()
        {
            return metadata;
        }
        public void setMetadata(string value)
        {
            this.metadata = value;
        }

        public string getTitulo()
        {
            return titulo;
        }
        public void setTitulo(string value)
        {
            this.titulo = value;
        }

        public string getDescripcion()
        {
            return descripcion;
        }
        public void setDescripcion(string value)
        {
            this.descripcion = value;
        }

        public string getNombre()
        {
            return nombre;
        }
        public void setNombre(string value)
        {
            this.nombre = value;
        }

        public string getRuta()
        {
            return ruta;
        }
        public void setRuta(string value)
        {
            this.ruta = value;
        }

        public DateTime getFechaIndexacion()
        {
            return fechaIndexacion;
        }
        public void setFechaIndexacion(DateTime value)
        {
            this.fechaIndexacion = value;
        }


    }
}
