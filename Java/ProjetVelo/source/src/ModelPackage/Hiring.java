package ModelPackage;

import java.util.GregorianCalendar;

public class Hiring {
    private GregorianCalendar startDate;
    private User user;
    private Bike bike;
    private GregorianCalendar endDate;
    private Station startStation;
    private Station endStation;

    public Hiring(GregorianCalendar startDate, User user, Bike bike, GregorianCalendar endDate, Station startStation, Station endStation) {
        setStartDate(startDate);
        setUser(user);
        setBike(bike);
        setEndDate(endDate);
        setStartStation(startStation);
        setEndStation(endStation);
    }

    //region setter

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }
    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }
    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }
    //endregion

    //region getter
    public GregorianCalendar getStartDate() {
        return startDate;
    }
    public User getUser() {
        return user;
    }
    public Bike getBike() {
        return bike;
    }
    public GregorianCalendar getEndDate() {
        return endDate;
    }
    public Station getStartStation() {
        return startStation;
    }
    public Station getEndStation() {
        return endStation;
    }
    //endregion

}
