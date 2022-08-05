using System;
using System.Collections.Generic;
using System.Text;

namespace Labo1 {
    class Map {
        #region attributes
        private string name;
        private int verticalSize;
        private int horizontalSize;
        private bool authorizedInCompetition;
        #endregion

        #region constructors
        public Map(string name, int verticalSize, int horizontalSize, bool authorizedInCompetition) {
            this.name = name;
            this.verticalSize = verticalSize;
            this.horizontalSize = horizontalSize;
            this.authorizedInCompetition = authorizedInCompetition;
        }

        public Map(string name, int verticalSize, int horizontalSize) :
            this(name, verticalSize, horizontalSize, true) { }

        public Map(string name, int size, bool authorizedInCompetition) :
            this(name, size, size, authorizedInCompetition) { }
        #endregion

        public string GetName() {
            return name;
        }

        public int Surface() {
            return verticalSize * horizontalSize;
        }

        public void Description() {
           Console.Write(name + " (" + verticalSize + " X " + horizontalSize + ", surface " + Surface() + " cases )\n");

            if (authorizedInCompetition){
                Console.ForegroundColor = ConsoleColor.Blue;
                Console.Write("Utilisable en compétition");
            }
            else {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.Write("Pas utilisable en compétition");
            }
            Console.ForegroundColor = ConsoleColor.White;
            Console.Write("\n");
        }

        public override string ToString() {
            return name +" ("+ verticalSize +" X "+ horizontalSize +")";
        }
    }
}
