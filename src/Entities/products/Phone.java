package Entities.products;

public class Phone extends Product {
    private String typePhone;
    private String typeKeyboard;

    public Phone() {
    }

    public Phone(int id, String name, int code, String brand, double weight, double size, String color, long price, String typePhone, String typeKeyboard) {
        super(id, name, code, brand, weight, size, color, price);
        this.typePhone = typePhone;
        this.typeKeyboard = typeKeyboard;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    }

    public String getTypeKeyboard() {
        return typeKeyboard;
    }

    public void setTypeKeyboard(String typeKeyboard) {
        this.typeKeyboard = typeKeyboard;
    }

    @Override
    public String toString() {
        return "Phone{" + super.toString() +
                ", typePhone='" + typePhone + '\'' +
                ", typeKeyboard='" + typeKeyboard + '\'' +
                "} ";
    }
}
