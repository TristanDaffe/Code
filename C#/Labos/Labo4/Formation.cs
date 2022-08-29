
using System.Text;

namespace Labo4 {
    public class Formation {
        private int code;
        private string libelle;
        private Inscrit[] inscrits;
        private double prix;
        private bool sponsoriséRW;
        
        private const int NB_PLACES_MAX = 25;
        
        public double Prix {
            get {
                return prix;
            }
            set {
                if(value > 100 )
                    prix = value;
                else
                    prix = 100;
            }
        }
        public string Information {
            get {
                return code +" - "+ libelle + (sponsoriséRW ? " (RW)" : "");
            }
        }

        public int Code {
            get {
                return code;
            }
        }

        public Formation(int code, string libelle, double prix, bool  sponsoriséRW = true) {
            this.code = code;
            this.libelle = libelle;
            inscrits = new Inscrit[NB_PLACES_MAX];
            Prix = prix;
            this.sponsoriséRW = sponsoriséRW;
        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();
            
            output.AppendLine(Information);
            output.AppendLine(" ["+ inscrits.Length);
            output.Append(" inscrit(s)]");
            
            return output.ToString();
        }
    }
}