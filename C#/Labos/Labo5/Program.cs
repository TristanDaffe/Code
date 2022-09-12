namespace Labo5 {
    static class Program {
        public static void Main(string[] args) {
            Todo todo = new Todo();
            Console.WriteLine("Ajout de 111, 222, 333, 444, 555, 666");
            todo.Ajoute(111);
            todo.Ajoute(222);
            todo.Ajoute(333);
            todo.Ajoute(444);
            todo.Ajoute(555);
            todo.Ajoute(666);
            Console.WriteLine("Lecture : " + todo.AppelLu());
            Console.WriteLine("Lecture : " + todo.AppelLu());
            Console.WriteLine("Ajout de 999");
            todo.Ajoute(999);
            while (!todo.EstVide()) {
                Console.WriteLine("Lecture : " + todo.AppelLu());
            }
        }
    }
}