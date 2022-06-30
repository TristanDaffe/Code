package ModelPackage;

public class BikeType {
    private int id;
    private String label;

    public BikeType(int id, String label) {setId(this.id);
       setLabel(label);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return label;
    }
}
