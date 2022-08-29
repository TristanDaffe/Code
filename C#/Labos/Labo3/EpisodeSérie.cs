using System.Text;

namespace Labo3 {

    public class EpisodeSérie : Emission {
        protected string titreSerie;
        protected int numEpisode;

        public EpisodeSérie(string titre, int durée, string titreSerie, int numEpisode) : base(titre, durée) {
            this.titreSerie = titreSerie;
            this.numEpisode = numEpisode;
        }

        public override string Présentation() {
            StringBuilder output = new StringBuilder();

            output.Append(titreSerie);
            output.Append(" : ");
            output.Append(base.Présentation());

            return output.ToString();
        }
    }
}