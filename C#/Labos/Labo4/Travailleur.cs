
namespace Labo4 {
    public class Travailleur : Inscrit {
        private Institution institution;
        private string métier;

        public string Occupation {
            get {
                return métier +" "+ institution != null ? "chez"+ institution.Nom : "";
            }
        }

        public Travailleur(string nom, int codePostal, Formation formation, string métier, Institution institution) : base(nom, codePostal, formation) {
            this.métier = métier;
            this.institution = institution;
        }

        public override double PourcRéductionBase {
            get {
                if(institution == null || !Utilitaire.GrandNamur(institution.CodPostal)) 
                    return 0;
                return 0.2;
            }
        }
    }
}