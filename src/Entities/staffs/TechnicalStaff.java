package Entities.staffs;

public class TechnicalStaff extends Staff {
    private final double BASIC_SALARY = 7000000;

    public TechnicalStaff() {
    }

    public TechnicalStaff(int id, String name, String dateOfBirth, String address, String gender) {
        super(id, name, dateOfBirth, address, gender);
    }

    @Override
    public String toString() {
        return "TechnicalStaff: " + super.toString();
    }

    @Override
    public double calculateSalary() {
        return BASIC_SALARY + getBonus() + getPenalty();
    }
}
