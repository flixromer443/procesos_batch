using System.Collections.Generic;
using PruebaBatch01.Sentencias.DTO;

namespace PruebaBatch01.Sentencias.Util
{
    class GeneradorCargaUtil
    {
        public static List<long> extraerIdsSentencias(List<EdocumentoOriginalDTO> eDocumentos)
        {
            List<long> ids = new List<long>();
            for (int i = 0; i < eDocumentos.Count; i++)
            {
                ids.Add(NamespacesUtil.toSentenciaId(eDocumentos[i].getNombre()));
            }
            return ids;
        }

        public static SentenciaDTO buscarSentenciaPorId(long setenciasId, List<SentenciaDTO> sentencias)
        {
            for (int i = 0; i < sentencias.Count; i++)
            {
                if (setenciasId.Equals(sentencias[i].getId()))
                {
                    return sentencias[i];
                }
            }
            return new SentenciaDTO();
        }
        public static string generarExpedienteSinSecuencia(EdocumentoOriginalDTO edocumento)
        {
            string entidad = edocumento.getEntidad();
            string cuil = NamespacesUtil.generarCuil(edocumento);
            int tipotramite = edocumento.getTipoTramite();
            return NamespacesUtil.toExpedienteSinSecuencia(entidad, cuil, tipotramite);
        }
        public static string generarExpedienteSinSecuencia(string expedienteSentencia)
        {
            return NamespacesUtil.toExpedienteSinSecuencia(expedienteSentencia);
        }
    }
}
