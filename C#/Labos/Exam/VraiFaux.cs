using System.Text;

namespace Exam {
    class VraiFaux : Question {
        private bool réponse;
        public override string Réponse {
            get {
                return réponse ? "vrai" : "faux";
            }
        }

        public VraiFaux(string énoncé, int nbPoints, bool réponse) : base(énoncé, nbPoints) {
            this.réponse = réponse;
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