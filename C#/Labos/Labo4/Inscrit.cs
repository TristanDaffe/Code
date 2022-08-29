
using System.Text;

namespace Labo4 {
    public abstract class Inscrit {
        private string nom;
        private int codePostal;
        private Formation[] formations;
        private int nbFormations;
        private int iFormationPrincipale;

        public const int NB_MAX_FORMATIONS_SUIVIES = 5;

        public int FormationPrincipale {
            get {
                return formations[iFormationPrincipale].Code;
            }
            set {
                int i = Array.IndexOf(formations, formations.Where(f => f.Code == value));
                if (i != -1) {
                    iFormationPrincipale = i;
                }
            }
        }

        public abstract double PourcRéductionBase { get; }
        
        protected Inscrit(string nom, int codePostal, Formation formation) {
            this.nom = nom;
            this.codePostal = codePostal;
            formations = new Formation[NB_MAX_FORMATIONS_SUIVIES];
            
            if(formation == null)
                throw new Exception("Il faut une formation principale !");
            formations[0] = formation;
            iFormationPrincipale = 0;
            nbFormations = 0;
        }

        public void AjoutFormation(Formation formation, bool estPrincipal = false) {
            if (formations.Length < NB_MAX_FORMATIONS_SUIVIES) {
                
                formations[nbFormations] = formation;
                if(estPrincipal)
                    FormationPrincipale = nbFormations;
                
                nbFormations++;
            }
        }
        
        public double Cout(Formation formation) {
            return formation.Prix * (1 - PourcRéductionBase);
        }

        public double CoutTotal() {
            double cout = 0;
            for (int i = 0; i < nbFormations; i++) {
                cout += Cout(formations[i]);
            }
            return cout;
        }

        public string FicheInformations() {
            StringBuilder output = new StringBuilder();

            output.Append("Inscrit :");
            output.AppendLine(nom);
            output.AppendLine("(");
            output.AppendLine(codePostal.ToString());
            output.AppendLine(")");

            output.Append(Environment.NewLine);
            
            for(int i = 0; i < nbFormations; i++) {
                output.AppendLine(formations[i].Information);
            }
            
            output.AppendLine("Total à payer : ");
            output.AppendLine(CoutTotal().ToString("{0:0.00}"));
            output.AppendLine(" Euros");
            return output.ToString();
        }
        
        public override string ToString() {
            StringBuilder output = new StringBuilder();

            output.Append(nom);
            output.Append(" (");
            output.Append(codePostal);
            output.Append(")");
            
            return output.ToString();
        }
    }
}