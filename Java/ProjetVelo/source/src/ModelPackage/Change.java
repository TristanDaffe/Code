package ModelPackage;

import java.util.GregorianCalendar;

public class Change {
    private GregorianCalendar date;
    private Bike bike;
    private Admin admin;
    private String typeOfChange;

    public Change(GregorianCalendar date, Bike bike, Admin admin, String typeOfChange) {
        setDate(date);
        setBike(bike);
        setAdmin(admin);
        setTypeOfChange(typeOfChange);
    }

    //region setter
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void setTypeOfChange(String typeOfChange) {
        this.typeOfChange = typeOfChange;
    }
    //endregion

    //region getter
    public GregorianCalendar getDate() {
        return date;
    }
    public Bike getBike() {
        return bike;
    }
    public Admin getAdmin() {
        return admin;
    }
    public String getTypeOfChange() {
        return typeOfChange;
    }
    //endregion
}
