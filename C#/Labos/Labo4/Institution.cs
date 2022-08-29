
namespace Labo4 {
    public class Institution {
        public string Nom { get; }
        public int CodPostal { get;  }

        public Institution(string nom, int codPostal) {
            Nom = nom;
            CodPostal = codPostal;
        }
    }
}