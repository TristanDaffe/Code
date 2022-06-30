package ModelPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class ResultSearchBikeInterval {
    private Bike bike;
    private String startStationLabel;
    private GregorianCalendar startDate;
    private String userEmail;

    public ResultSearchBikeInterval(Bike bike, String startStationLabel, GregorianCalendar startDate, String userEmail) {
        this.bike = bike;
        this.startStationLabel = startStationLabel;
        this.startDate = startDate;
        this.userEmail = userEmail;
    }

    public Bike getBike() {
        return bike;
    }

    public String getStartStationLabel() {
        return startStationLabel;
    }

    public String getStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        Date date = startDate.getTime();
        return dateFormat.format(date);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        Date date = startDate.getTime();
        return "Bike : "+ bike.getId() +" ("+ bike.getType() +") -  at station "+ startStationLabel +" -  on "+ dateFormat.format(date) +" - by user "+ userEmail;
    }

}
