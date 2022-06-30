package ModelPackage;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Bike {
    private Integer id;
    private GregorianCalendar lastRevisionDate;
    private BikeType type;

    public Bike(Integer id, GregorianCalendar lastRevisionDate, BikeType type) {
        setId(id);
        setLastRevisionDate(lastRevisionDate);
        setType(type);
    }

    //region getter
    public Integer getId() {
        return id;
    }
    public GregorianCalendar getLastRevisionDate() {
        return lastRevisionDate;
    }
    public BikeType getType() {
        return type;
    }
    //endregion

    //region setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setLastRevisionDate(GregorianCalendar lastRevisionDate) {
        this.lastRevisionDate = lastRevisionDate;
    }
    public void setType(BikeType type) {
        this.type = type;
    }
    //endregion

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
        return "number : "+ id +"    last revised : "+ dateFormat.format(lastRevisionDate.getTime());
    }
}
