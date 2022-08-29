using System.Text;

namespace Exam {

    public class Test {
        public const int NB_MAX_QUESTIONS = 15;
        
        private string intitulé;
        protected HashSet<Question> questions;
        
        public Test(string intitulé) {
            this.intitulé = intitulé;
            questions = new HashSet<Question>();
        }

        public void AjouteQuestions(params Question[] nouvelleQuestions) {
            foreach (Question question in nouvelleQuestions) {
                if (questions.Count < NB_MAX_QUESTIONS) {
                    questions.Add(question);
                }
            }
        }

        public int PointsTotaux() {
            return questions.Sum(question => question.NbPoints);
        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();

            output.Append(intitulé);
            output.Append(Environment.NewLine);

            foreach (Question question in questions) {
                output.Append(question);
                output.Append(Environment.NewLine);
                output.Append(Environment.NewLine);
            }
            
            return output.ToString();
        }
    }
}