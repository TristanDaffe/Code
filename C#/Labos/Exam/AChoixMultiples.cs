using System.Text;

namespace Exam {

    public class AChoixMultiples : Question {
        private char réponse;
        private HashSet<string> propositions;

        public override string Réponse {
            get {
                return réponse.ToString();
            }
        }

        public AChoixMultiples(string énoncé, int nbPoints, char réponse, HashSet<string> propositions) : base(énoncé, nbPoints) {
            this.réponse = réponse;
            this.propositions = propositions;
        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();

            output.Append(Enoncé);
            output.Append(Environment.NewLine);
            char lettre = 'a';
            foreach (string proposition in propositions) {
                output.Append(lettre);
                output.Append(") ");
                output.Append(proposition);
                output.Append(Environment.NewLine);
                lettre++;
            }
            
            return output.ToString();
        }
    }
}