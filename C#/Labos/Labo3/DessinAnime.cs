using System.Text;

namespace Labo3 {

    public class DessinAnime : EpisodeSérie {
        private int ageCible;

        public DessinAnime(string titre, int durée, string titreSerie, int numEpisode, int ageCible) : base(titre, durée, titreSerie, numEpisode) {
            this.ageCible = ageCible;
        }

        public new string Présentation() {
            StringBuilder outpute = new StringBuilder();

            outpute.Append("Enfants de ");
            outpute.Append(ageCible);
            outpute.Append(" ans : ");
            outpute.Append(titre);
            outpute.Append(" (");
            outpute.Append(titreSerie);
            outpute.Append(" numéro ");
            outpute.Append(numEpisode);
            outpute.Append(")");
            
            return outpute.ToString();
        }
    }
}