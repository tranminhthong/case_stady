package Entities.staffs;

public class Manager extends Staff{
    private final double BASIC_SALARY = 9000000;

    public Manager() {
    }

    public Manager(int id, String name, String dateOfBirth, String address, String gender) {
        super(id, name, dateOfBirth, address, gender);
    }

    @Override
    public double calculateSalary() {
        return BASIC_SALARY + getBonus() + getPenalty();
    }

    @Override
    public String toString() {
        return "Manager: " + super.toString();
    }
}
