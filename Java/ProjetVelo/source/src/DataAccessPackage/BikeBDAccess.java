package DataAccessPackage;

import ExceptionPackage.*;
import ModelPackage.*;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ArrayList;

public class BikeBDAccess implements BikeDataAccess{
    private final Connection connection;

    public BikeBDAccess() throws AccessException {
        connection = SingletonConnection.getInstance();
    }
    //region User
    public void addUser(User user, Locality residence) throws AddException, DeleteUserException {
    String sql = "INSERT INTO user " +
                 "(last_name, first_name, birthday, email_address, password, tel_number, agree_receive_pub, sponsor, residence)" +
                 "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    try{
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, user.getLastName());
        statement.setString(2, user.getFirstName());
        statement.setDate(3, new java.sql.Date(user.getBirthday().getTimeInMillis()));
        statement.setString(4, user.getEmailAddress().toLowerCase());
        statement.setInt(5, user.getPassword());
        //num tel facultatif
        if(user.getPhoneNumber() != null)
            statement.setString(6, user.getPhoneNumber());
        else
            statement.setNull(6, Types.VARCHAR);

        statement.setBoolean(7, user.isAgreeReceivePub());
        //sponsor facultatif
        if(user.getSponsor() != null){
            statement.setString(8, user.getSponsor());
        }
        else
            statement.setNull(8, Types.INTEGER);
        int localityId = getLocalityId(residence.getLabel(), residence.getPostalCode());
        statement.setInt(9, localityId);
        //update
        statement.executeUpdate();
        //met un type d'abonnement par default
        addDefaultSubscription(user.getEmailAddress());
    }
    catch (AddException e){
        //supprime le user si une erreur lors de l'ajout de l'abo de base
        String sql2 = "DELETE FROM use WHERE email_address = ?";
        try{
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, user.getEmailAddress());
            statement2.executeUpdate();
        } catch (SQLException ex) {
            throw new DeleteUserException();
        }
    }
    catch(Exception ex){
        throw new AddException("user");
    }

}
    public User getUser(String emailAddress) throws GetException {
        User user;
        String sql = "SELECT * FROM user " +
                     "WHERE email_address = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailAddress);
            ResultSet data = statement.executeQuery();
            data.next();

            //récupere les données du user
            String lastName = data.getString("last_name");
            String firstName = data.getString("first_name");
            GregorianCalendar birthday = new GregorianCalendar();
            java.sql.Date sqlDate = data.getDate("birthday");
            birthday.setTime(sqlDate);
            int password = data.getInt("password");
            String telNumber = data.getString("tel_number");
            boolean agreePub = data.getBoolean("agree_receive_pub");
            String sponsor = data.getString("sponsor");

            user = new User(lastName, firstName, birthday, emailAddress, password, telNumber, agreePub, sponsor);
            return user;
        } catch (Exception e) {
            throw new GetException("user");
        }
    }
    public ArrayList<User> getAllUser() throws GetException, InvalidFieldException, NullFieldException, PhoneNumberFormatException {
        String sql = ("SELECT * FROM user");
        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                //récupere les données du user
                String lastName = data.getString("last_name");
                String firstName = data.getString("first_name");
                GregorianCalendar birthday = new GregorianCalendar();
                java.sql.Date sqlDate = data.getDate("birthday");
                birthday.setTime(sqlDate);
                String email = data.getString("email_address");
                int password = data.getInt("password");
                String telNumber = data.getString("tel_number");
                boolean agreePub = data.getBoolean("agree_receive_pub");
                String sponsor = data.getString("sponsor");

                users.add(new User(lastName, firstName, birthday, email, password, telNumber, agreePub, sponsor));
            }
            return users;
        } catch (SQLException e) {
            throw new GetException("user");
        }
    }
    public void updateUserInfo(User user, Locality residence) throws UpdateUserProfilException, GetException {
        String sql = "UPDATE user Set " +
                    "last_name = ?, first_name = ?, birthday = ?, tel_number = ?, agree_receive_pub = ?, sponsor = ?, residence = ? " +
                    "WHERE email_address = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getLastName());
            statement.setString(2, user.getFirstName());
            statement.setDate(3, new java.sql.Date(user.getBirthday().getTimeInMillis()));
            //num tel facultatif
            if(user.getPhoneNumber() != null)
                statement.setString(4, user.getPhoneNumber());
            else
                statement.setNull(4, Types.VARCHAR);

            statement.setBoolean(5, user.isAgreeReceivePub());
            //sponsor facultatif
            if(user.getSponsor() != null){
                statement.setString(6, user.getSponsor());
            }
            else
                statement.setNull(6, Types.INTEGER);
            int localityId = getLocalityId(residence.getLabel(), residence.getPostalCode());
            statement.setInt(7, localityId);
            statement.setString(8, user.getEmailAddress().toLowerCase());
            //update
            statement.executeUpdate();
        }
        catch(SQLException exception){
            throw new UpdateUserProfilException();
        }
    }

    public Subscription getSubscriptionType(String email){
        String sqlUser = "SELECT * from type_of_subscription " +
                        "INNER JOIN subscription ON (subscription.sub_id = id) " +
                        "WHERE subscription.user = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlUser);
            statement.setString(1, email);
            ResultSet data = statement.executeQuery();

            data.next();
            return new Subscription(data.getInt("id"), data.getString("name"), data.getDouble("price_per_month"));

        } catch (SQLException e) {
            return  new Subscription(0, "none", 0);
        }
    }
    public ArrayList<Subscription> getAllSubscriptionType() throws GetException {
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        String sqlUser = "SELECT * from type_of_subscription  ";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlUser);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                subscriptions.add(new Subscription(data.getInt("id"), data.getString("name"), data.getDouble("price_per_month")));
            }
            return subscriptions;

        } catch (SQLException e) {
            throw new GetException("subscription type");
        }
    }
    public void changeSubscription(String email, Subscription subscription) throws UpdateFielExcpetion {
        String sql = "UPDATE subscription SET sub_id = ? " +
                     "WHERE user = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, subscription.getId());
            statement.setString(2, email);

            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new UpdateFielExcpetion("subscription");
        }
    }
    public void addDefaultSubscription(String email) throws AddException {
        String sql = "INSERT INTO subscription " +
                     "(user, sub_id) " +
                     "VALUES (?, 1)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new AddException("subscription");
        }
    }
    public void deleteUser(String email) throws UpdateFielExcpetion {
        String sql1 = "UPDATE user SET sponsor = null " +
                      "WHERE sponsor = ?";
        String sql2 = "DELETE FROM hiring " +
                      "WHERE user = ? ";
        String sql3 = "DELETE FROM subscription " +
                      "WHERE user = ? ";
        String sql4 = "DELETE FROM user " +
                      "WHERE email_address = ? ";
        try{
//supprime le user des sponsors
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setString(1, email);
            statement.executeUpdate();

//delete le user, les locations et son abonnement
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, email);
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            statement3.setString(1, email);
            PreparedStatement statement4 = connection.prepareStatement(sql4);
            statement4.setString(1, email);

            statement2.executeUpdate();
            statement3.executeUpdate();
            statement4.executeUpdate();
        }
        catch (SQLException e){
            throw new UpdateFielExcpetion("sponsor");
        }
    }
    public void deleteUserList(ArrayList<String> userEmailToDelete) throws UpdateFielExcpetion {
        for(String email : userEmailToDelete)
            deleteUser(email);
    }
    //endregion

    //region Admin
    public int getAdminHash(String name) throws GetException {
        String sql = "SELECT password FROM admin " +
                     "WHERE name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet data = statement.executeQuery();
            data.next();
            return data.getInt("password");

        } catch (SQLException e) {
            throw new GetException("password");
        }
    }
    //endregion

    //region Locality
    public Locality getLocality(int id) throws GetException{
        Locality locality;
        String sql = "SELECT label, postal_code FROM locality " +
                "WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet data = statement.executeQuery();
            data.next();

            String label = data.getString("label");
            int postalCode = data.getInt("postal_code");
            locality = new Locality(label, postalCode);
            return locality;

        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    public Locality getLocality(String email) throws GetException{
        Locality locality;
        String sql = "SELECT label, postal_code FROM locality " +
                "INNER JOIN user on (user.residence = id) " +
                "WHERE user.email_address = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet data = statement.executeQuery();
            data.next();

            String label = data.getString("label");
            int postalCode = data.getInt("postal_code");
            locality = new Locality(label, postalCode);
            return locality;

        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    public int getLocalityId(String label, int postalCode) throws GetException{
        String sql = "SELECT id FROM locality " +
                "WHERE label = ? AND postal_code = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, label);
            statement.setInt(2, postalCode);
            ResultSet data = statement.executeQuery();
            data.next();

            return data.getInt("id");
        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    public ArrayList<Locality> getAllLocality() throws GetException {
        String sql = ("SELECT label, postal_code FROM locality");
        ArrayList<Locality> localitys = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                String label = data.getString("label");
                int postalCode = data.getInt("postal_code");
                localitys.add(new Locality(label, postalCode));
            }
            return localitys;
        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    //endregion

    //region Station
    public int getStationId(Station station) throws GetException{
        String sql = "SELECT id FROM station " +
                "WHERE label = ? AND locality = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, station.getLabel());
            int localityId = getLocalityId(station.getLocality().getLabel(), station.getLocality().getPostalCode());
            statement.setInt(2, localityId);
            ResultSet data = statement.executeQuery();
            data.next();

            return data.getInt("id");
        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    public Station getStation(int id) throws GetException{
        String sql = "SELECT label, phone_number, locality FROM station " +
                "WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet data = statement.executeQuery();
            data.next();

            String label = data.getString("label");
            String phoneNumber = data.getString("phone_number");
            int localityId= data.getInt("locality");
            return new Station(label, phoneNumber, getLocality(localityId));
        } catch (SQLException e) {
            throw new GetException("locality");
        }
    }
    public ArrayList<Station> getAllStation()throws GetException{
        ArrayList<Station>  stations = new ArrayList<>();
        String sql = "SELECT * FROM station";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                String label = data.getString("label");
                String phoneNumber = data.getString("phone_number");
                Locality loc = getLocality(data.getInt("locality"));
                stations.add(new Station(label, phoneNumber, loc));
            }
            return stations;
        }
        catch (SQLException e) {
            throw new GetException("stations");
        }
    }
    //endregion

    //region Bike
    public ArrayList<Integer> getAllBikeId() throws GetException, NoBikeException {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT id FROM bike";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                result.add(data.getInt("id"));
            }
            if(result.isEmpty())
                throw new NoBikeException();
            return result;
        }
        catch (SQLException e){
            throw new GetException("bikes id");
        }
    }
    public ArrayList<Bike> getAllBikesOfType(BikeType type)throws GetException {
        ArrayList<Bike> bike = new ArrayList<>();
        String sql = "SELECT * FROM bike " +
                "INNER JOIN bike_type on (bike_type.label = ?)" +
                "WHERE type = bike_type.id ";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type.getLabel());
            ResultSet data = statement.executeQuery();

            while(data.next()){
                int id = data.getInt("id");
                GregorianCalendar lastRevisionDate = new GregorianCalendar();
                java.sql.Date sqlDate = data.getDate("last_revision_date");
                lastRevisionDate.setTime(sqlDate);

                bike.add(new Bike(id, lastRevisionDate, type));
            }
            return bike;
        }
        catch (SQLException e) {
            throw new GetException("bike type");
        }
    }

    public ArrayList<BikeType> getAllBikeTypes() throws GetException {
        ArrayList<BikeType> types = new ArrayList<>();
        String sql = "SELECT * FROM bike_type";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                int id = data.getInt("id");
                String label = data.getString("label");
                types.add(new BikeType(id, label));
            }
            return types;
        }
        catch (SQLException e) {
            throw new GetException("bike type");
        }
    }

    public Bike getCurrentBike(String email) throws GetException {
        String sql = "SELECT bike.id, last_revision_date, ty.label FROM bike " +
                "INNER JOIN hiring on (hiring.bike = bike.id) " +
                "INNER JOIN bike_type ty on (ty.id = type) " +
                "where user = ?  AND end_date IS NULL " +
                "ORDER By hiring.start_date " +
                "LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet data = statement.executeQuery();

            data.next();
            int id = data.getInt("id");
            Date date = data.getDate("last_revision_date");
            GregorianCalendar lastRevisionDate = new GregorianCalendar();
            lastRevisionDate.setTime(date);
            BikeType type = new BikeType(id, data.getString("ty.label"));

            return new Bike(id, lastRevisionDate, type);
        }
        catch(SQLException e){
            throw new GetException("current hiring bike");
        }
    }
    public void addHire(User user, Bike bike, GregorianCalendar date, Station station) throws AddException, GetException {
        String sql = "INSERT INTO hiring " +
                "(user, bike, start_date, start_station) " +
                "VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmailAddress());
            statement.setInt(2, bike.getId());
            Date start_date = new Date(date.getTimeInMillis());
            statement.setDate(3, start_date);
            int stationId = getStationId(station);
            statement.setInt(4, stationId);

            statement.executeUpdate();
        }
        catch(SQLException e) {
            throw new AddException("hiring");
        }
    }
    public void updateHire(User currentUser, Bike currentBike, GregorianCalendar endDate, Station station) throws UpdateFielExcpetion, GetException {
        String sql = "UPDATE hiring SET end_date = ?, end_station = ? " +
                "WHERE user = ? AND bike = ? AND end_date IS NULL";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDate(1, new Date(endDate.getTimeInMillis()));
            int stationId = getStationId(station);
            statement.setInt(2, stationId);
            statement.setString(3, currentUser.getEmailAddress());
            statement.setInt(4, currentBike.getId());

            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new UpdateFielExcpetion("hiring");
        }
    }

    public boolean isHiringBike(String email){
        String sql = "SELECT end_date FROM hiring " +
                "WHERE user = ? AND end_date IS NULL " +
                "LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet data = statement.executeQuery();

            data.next();
            return data.getDate("end_date") == null;
        }
        catch (SQLException e) {
            return false;
        }
    }
    public boolean canUserHireType(User user, BikeType type) throws GetException {
        String sqlUser = "SELECT sub_id from subscription " +
                         "WHERE user = ? ";
        String sqlType = "SELECT type_subscription FROM bike_type " +
                        "INNER JOIN bike on (bike.type = bike_type.id) " +
                        "WHERE bike_type.label = ? " +
                        "LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlUser);
            statement.setString(1, user.getEmailAddress());
            ResultSet data = statement.executeQuery();

            PreparedStatement statement2 = connection.prepareStatement(sqlType);
            statement2.setString(1, type.getLabel());
            ResultSet data2 = statement2.executeQuery();

            data.next();
            data2.next();
            return data.getInt("sub_id") == data2.getInt("type_subscription");
        }
        catch (SQLException e) {
            throw new GetException("user subscription");
        }
    }

    public int getTotBikeHire(String email){
        String sql = "SELECT count(*) as nb FROM hiring " +
                "WHERE user = ?;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet data = statement.executeQuery();
            data.next();

            return data.getInt("nb");
        }
        catch(SQLException ex){
            return 0;
        }
    }
    //endregion

    //region research
    public ArrayList<ResultSearchBikeInterval> getBikeInIntervalleForUser(GregorianCalendar startDate, GregorianCalendar endDate) throws GetException {
        ArrayList<ResultSearchBikeInterval> result = new ArrayList<>();
        String sql = "SELECT bike.id, last_revision_date, ty.label, hiring.start_date, st.label, user.email_address FROM bike " +
                "INNER JOIN bike_type ty on(type = ty.id) " +
                "INNER JOIN hiring on (hiring.bike = bike.id) " +
                "INNER JOIN station st on (st.id = hiring.start_station) " +
                "INNER JOIN user on (user.email_address = hiring.user) " +
                "WHERE hiring.start_date BETWEEN ? AND ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(startDate.getTimeInMillis()));
            statement.setDate(2, new java.sql.Date(endDate.getTimeInMillis()));
            ResultSet data = statement.executeQuery();

            while(data.next()){
                int id = data.getInt("id");
                GregorianCalendar lastRevisionDate = new GregorianCalendar();
                java.sql.Date sqlDate = data.getDate("last_revision_date");
                lastRevisionDate.setTime(sqlDate);
                BikeType type = new BikeType(id, data.getString("ty.label"));
                Bike bike = new Bike(id, lastRevisionDate, type);

                GregorianCalendar date = new GregorianCalendar();
                date.setTime(data.getDate("hiring.start_date"));

                String stationLabel = data.getString("st.label");

                String email = data.getString("user.email_address");

                result.add(new ResultSearchBikeInterval(bike, stationLabel, date, email));
            }
            if(result.isEmpty())
                throw new GetException("research");
            return result;
        } catch (SQLException e) {
            throw new GetException("research");
        }
    }
    public ArrayList<ResultSearchModifBiketype> getAllModifOnType(BikeType type) throws GetException {
        ArrayList<ResultSearchModifBiketype> result = new ArrayList<>();
        String sql = "SELECT bike.id, date, admin.name FROM modification " +
                "INNER JOIN bike on (bike.id = modification.bike) " +
                "INNER JOIN admin on (admin.id = modification.admin) " +
                "INNER JOIN bike_type on (bike.type = bike_type.id) " +
                "WHERE bike_type.label = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type.getLabel());
            ResultSet data = statement.executeQuery();

            while(data.next()){
                int id = data.getInt("bike.id");
                GregorianCalendar date = new GregorianCalendar();
                java.sql.Date sqlDate = data.getDate("date");
                date.setTime(sqlDate);
                String admin = data.getString("admin.name");

                result.add(new ResultSearchModifBiketype(id, date, admin));
            }
            if(result.isEmpty())
                throw new GetException("research");
            return result;
        }
        catch (SQLException e){
            throw new GetException("modification");
        }
    }
    public ArrayList<ResultSearchBikeHistory> getBikeHistory(int id) throws GetException, NoHistoryBikeException {
        ArrayList<ResultSearchBikeHistory> result = new ArrayList<>();
        String sql = "SELECT user.last_name, user.first_name, start_date, end_date, start_station, end_station " +
                "FROM hiring " +
                "INNER JOIN user on (user.email_address = hiring.user) " +
                "WHERE hiring.bike = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet data = statement.executeQuery();

            while(data.next()){
                String lastName = data.getString("user.last_name");
                String firstName = data.getString("user.first_name");

                GregorianCalendar startDate = new GregorianCalendar();
                java.sql.Date sqlDate = data.getDate("start_date");
                startDate.setTime(sqlDate);

                GregorianCalendar endDate = new GregorianCalendar();
                sqlDate = data.getDate("end_date");
                if(sqlDate == null)
                    endDate = null;
                else
                    endDate.setTime(sqlDate);

                Station startStation = getStation(data.getInt("start_station"));

                int endStationId = data.getInt("start_station");
                Station endStation;
                if(data.wasNull())
                    endStation = null;
                else{
                    endStation = getStation(endStationId);
                }
                result.add(new ResultSearchBikeHistory(lastName, firstName, startDate, startStation, endDate, endStation));
            }

            if(result.isEmpty())
                throw new NoHistoryBikeException();
            return result;
        }
        catch (SQLException e){
            throw new GetException("history");
        }
    }
    public HashMap<String, Integer> getHiringsPerMonth(String email, int year){
        HashMap<String, Integer> hirings = new HashMap<>();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for(String month : months)
            hirings.put(month, 0);

        String sql = "SELECT count(*) as nb, date_format(start_date, '%M') as month FROM hiring " +
                "WHERE user = ? AND YEAR(start_date) = ? " +
                "GROUP BY MONTH(start_date), month " +
                "ORDER BY MONTH(start_date);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setInt(2, year);

            ResultSet data = statement.executeQuery();
            while(data.next()){
                String month = data.getString("month");
                int nb = data.getInt("nb");
                hirings.put(month, nb);
            }
        }
        catch(SQLException ex){
            hirings = null;
        }
        return hirings;
    }
    public Station getMostUsedStation(String email){
        Station station;
        String sql = "SELECT st.label, st.phone_number, lc.label, lc.postal_code " +
                "FROM hiring " +
                "INNER JOIN station st on (st.id = hiring.start_station) " +
                "INNER JOIN locality lc on (lc.id = st.id) " +
                "WHERE user = ? " +
                "GROUP BY start_station " +
                "ORDER BY count(bike) DESC " +
                "LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet data = statement.executeQuery();
            data.next();

            String label = data.getString("st.label");
            String phoneNumber = data.getString("st.phone_number");
            Locality loc = new Locality(data.getString("lc.label"), data.getInt("lc.postal_code"));

            station = new Station(label, phoneNumber, loc);
        }
        catch(SQLException ex){
            station = null;
        }
        return station;
    }

    public Station getMostUsedReturnStation(String email){
        Station station;
        String sql = "SELECT st.label, st.phone_number, lc.label, lc.postal_code " +
                "FROM hiring " +
                "INNER JOIN station st on (st.id = hiring.end_station) " +
                "INNER JOIN locality lc on (lc.id = st.id) " +
                "WHERE user = ? " +
                "GROUP BY end_station " +
                "ORDER BY count(bike) DESC " +
                "LIMIT 1";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet data = statement.executeQuery();
            data.next();

            String label = data.getString("st.label");
            String phoneNumber = data.getString("st.phone_number");
            Locality loc = new Locality(data.getString("lc.label"), data.getInt("lc.postal_code"));

            station = new Station(label, phoneNumber, loc);
        }
        catch(SQLException ex){
            station = null;
        }
        return station;
    }


    //endregion
}