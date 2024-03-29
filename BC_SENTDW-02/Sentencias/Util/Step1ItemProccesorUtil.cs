using System.Collections.Generic;
using PruebaBatch01.Sentencias.DTO;

namespace PruebaBatch01.Sentencias.Util
{
    class Step1ItemProccesorUtil
    {
        public static void actualizarEdocumentos(List<EdocumentoOriginalDTO> edocumentos, List<EdocumentoOriginalDTO> edocumentosActualizados)
        {
            for (int i = 0; i < edocumentos.Count; i++)
            {
                string edocumentoId = edocumentos[i].getId().Trim();
                edocumentos[i] = ItemProccesorUtil.buscarEdocumentoPorId(edocumentoId, edocumentosActualizados);
            }
        }

        public static void agregarLoteActualizado(List<EdocumentoOriginalDTO> lote, List<EdocumentoOriginalDTO> edocumentosActualizados)
        {
            for (int i = 0; i < lote.Count; i++)
            {
                edocumentosActualizados.Add(lote[i]);
            }
        }
    }
}
