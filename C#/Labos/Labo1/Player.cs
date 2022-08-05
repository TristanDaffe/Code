using System;
using System.Collections.Generic;
using System.Text;

namespace Labo1 {
    class Player {
        public const int NB_MAX_MAPS = 5;

        #region attributes
        private string firstName;
        private string lastName;
        private DateTime birthday;
        private int skillRating;
        private bool sponsored;
        private Map[] maps;
        #endregion

        #region constructors
        public Player(string firstName, string lastName, DateTime birthday, bool isRanked){
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            skillRating = isRanked ? 1 : 0;
            sponsored = false;
            maps = new Map[NB_MAX_MAPS];
        }

        public Player(string firstName, string lastName, DateTime birthday) :
        this(firstName, lastName, birthday, true) { }
        #endregion

        public string GetName() {
            return lastName + " " + firstName;
        }

        public string GetBirthDate() {
            return birthday.Day + "/" + birthday.Month + "/" + birthday.Year;
        }

        public void setRanked() {
            if (!isRanked())
                skillRating = 1;
        }

        private bool isRanked() {
            return skillRating != 0;
        }

        public void ModifySkillRating(int points) {
            if (isRanked()) {
                skillRating += points;

                if (skillRating > 5000)
                    skillRating = 5000;
                else {
                    if (skillRating < 1)
                        skillRating = 1;
                }
            }
        }

        public void AddMap(Map map) {
            Map mapPrec = map;
            int i = 0;
            do {
                Map mapActual = maps[i];
                maps[i] = mapPrec;
                mapPrec = mapActual;
                i++;
            } while (i < NB_MAX_MAPS && mapPrec != map);
        }

        public string ListingMaps() {
            int i = 1;
            string output = "";

            foreach (Map map in maps) {
                output += i + " - " + map + "\n";
                i++;
            }
            return output;
        }

        public override string ToString() {
            string output = "";

            output += "Nom et prénom :" + GetName();
            output += "\nDate de naissance : " + GetBirthDate();
            output += "\n"+ (isRanked() ? "Compétiteur" : "Non compétiteur");
            output += "\n";
            output += ListingMaps();

            return output;
        }
    }
}
