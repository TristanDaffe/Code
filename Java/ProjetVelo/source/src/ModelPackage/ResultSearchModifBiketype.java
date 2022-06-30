package ModelPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ResultSearchModifBiketype {
    private int BikeId;
    private GregorianCalendar dateChange;
    private String admin;

    public ResultSearchModifBiketype(int bikeId, GregorianCalendar dateChange, String admin) {
        BikeId = bikeId;
        this.dateChange = dateChange;
        this.admin = admin;
    }

    public int getBikeId() {
        return BikeId;
    }

    public String getDateChange() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        Date date = dateChange.getTime();
        return dateFormat.format(date);
    }

    public String getAdmin() {
        return admin;
    }
}
