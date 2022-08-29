
namespace Labo4 {
    public static class Utilitaire {
        
        public static bool GrandNamur(int codePostal) {
            return codePostal >= 5000 && codePostal <= 5999;
        }
        
        public static bool RegionWallone(int codePostal) {
            return (codePostal >= 1300 && codePostal <= 1499) || (codePostal >= 4000 && codePostal <= 7999);
        }
        
    }
}