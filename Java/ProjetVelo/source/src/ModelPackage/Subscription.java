package ModelPackage;

public class Subscription {
    private int id;
    private String label;
    private double price;

    public Subscription(int id, String label, double price) {
        setId(id);
        setLabel(label);
        setPrice(price);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return label +" ("+ price +" €/month)";
    }
}
