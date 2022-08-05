using System;
using System.Collections.Generic;
using System.Text;

namespace Labo2 {
    class Post {
        public const int INC_LIKEDBY_SIZE = 3;

        #region attributes
        private User author;
        private string content;
        private DateTime date;
        private User[] likedBy;
        private int nbLike;
        #endregion

        #region constructors
        public Post(User author, string content, DateTime date) {
            this.author = author;
            this.content = content;
            this.date = date;
            nbLike = 0;
            likedBy = new User[INC_LIKEDBY_SIZE]; 

            author.AddPost(this);
        }
        public Post(User author, string content) :
            this(author, content, DateTime.Today) { }

        #endregion

        public string Content {
            get {
                return content;
            }
        }

        public void AddLike(User user) {
            //plus de place dans le tableau
            if (nbLike % INC_LIKEDBY_SIZE == 0) { 
                //nouveau tableau + grand
                User[] newLikeBy = new User[likedBy.Length + INC_LIKEDBY_SIZE];
                //recopie le tableau
                for (int i = 0; i < likedBy.Length; i++)
                    newLikeBy[i] = likedBy[i];
                //change la référence de likedBy
                likedBy = newLikeBy;
            }
            //ajoute le like
            likedBy[nbLike] = user;
            nbLike++;
        }
        public void AddLike(params User[] users) {
            if(users.Length > nbLike % INC_LIKEDBY_SIZE) {
                //agrandi le tableau de like en conséquence
                User[] newLikeBy = new User[likedBy.Length + users.Length  + INC_LIKEDBY_SIZE];
                //recopie le tableau
                for (int i = 0; i < likedBy.Length; i++)
                    newLikeBy[i] = likedBy[i];
            }
            foreach (User user in users)
                AddLike(user);
        }

        public void RemoveLike(User user) {
            //cherche le user
            int i = 0;
            while (i < likedBy.Length && likedBy[i].Login != user.Login)
                i++;

            //regarde si user avait like
            if(i != likedBy.Length) {
                //décallage vers la gauche de toute les cellules après le user à delete
                int j = 0;
                while(j < likedBy.Length-1) {
                    likedBy[j] = likedBy[j + 1];
                }
                nbLike--;
            }
        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();
            output.Append(author.Login);
            output.Append(" - ");
            output.Append(content);

            output.Append(Environment.NewLine);
            for(int i = 0; i < nbLike; i++) {
                output.Append("- ");
                output.Append(likedBy[i].Login);
                output.Append(Environment.NewLine);
            }
            return output.ToString();
        }
    }
}
