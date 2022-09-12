
namespace Exam {
    public static class Program {
        public static void Main(string[] args) {
            string[] a = {"un", "deux", "trois"};
            AChoixMultiples test = new AChoixMultiples("énoncé", 10,'a', new HashSet<string>(a));
            AChoixMultiples test2 = new AChoixMultiples("noncé", 20,'a', new HashSet<string>(a));

            VraiFaux vf = new VraiFaux("eee", 1, true);
            
            Console.WriteLine(test);
            Console.WriteLine(test2);
            Console.WriteLine(vf);

            Test t = new Test("test");
            t.AjouteQuestions(test, test2, vf);
            /*
            Console.Write(t);
            Console.Write(t.PointsTotaux());
*/
            TestCloturé tc = new TestCloturé("testt", DateTime.Now);
            tc.AjouteQuestions(test, test2, vf);
            Console.WriteLine(tc.PourcObtenu(new string[] {"v", "a", "vrai"}));

        }
    }
}