package ModelPackage;

public class Station {
    private String label;
    private String phoneNumber;
    private Locality locality;

    public Station(String label, String phoneNumber, Locality locality) {
        setLabel(label);
        setPhoneNumber(phoneNumber);;
        setLocality(locality);
    }

    //region setter
    public void setLabel(String label) {
        this.label = label;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setLocality(Locality locality) {
        this.locality = locality;
    }
    //endregion

    //region getter
    public String getLabel() {
        return label;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Locality getLocality() {
        return locality;
    }
    //endregion

    public String toString() {
        return label +" "+locality;
    }
}