
namespace Labo4 {
    public class Chomeur : Inscrit {
        private int numONEM;
        private double pourcentageReduc;
        
        public Chomeur(string nom, int codePostal, int numONEM, Formation formation) : base(nom, codePostal, formation) {
            this.numONEM = numONEM;
            pourcentageReduc = 1;
        }

        public override double PourcRéductionBase {
            get {
                return pourcentageReduc;
            }
        }
    }
}