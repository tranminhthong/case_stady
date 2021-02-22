package Entities.products;

public class Laptop extends Product {
    private int gateHDMI;
    private String ledKeyboard;

    public Laptop() {
    }

    public Laptop(int id, String name, int code, String brand, double weight, double size, String color, long price, int gateHDMI, String ledKeyboard) {
        super(id, name, code, brand, weight, size, color, price);
        this.gateHDMI = gateHDMI;
        this.ledKeyboard = ledKeyboard;
    }

    public int getGateHDMI() {
        return gateHDMI;
    }

    public void setGateHDMI(int gateHDMI) {
        this.gateHDMI = gateHDMI;
    }

    public String getLedKeyboard() {
        return ledKeyboard;
    }

    public void setLedKeyboard(String ledKeyboard) {
        this.ledKeyboard = ledKeyboard;
    }

    @Override
    public String toString() {
        return "Laptop{"+ super.toString() +
                ", gateHDMI=" + gateHDMI +
                ", ledKeyboard=" + ledKeyboard;
    }
}
