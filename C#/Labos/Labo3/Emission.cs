using System.Text;

namespace Labo3 {

    public class Emission {
        protected string titre;
        protected int durée;

        public Emission(String titre, int durée) {
            this.titre = titre;
            this.durée = durée;
        }

        public virtual string Présentation() {
            StringBuilder output = new StringBuilder();
            output.Append(titre);
            output.Append(" (");
            output.Append(durée);
            output.Append(" minutes)");

            return output.ToString();
        }
    }
}