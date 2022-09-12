
using System.Text;

namespace Labo3 {

    public class Film : Emission {
        private string genre;

        public Film(string titre, int durée, string genre) : base(titre, durée) {
            this.genre = genre;
        }

        public override string Présentation() {
            StringBuilder output = new StringBuilder();

            output.Append(base.Présentation());
            output.Append(", ");
            output.Append(genre);

            return output.ToString();
        }
    }
}