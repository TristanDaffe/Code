package BusinessPackage;

import DataAccessPackage.*;

import ExceptionPackage.*;
import ModelPackage.*;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ArrayList;

public class BikeManager {
    BikeDataAccess dao;

    public BikeManager() throws AccessException {
        setDao(new BikeBDAccess());
    }

    public void setDao(BikeDataAccess dao) {
        this.dao = dao;
    }

    public void addUser(User user, Locality residence) throws AddException, GetException, DeleteUserException {
        dao.addUser(user, residence);
    }
    public void updateUserInfo(User user, Locality residence) throws GetException, UpdateUserProfilException {
        dao.updateUserInfo(user,residence);
    }
    public User getUser(String eMailAddress) throws GetException, NullFieldException{
        return dao.getUser(eMailAddress);
    }
    public HashMap<String, Integer> getHiringsPerMonth(String email, int year) throws GetException{
        return dao.getHiringsPerMonth(email, year);
    }
    public Station getMostUsedStation(String email){
        return dao.getMostUsedStation(email);
    }
    public Station getMostUsedReturnStation(String email){
        return dao.getMostUsedReturnStation(email);
    }
    public int getTotBikeHire(String email){
        return dao.getTotBikeHire(email);
    }
    public ArrayList<ResultSearchBikeInterval> getBikeInIntervalleForUser(GregorianCalendar startDate, GregorianCalendar endDate) throws GetException {
        return dao.getBikeInIntervalleForUser(startDate, endDate);
    }
    public ArrayList<ResultSearchModifBiketype> getAllModifOnType(BikeType type) throws GetException {
        return dao.getAllModifOnType(type);
    }
    public ArrayList<Integer> getAllBikeId() throws GetException, NoBikeException {
        return dao.getAllBikeId();
    }
    public ArrayList<ResultSearchBikeHistory> getBikeHistory(int id) throws GetException, NoHistoryBikeException {
        return dao.getBikeHistory(id);
    }
    public ArrayList<Locality> getAllLocality() throws GetException {
        return dao.getAllLocality();
    }
    public Locality getLocality(String email) throws GetException{
        return dao.getLocality(email);
    }
    public int getAdminHash(String name) throws GetException {
        return dao.getAdminHash(name);
    }
    public ArrayList<BikeType> getAllBikeTypes() throws GetException {
        return dao.getAllBikeTypes();
    }
    public ArrayList<Bike> getAllBikesType(BikeType type)throws GetException {
        return dao.getAllBikesOfType(type);
    }
    public ArrayList<Station> getAllStation()throws GetException {
        return dao.getAllStation();
    }
    public void addHire(User user, Bike bike, GregorianCalendar date, Station station) throws GetException, AddException {
        dao.addHire(user, bike, date, station);
    }
    public boolean canUserHireType(User user, BikeType type) throws GetException {
        return dao.canUserHireType(user, type);
    }
    public boolean isHiringBike(String email){
        return dao.isHiringBike(email);
    }
    public Bike getCurrentBike(String email) throws GetException {
        return dao.getCurrentBike(email);
    }
    public void updateHire(User currentUser, Bike currentBike, GregorianCalendar endDate, Station station) throws UpdateFielExcpetion, GetException {
        dao.updateHire(currentUser, currentBike, endDate, station);
    }
    public Subscription getSubscriptionType(String email) throws GetException{
        return dao.getSubscriptionType(email);
    }
    public ArrayList<Subscription> getAllSubscriptionType() throws GetException{
        return dao.getAllSubscriptionType();
    }
    public void changeSubscription(String email, Subscription subscription) throws UpdateFielExcpetion {
        dao.changeSubscription(email, subscription);
    }

    public ArrayList<User> getAllUser() throws GetException, InvalidFieldException, NullFieldException, PhoneNumberFormatException {
        return dao.getAllUser();
    }

    public void deleteUserList(ArrayList<String> userEmailToDelete) throws UpdateFielExcpetion {
        dao.deleteUserList(userEmailToDelete);
    }
}
