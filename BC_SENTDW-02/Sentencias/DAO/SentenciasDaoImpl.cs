using System;
using System.Collections.Generic;
using Microsoft.Data.SqlClient;
using PruebaBatch01.Sentencias.DTO;
using Environment = PruebaBatch01.Config.Environment;


namespace PruebaBatch01.Sentencias.DAO
{
    class SentenciasDaoImpl
    {
        private readonly string query = "SELECT id, Beneficio_tit, CUIL_tit, Beneficio_caus, CUIL_caus, Expediente_administrativo FROM sentencias WHERE id = @ID";
        private SentenciaDTO findSentenciaById(long id, SqlConnection connection)
        {
            try
            {
                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@ID", id);
                SqlDataReader dataReader = command.ExecuteReader();
                SentenciaDTO sentencia = new SentenciaDTO();

                if (dataReader.HasRows)
                {
                    while (dataReader.Read())
                    {
                        sentencia.setId(dataReader.GetInt64(0));
                        sentencia.setBeneficioTitular(dataReader.GetInt64(1));
                        sentencia.setCuilTitular(dataReader.GetInt64(2));
                        //agregarBeneficioCuilCausante(sentencia, dataReader.GetInt64(3), dataReader.GetInt64(4));
                        sentencia.setExpedienteAdministrativo(dataReader.GetString(5).Trim());
                        return sentencia;
                    }
                }
                return sentencia;
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
                return new SentenciaDTO();
            }

        }

        public List<SentenciaDTO> findSentenciasByIds(List<long> ids)
        {

            SqlConnection connection = Environment.getSicasentDatasource();
            List<SentenciaDTO> sentencias = new List<SentenciaDTO>();

            foreach (long sentenciaId in ids)
            {
                connection.Open();
                SentenciaDTO sentencia = findSentenciaById(sentenciaId, connection);
                sentencias.Add(sentencia);
                connection.Close();

            }

            return sentencias;
        }


        private void agregarBeneficioCuilCausante(SentenciaDTO sentencia, long beneficioCaus, long cuilCaus)
        {
            if(beneficioCaus>0 && cuilCaus>0)
            {
                sentencia.setBeneficioCausante(beneficioCaus);
                sentencia.setCuitCausante(cuilCaus);
            }

        }
    }
}
