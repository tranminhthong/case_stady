package Entities.staffs;

public class Guard extends Staff {
    private final double BASIC_SALARY = 6000000;
    private double salaryCoefficient;

    public Guard() {
    }

    public Guard(int id, String name, String dateOfBirth, String address, String gender) {
        super(id, name, dateOfBirth, address, gender);
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public double calculateSalary() {
        return BASIC_SALARY * salaryCoefficient + getBonus() + getPenalty();
    }

    @Override
    public String toString() {
        return "Guard: " + super.toString() + ", SalaryCoefficient = " + getSalaryCoefficient();
    }
}
