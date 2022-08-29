using System;

namespace Labo3 {
    class Program {
        static void Main(string[] args) {
            Emission emis1 = new Emission("1", 25);
            Emission emis2 = new Emission("2", 10);
            Emission emis3 = new Emission("3", 80);
            
            Film film1 = new Film("1f", 25, "sf");
            Film film2 = new Film("2f", 80, "null");
            Film film3 = new Film("3f", 210, "momance");
            
            UtilTV.AfficheProgramme(emis1, emis2, emis3, film1, film2, film3);

            Emission e1 = new Emission("Motus", 50);
            Emission e2 = new Emission("Des chiffres et des lettres", 45);
            Film f1 = new Film("Bilbo the Hobbit", 182, "fantastique");
            Film f2 = new Film("Le bon, la brute et le truand", 178, "western");
            EpisodeSérie s1 = new EpisodeSérie("Monsters", 47, "The Walking Dead", 801);
            EpisodeSérie s2 = new EpisodeSérie("The Interrogation", 52, "Designated Survivor", 6);
            DessinAnime da1 = new DessinAnime("Simprovised", 24, "Simpsons", 2721, 16);
            DessinAnime da2 = new DessinAnime("Droids in Distress", 22, "Star Wars Rebels", 3, 8);
            UtilTV.AfficheProgramme(e1, e2, e2, f1, f2, s1, s2, da1, da2);
            Console.WriteLine("....");
            UtilTV.PrésenteDA(da1, da2);
        }
    }
}