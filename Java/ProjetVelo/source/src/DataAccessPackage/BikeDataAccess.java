package DataAccessPackage;

import ExceptionPackage.*;
import ModelPackage.*;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ArrayList;

public interface BikeDataAccess {

    void addUser(User user, Locality residence) throws AddException, GetException, DeleteUserException;
    void updateUserInfo(User user, Locality residence) throws UpdateUserProfilException, GetException;
    User getUser(String eMailAddress) throws GetException, NullFieldException;
    ArrayList<User> getAllUser() throws GetException, InvalidFieldException, NullFieldException, PhoneNumberFormatException;
    HashMap<String, Integer> getHiringsPerMonth(String email, int year) throws GetException;
    Station getMostUsedStation(String email);
    Station getMostUsedReturnStation(String email);
    int getTotBikeHire(String eMailAddress);
    ArrayList<ResultSearchBikeInterval> getBikeInIntervalleForUser(GregorianCalendar startDate, GregorianCalendar endDate) throws GetException;
    ArrayList<ResultSearchModifBiketype> getAllModifOnType(BikeType type) throws GetException;
    ArrayList<Integer> getAllBikeId() throws GetException, NoBikeException;
    ArrayList<ResultSearchBikeHistory> getBikeHistory(int id) throws GetException, NoHistoryBikeException;
    Locality getLocality(int id) throws GetException;
    int getLocalityId(String label, int postalCode) throws GetException;
    Locality getLocality(String email) throws GetException;
    int getAdminHash(String name) throws GetException;
    ArrayList<Locality> getAllLocality() throws GetException;
    ArrayList<BikeType> getAllBikeTypes() throws GetException;
    ArrayList<Bike> getAllBikesOfType(BikeType type)throws GetException;
    ArrayList<Station> getAllStation()throws GetException;
    void addHire(User user, Bike bike, GregorianCalendar date, Station station) throws AddException, GetException;
    boolean canUserHireType(User user, BikeType type) throws GetException;
    boolean isHiringBike(String email);
    Bike getCurrentBike(String email) throws GetException;
    void updateHire(User currentUser, Bike currentBike, GregorianCalendar endDate, Station station) throws UpdateFielExcpetion, GetException;
    Subscription getSubscriptionType(String email) throws GetException;
    ArrayList<Subscription> getAllSubscriptionType() throws GetException;
    void changeSubscription(String email, Subscription subscription) throws UpdateFielExcpetion;
    void deleteUserList(ArrayList<String> userEmailToDelete) throws UpdateFielExcpetion;
}
