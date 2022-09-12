namespace Labo5 {
    class Todo {
        static private readonly int INCRÉMENT = 5;
        private int[] appels;
        private int nbAppels;

        public Todo() {
            appels = new int[INCRÉMENT];
            nbAppels = 0;
        }

        public bool EstVide() {
            return nbAppels == 0;
        }

        public void Ajoute(int appel) {
            if (nbAppels >= appels.Length) {
                int[] nvAppels = new int[appels.Length + INCRÉMENT];
                for (int i = 0; i < nbAppels; i++) {
                    nvAppels[i] = appels[i];
                }
                appels = nvAppels;
            }
            appels[nbAppels] = appel;
            nbAppels++;
        } 
        // Précondition : on n'appelle AppelLu que
        // dans le cas où le Todo n'est pas vide !
        public int AppelLu() {
            int résultat = appels[0];
            int i = 1;
            while (i < nbAppels) {
                appels[i - 1] = appels[i];
                i++;
            }

            nbAppels--;
            return résultat;
        }
    }
}