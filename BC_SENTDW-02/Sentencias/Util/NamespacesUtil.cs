using System;
using System.Text;
using PruebaBatch01.Sentencias.DTO;

namespace PruebaBatch01.Sentencias.Util
{
    class NamespacesUtil
    {
        public static long toSentenciaId(string nombreArchivo)
        {
            string[] miebros = nombreArchivo.Split("_");
            string senteciaId = miebros[0];
            return long.Parse(senteciaId);
        }

        public static string completarConcCeros(int num, int ceros)
        {
            string numero = num.ToString();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <= ceros; i++)
            {
                if (i == ceros)
                {
                    stringBuilder.Append(numero);
                }
                else
                {
                    stringBuilder.Append("0");
                }
            }
            return stringBuilder.ToString();

        }

        public static string toExpedienteAdministrativo(string entidad, CuilDTO cuilDTO, string tramite, int secuencia)
        {
            StringBuilder expedienteAdministrativo = new StringBuilder();
            expedienteAdministrativo.Append(entidad);
            expedienteAdministrativo.Append(cuilDTO.getCuil());
            expedienteAdministrativo.Append(tramite);
            expedienteAdministrativo.Append(completarConcCeros(secuencia, 5));
            return expedienteAdministrativo.ToString();
        }

        public static string toExpedienteSinSecuencia(string entidad, CuilDTO cuilDTO, int tramite)
        {
            StringBuilder expedienteAdministrativo = new StringBuilder();
            expedienteAdministrativo.Append(entidad);
            expedienteAdministrativo.Append(cuilDTO.getCuil());
            expedienteAdministrativo.Append(tramite.ToString());
            return expedienteAdministrativo.ToString();
        }

        public static string toExpedienteSinSecuencia(string entidad, string cuil, int tramite)
        {
            StringBuilder expedienteAdministrativo = new StringBuilder();
            expedienteAdministrativo.Append(entidad.ToString());
            expedienteAdministrativo.Append(cuil.ToString());
            expedienteAdministrativo.Append(tramite.ToString());
            return expedienteAdministrativo.ToString();
        }
        public static string toExpedienteSinSecuencia(string expediente)
        {
            return expediente.Substring(0, 17);
        }

        /*public static CuilDTO GenerarCuil(EdocumentoOriginalDTO eDocumentoOriginalDTO)
        {
            short precuil = eDocumentoOriginalDTO.getPreCuil();
            string numeroDocumento = eDocumentoOriginalDTO.getNumeroDocumento();
            short digitoVerificador = eDocumentoOriginalDTO.getDigitoVerificador();

            return new CuilDTO(precuil.ToString(), numeroDocumento, digitoVerificador.ToString());
        }*/
        public static string generarCuil(EdocumentoOriginalDTO eDocumentoOriginalDTO)
        {
            StringBuilder cuil = new StringBuilder();
            cuil.Append(eDocumentoOriginalDTO.getPreCuil());
            cuil.Append(eDocumentoOriginalDTO.getNumeroDocumento());
            cuil.Append(eDocumentoOriginalDTO.getDigitoVerificador());
            return cuil.ToString();
        }

        public static int extraerSecuencia(string secuencia)
        {
            string sec = secuencia[22].ToString();
            return int.Parse(sec);
        }


        public static string obtenerUrl(string raiz, string endPoint)
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.Append(raiz);
            stringBuilder.Append(endPoint);
            return stringBuilder.ToString();
        }

        public static EdocumentoOriginalDTO toEdocumentoOriginalDTO(string fila)
        {

            EdocumentoOriginalDTO edocumentoOriginalDTO = new EdocumentoOriginalDTO();
            string[] campos = fila.Split(",");

            edocumentoOriginalDTO.setId(campos[0]);
            edocumentoOriginalDTO.setCodigoSistema(campos[1]);
            edocumentoOriginalDTO.setTipoEDocumentoId(int.Parse(campos[2]));
            edocumentoOriginalDTO.setEstadoEDocumentoId(int.Parse(campos[3]));
            edocumentoOriginalDTO.setEntidad(campos[4]);
            edocumentoOriginalDTO.setPreCuil(short.Parse(campos[5]));
            edocumentoOriginalDTO.setNumeroDocumento(campos[6]);
            edocumentoOriginalDTO.setDigitoVerificador(short.Parse(campos[7]));
            if (campos[8].Length > 0 || campos[8] != "")
            {
                edocumentoOriginalDTO.setTipoTramite(int.Parse(campos[8].Trim()));
            }
            else
            {
                edocumentoOriginalDTO.setTipoTramite(0);
            }

            if (campos[9].Length > 0 || campos[9] != "")
            {
                edocumentoOriginalDTO.setSecuencia(int.Parse(campos[9]));
            }
            else
            {
                edocumentoOriginalDTO.setSecuencia(0);
            }
            edocumentoOriginalDTO.setCodigoExterno(campos[10]);
            edocumentoOriginalDTO.setMetadata(campos[11]);
            edocumentoOriginalDTO.setTitulo(campos[12]);
            edocumentoOriginalDTO.setDescripcion(campos[13]);
            edocumentoOriginalDTO.setNombre(campos[14]);
            edocumentoOriginalDTO.setRuta(campos[15]);

            DateTime fecha = DateTime.ParseExact(campos[16], "yyyy-MM-dd H:mm:ss.fff", null);
            //string fechaStr = fecha.ToString("yyyy-MM-dd H:mm:ss.fff");
            edocumentoOriginalDTO.setFechaIndexacion(fecha);
            return edocumentoOriginalDTO;
        }
    }
}
