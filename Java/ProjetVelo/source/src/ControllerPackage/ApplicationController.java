package ControllerPackage;

import BusinessPackage.*;
import ExceptionPackage.*;
import ModelPackage.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationController  {
    BikeManager manager;

    public ApplicationController() throws AccessException {
        setManager(new BikeManager());
    }
    public void setManager(BikeManager manager) {
        this.manager = manager;
    }

    public User addUser(String lastName, String firstName, GregorianCalendar birthday, String emailAddress, String password, String phoneNumber, boolean pubConsent, String sponsor, Locality residence) throws AddException, NullFieldException, InvalidFieldException, GetException, DeleteUserException, PhoneNumberFormatException {

        User user= new User(lastName, firstName, birthday, emailAddress.toLowerCase(), password, phoneNumber, pubConsent, sponsor);
        manager.addUser(user, residence);
        return user;
    }
    public User updateUserInfo(String lastName, String firstName, GregorianCalendar birthday, String emailAddress, String password, String phoneNumber, boolean pubConsent, String sponsor, Locality residence) throws NullFieldException, InvalidFieldException, GetException, UpdateUserProfilException, PhoneNumberFormatException {
        //récupère les données et vérifie si les champs sont vides ou null
        if(lastName.isEmpty() || lastName.isBlank())
            throw new NullFieldException("last name");
        if(firstName.isEmpty() || firstName.isBlank())
            throw new NullFieldException("first name");

        if(emailAddress.isEmpty())
            throw new NullFieldException("email address");
        if(password.length() == 0)
            throw new NullFieldException("password");
        User user= new User(lastName, firstName, birthday, emailAddress.toLowerCase(), password, phoneNumber, pubConsent, sponsor);
        manager.updateUserInfo(user, residence);
        return user;
    }
    public String connectUser(String email, String password) throws GetException, NullFieldException, UserConnectionException {
        Pattern emailPattern = Pattern.compile(".*@.*\\..*");
        Matcher emailMatcher = emailPattern.matcher(email);
        boolean matchFound = emailMatcher.find();

        int expectedPassword;
        String userType;
        //regarde si c est une connexion user ou admin
        if(matchFound){
            User user = manager.getUser(email);
            expectedPassword = user.getPassword();
            userType = "user";
         }
        else{
            expectedPassword = manager.getAdminHash(email);
            userType = "admin";
        }
        //vérifie le password
        if (password.hashCode() == expectedPassword) {
            return userType;
        } else {
            throw new UserConnectionException();
        }
    }
    public User getUser(String eMailAddress) throws GetException, NullFieldException{
        return manager.getUser(eMailAddress);
    }
    public ArrayList<User> getAllUser() throws GetException, InvalidFieldException, NullFieldException, PhoneNumberFormatException {
        return manager.getAllUser();
    }
    public HashMap<String, Integer> getHiringsPerMonth(String email, int year) throws GetException{
        return manager.getHiringsPerMonth(email, year);
    }
    public Station getMostUsedStation(String email){
        return manager.getMostUsedStation(email);
    }
    public Station getMostUsedReturnStation(String email){
        return manager.getMostUsedReturnStation(email);
    }
    public int getTotBikeHire(String email) {
        return manager.getTotBikeHire(email);
    }
    public ArrayList<ResultSearchBikeInterval> getBikeInIntervalleForUser(GregorianCalendar startDate, GregorianCalendar endDate) throws GetException {
        return manager.getBikeInIntervalleForUser( startDate, endDate);
    }
    public ArrayList<ResultSearchModifBiketype> getAllModifOnType(BikeType type) throws GetException {
        return manager.getAllModifOnType(type);
    }
    public ArrayList<Locality> getAllLocality() throws GetException {
        return manager.getAllLocality();
    }

    public ArrayList<BikeType> getAllBikeTypes() throws GetException {
        return manager.getAllBikeTypes();
    }
    public ArrayList<Bike> getAllBikesType(BikeType type)throws GetException {
        return manager.getAllBikesType(type);
    }
    public ArrayList<Station> getAllStation()throws GetException {
        return manager.getAllStation();
    }
    public boolean isHiringBike(String email){
        return manager.isHiringBike(email);
    }
    public void addHire(User user, Bike bike, GregorianCalendar date, Station station) throws GetException, InvalidSubscriptionException, IsHiringException, AddException {

        if(isHiringBike(user.getEmailAddress())){
            throw new IsHiringException();
        }

        if(manager.canUserHireType(user, bike.getType())){
            manager.addHire(user, bike, date, station);
        }
        else{
            throw new InvalidSubscriptionException();
        }
    }
    public Bike getCurrentBike(String email) throws GetException {
        return manager.getCurrentBike(email);
    }

    public void updateHire(User currentUser, Bike currentBike, GregorianCalendar endDate, Station station) throws UpdateFielExcpetion, GetException {
        manager.updateHire(currentUser, currentBike, endDate, station);
    }
    public Subscription getSubscriptionType(String email) throws GetException{
        return manager.getSubscriptionType(email);
    }
    public ArrayList<Subscription> getAllSubscriptionType() throws GetException{
        return manager.getAllSubscriptionType();
    }
    public void changeSubscription(String email, Subscription subscription) throws UpdateFielExcpetion {
        manager.changeSubscription(email, subscription);
    }
    public Locality getLocality(String email) throws GetException {
        return manager.getLocality(email);
    }
    public String[] getAllBikeId() throws GetException, NoBikeException {
        ArrayList<Integer> resultHash = manager.getAllBikeId();
        String[] result = new String[resultHash.size()];
        int i = 0;
        for(int res : resultHash){
            result[i] = String.valueOf(res);
            i++;
        }
        return result;
    }
    public ArrayList<ResultSearchBikeHistory> getBikeHistory(int id) throws GetException, NoHistoryBikeException {
        return manager.getBikeHistory(id);

    }

    public void deleteUserList(ArrayList<String> userEmailToDelete) throws UpdateFielExcpetion {
        manager.deleteUserList(userEmailToDelete);
    }
}
