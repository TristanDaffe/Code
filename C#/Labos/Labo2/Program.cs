using System;

namespace Labo2 {
    class Program {
        static void Main(string[] args) {

            User jean = new User("JeanBest", "1234", 20220101);
            User joe = new User("jeanBFF", "234", new DateTime(2019, 02, 01));
            

            Console.WriteLine(jean);
            Console.WriteLine(joe);

            joe.Login = "joeBest";
            Console.WriteLine(joe);

            TestValidLogin();

            joe.Login = "fart";
            Console.WriteLine(joe);

            User m = new User("Cunégonde", "motdepasse"); 
            string nom = m.Login; m.Login = "Hubert"; m.Login += "ine";
            Console.Write(m);

            joe.JoinDate = 20220601;
            Console.WriteLine(joe);

            Post post = new Post(jean, "First");
            post.AddLike(jean, joe, m );
            Console.WriteLine(post);

            User u = new User("Mélusine", "12345");
            // 0 post, 0 space, 0 digit
            Console.WriteLine(u);
            Post p1 = new Post(u, "Un deux trois");
            // 1 post, 2 spaces, 0 digit
            Console.WriteLine(u);
            Post p2 = new Post(u, "456");
            // 2 posts, 2 spaces, 3 digits
            Post p3 = new Post(u, "7 8 neuf !"); 
            // 3 posts, 5 spaces, 5 digits

            Console.WriteLine(u);

        }

        static void AssertBool(string test, bool expected, bool observed) {
            Console.WriteLine("Test: " + test);
            Console.WriteLine("Expected: " + expected + ", observed: " + observed); 
            Console.WriteLine(expected == observed ? "Ok!" : "KO !!!");
            Console.WriteLine(); 
        }
        static void TestValidLogin() {
            AssertBool("Herbert", true, ForumUtils.ValidLogin("Herbert"));
            AssertBool("empty string", false, ForumUtils.ValidLogin("")); 
            AssertBool("fart", false, ForumUtils.ValidLogin("fart")); 
            AssertBool("FART", false, ForumUtils.ValidLogin("FART")); 
            AssertBool("FaRt", false, ForumUtils.ValidLogin("FaRt")); 
        }
    }
}
