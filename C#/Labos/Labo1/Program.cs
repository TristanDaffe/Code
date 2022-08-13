using System;

namespace Labo1 {
    class Program {
        static void Main(string[] args) {

            // Mise en place
            Player p = new Player("Indiana", "Jones", new DateTime(1899, 7, 1));
            Map canyon = new Map("canyon", 40, 80);
            Map forteresse = new Map("forteresse", 60, false);
            Map foret = new Map("forêt", 60, 50, false);
            Map desert = new Map("desert", 90, 90, true);
            Map oasis = new Map("oasis", 40, 45, false);
            Map caverne = new Map("cevarne", 30, 90, true);

            // Test
            AssertMaps("aucune", p);
            //Mise en place
            p.AddMap(canyon);
            // Test
            AssertMaps("Canyon", p);
            // Mise en place
            p.AddMap(forteresse);
            p.AddMap(foret);
            // Test
            AssertMaps("Forêt, Forteresse, Canyon", p);
            // Mise en place
            p.AddMap(forteresse);
            // Test
            AssertMaps("Forteresse, Forêt, Canyon", p);
            // Mise en place
            p.AddMap(desert);
            p.AddMap(oasis);
            // Test
            AssertMaps("Oasis, Desert, Forteresse, Forêt, Canyon", p);
            // Mise en place
            p.AddMap(foret);
            // Test
            AssertMaps("Forêt, Oasis, Desert, Forteresse, Canyon", p);
            // Mise en place
            p.AddMap(caverne);
            // Test
            AssertMaps("Caverne, Forêt, Oasis, Desert, Forteresse", p);

            Map test = new Map("desert", 10, 60, true);
            Map test2 = new Map("foret", 10, 60, false);

            test.Description();
            test2.Description();
            
        }
        public static void AssertMaps(string expected, Player p) {
            Console.WriteLine("Expected answer : " + expected);
            Console.WriteLine(p.ListingMaps());
        }
    }
}
