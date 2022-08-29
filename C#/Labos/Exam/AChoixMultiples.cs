using System.Text;

namespace Exam {

    public class AChoixMultiples : Question {
        private HashSet<string> propositions;

        public override string Réponse { get; }
        
        public AChoixMultiples(string énoncé, int nbPoints, HashSet<string> propositions) : base(énoncé, nbPoints) {
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