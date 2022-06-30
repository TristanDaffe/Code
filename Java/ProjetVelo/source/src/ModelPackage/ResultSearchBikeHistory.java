package ModelPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ResultSearchBikeHistory {
    private String userName;
    private String userFirstName;
    private GregorianCalendar startDate;
    private Station startStation;
    private GregorianCalendar endDate;
    private Station endStation;

    public ResultSearchBikeHistory(String userName, String userFirstName, GregorianCalendar startDate, Station startStation, GregorianCalendar endDate, Station endStation) {
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.startDate = startDate;
        this.startStation = startStation;
        this.endDate = endDate;
        this.endStation = endStation;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getStartDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        Date date = startDate.getTime();
        return dateFormat.format(date);
    }

    public String getStartStation() {
        return startStation.getLabel();
    }

    public String getEndDate() {
        if(endDate == null)
            return "none";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        Date date = endDate.getTime();
        return dateFormat.format(date);
    }

    public String getEndStation() {
        if(endStation == null)
            return "none";
        return endStation.getLabel();
    }
}
