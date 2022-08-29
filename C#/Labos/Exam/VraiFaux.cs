using System.Text;

namespace Exam {
    class VraiFaux : Question {

        public override string Réponse { get; }

        public VraiFaux(string énoncé, int nbPoints, string réponse) : base(énoncé, nbPoints) {

            Réponse = réponse;
        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();

            output.Append(Enoncé);
            output.Append(Environment.NewLine);
            output.Append("o Vrai");
            output.Append(Environment.NewLine);
            output.Append("o Faux");
            
            return output.ToString();
        }
    }
}