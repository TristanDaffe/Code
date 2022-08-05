using System;
using System.Collections.Generic;
using System.Text;

namespace Labo2 {
    class User {

        #region attributes
        private string login;
        private int password;
        private DateTime joinDate;
        private int postCount;

        private int spacePosted;
        private int digitPosted;
        #endregion

        #region constructors
        public User(string login, string password, DateTime joinDate) {
            Login = login;
            Password = password;;
            this.joinDate = joinDate;
            postCount = 0;

            spacePosted = 0;
            digitPosted = 0;
        }

        public User(string login, string password) : 
            this(login, password, DateTime.Today){ }
        public User(string login, string password, int joinDate) :
            this(login, password) {
            JoinDate = joinDate;
        }
        #endregion

        public string Login { 
            get {
                return login; 
            } 
            set {
                if (ForumUtils.ValidLogin(value)) 
                    login = value; 
            } 
        }

        public int JoinDate {
            get {
                return int.Parse(joinDate.ToString("yyyyMMdd"));
            }
            set {
                joinDate = new DateTime(value/10_000, (value/100)%100, value%100);;
            }
        }

        public int PostCount {
            get {
                return postCount;
            }
        }

        public string Password {
            set {
                password = Encode(value);
            }
        }

        public bool ValidPassword (string password){
            return this.password == Encode(password);
        }

        private int Encode(string password) {
            int hash = 0;
            foreach (char carac in password)
                hash += carac;
            return hash % 997;
        }

        public void AddPost(Post post) {
            //int spaceCount;
            //int digitCount;
            //ForumUtils.Count(post.Content, out spaceCount, out digitCount);
            //spacePosted += spaceCount;
            //digitPosted += digitCount;
            ForumUtils.CountAndUpdate(post.Content, ref spacePosted, ref digitPosted);
            postCount++;

        }

        public override string ToString() {
            StringBuilder output = new StringBuilder();

            output.Append(Login);
            output.Append(" (password: ");
            output.Append(password);
            output.Append(" ), ");
            output.Append(JoinDate);
            output.Append(" - ");

            output.Append(PostCount);
            output.Append(" post"+ (PostCount > 1 ? "s" : ""));
            output.Append(" - ");

            output.Append(spacePosted);
            output.Append(" space" + (PostCount > 1 ? "s" : ""));
            output.Append(" - ");

            output.Append(digitPosted);
            output.Append(" digit" + (PostCount > 1 ? "s" : ""));
            return output.ToString();
        }
    }
}
