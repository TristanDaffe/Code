
namespace Exam {
    public abstract class Question {
        
        public int NbPoints { get; }

        public abstract string Réponse { get;  }

        public string Enoncé { get; set; }

        public Question(string énoncé, int nbPoints) {
            Enoncé = énoncé;
            NbPoints = nbPoints;
        }

        public override string ToString() {
            return Enoncé;
        }
    }
}