using System.Collections.Generic;
using PruebaBatch01.Sentencias.DTO;

namespace PruebaBatch01.Sentencias.Util
{
    class ItemProccesorUtil
    {
        public static int determinarCapacidadPorLote(int hilos, int elementos)
        {
            return elementos / hilos + 1;
        }

        public static EdocumentoOriginalDTO buscarEdocumentoPorId(string edocumentoId, List<EdocumentoOriginalDTO> edocumentosActualizados)
        {
            for (int i = 0; i < edocumentosActualizados.Count; i++)
            {
                if (edocumentoId.Equals(edocumentosActualizados[i].getId().Trim()))
                {
                    return edocumentosActualizados[i];
                }
            }
            return null;
        }
    }
}
