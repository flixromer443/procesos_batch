using System.Collections.Generic;
using PruebaBatch01.Sentencias.DAO;
using PruebaBatch01.Sentencias.DTO;
namespace PruebaBatch01.Sentencias.Model
{
    class SentenciasModelImpl
    {
        private  SentenciasDaoImpl sentenciasDao = new SentenciasDaoImpl();

        public List<SentenciaDTO> findSentenciasByIds(List<long> setenciasIds)
        {
            return sentenciasDao.findSentenciasByIds(setenciasIds);
        }

    }
}
