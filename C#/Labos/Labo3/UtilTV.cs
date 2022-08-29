using System;

namespace Labo3 {
    public class UtilTV {

        public static void AfficheProgramme(params Emission[] emissiosn) {
                foreach (Emission emission in emissiosn)
                    Console.WriteLine(emission.Présentation());
        }

        public static void PrésenteDA(params DessinAnime[] das) {
            foreach (DessinAnime da in das) 
                Console.WriteLine(da.Présentation());
        }
    }
}