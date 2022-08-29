namespace Exam {

    public class TestCloturé : Test {
        readonly DateTime dateCloture;
        private double résultatObtenu;

        public TestCloturé(string intitulé, DateTime dateCloture) : base(intitulé) {
            this.dateCloture = dateCloture;
        }

        public int PointObtenu(string[] réponses) {
            int résultat = 0;

            int i = 0;
            foreach (Question question in questions) {
                
                if (question.Réponse == réponses[i]) {
                    résultat += question.NbPoints;
                }
                i++;
            }

            return résultat;
        }

        public double PourcObtenu(string[] réponse) {
            return (double)PointObtenu(réponse) / PointsTotaux() * 100;
        }
    }
}