package DataAccessPackage;

import ExceptionPackage.*;

import java.sql.*;

public class SingletonConnection {
    private static Connection uniqueConnection;
    public static Connection getInstance() throws AccessException{
        if (uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bikeBD", "root", "pwsVelo");
            }
            catch(SQLException e){
                throw new AccessException();
            }
        }
        return uniqueConnection;
    }
}
