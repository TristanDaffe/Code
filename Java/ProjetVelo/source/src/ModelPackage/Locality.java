package ModelPackage;

public class Locality{
    private String label;
    private Integer postalCode;

    public Locality(String label, Integer postalCode) {
        setLabel(label);
        setPostalCode(postalCode);
    }

    //region setter

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    //endregion

    //region getter
    public String getLabel() {
        return label;
    }
    public Integer getPostalCode() {
        return postalCode;
    }
    //endregion

    public String toString() {
        return label +" "+ postalCode;
    }
}