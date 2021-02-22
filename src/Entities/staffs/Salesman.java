package Entities.staffs;

public class Salesman extends Staff {
    private final double BASIC_SALARY = 7500000;

    public Salesman(int id, String name, String dateOfBirth, String address, String gender) {
        super(id, name, dateOfBirth, address, gender);
    }

    public Salesman() {
    }

    @Override
    public String toString() {
        return "Salesman: " + super.toString();
    }

    @Override
    public double calculateSalary() {
        return BASIC_SALARY + getBonus() + getPenalty();
    }
}
