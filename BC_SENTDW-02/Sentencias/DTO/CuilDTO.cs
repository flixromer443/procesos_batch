using System;
using System.Collections.Generic;
using System.Text;

namespace PruebaBatch01.Sentencias.DTO
{
    class CuilDTO
    {

        private string preCuil;
        private string docCuil;
        private string digCuil;
        private string cuil;

        public CuilDTO()
        {

        }

        public CuilDTO(string preCuil, string docCuil, string digCuil)
        {
            this.preCuil = preCuil;
            this.docCuil = docCuil;
            this.digCuil = digCuil;
        }

        

        public CuilDTO(string cuil)
        {
            cuil = eliminarGuiones(cuil);
            if (cuil != null)
            {
                try
                {
                    long.Parse(cuil.Substring(0, 2));
                    long.Parse(cuil.Substring(2, cuil.Length - 1));
                    long.Parse(cuil.Substring(cuil.Length - 1));

                    this.preCuil = cuil.Substring(0, 2);
                    this.docCuil = cuil.Substring(2, cuil.Length - 1);
                    this.digCuil = cuil.Substring(cuil.Length - 1);
                }
                catch (Exception e)
                {
                    throw new Exception("El valor " + cuil + " no es un CUIL valido.", e);
                }
            }
        }

        private string eliminarGuiones(string cuil)
        {
            if (cuil == null)
            {
                return null;
            }
            else if (cuil.IndexOf('-') == -1)
            {
                return cuil;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cuil.Length; i++)
            {
                if (cuil[i] != '-')
                {
                  sb.Append(cuil[i]);
                }
            }
            return sb.ToString();
        }

        public string getDigCuil()
        {
            return digCuil;
        }

        public void setDigCuil(string digCuil)
        {
            this.digCuil = digCuil;
        }

        public string getDocCuil()
        {
            return docCuil;
        }

        public void setDocCuil(string docCuil)
        {
            this.docCuil = docCuil;
        }

        public string getPreCuil()
        {
            return preCuil;
        }

        public void setPreCuil(string preCuil)
        {
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
        

        /**
         * Implementacion Dummy para que funcione con Xfire
         */
        public void setCuilLong(long cuilLong)
        {
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(this.preCuil);
            sb.Append("-");
            sb.Append(this.docCuil);
            sb.Append("-");
            sb.Append(this.digCuil);
            return sb.ToString();
        }


        public string getCuil()
        {
            if (cuil != null && preCuil != null || docCuil != null || digCuil != null)
                return preCuil + docCuil + digCuil;
            else
                return cuil;
        }

        public void setCuil(string cuil)
        {
            this.cuil = cuil;
        }

    }
}
