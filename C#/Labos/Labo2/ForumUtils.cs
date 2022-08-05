using System;
using System.Collections.Generic;
using System.Text;

namespace Labo2 {
    static class ForumUtils {

        public static string[] FORBIDDEN_LOGINS = new[] { "", "fart" };

        public static bool ValidLogin(string login) {
            int i = 0;
            while(i < FORBIDDEN_LOGINS.Length && login.ToLower() != FORBIDDEN_LOGINS[i].ToLower()) {
                i++;
            }
            return i == FORBIDDEN_LOGINS.Length;
        }


        public static void Count(string txt, out int spaceCount, out int digitCount) {
            spaceCount = 0;
            digitCount = 0;

            foreach (char carac in txt) {
                if (carac >= '0' && carac <= '9')
                    digitCount++;
                else {
                    if (carac == ' ')
                        spaceCount++;
                }
            }
        }

        public static void CountAndUpdate(string txt, ref int spaceCount, ref int digitCount){
            foreach (char carac in txt) {
                if (carac >= '0' && carac <= '9')
                    digitCount++;
                else {
                    if (carac == ' ')
                        spaceCount++;
                }
            }
        }
    }
}
