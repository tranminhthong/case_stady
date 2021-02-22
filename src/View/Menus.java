package View;

import Behaviors.LoginAndRegister;
import Behaviors.StaffManagement;
import Entities.LoginUser.User;
import Entities.products.Laptop;
import Entities.products.Phone;
import Entities.products.Product;
import Entities.staffs.*;

import java.util.Scanner;

public class Menus {
    static Scanner sc = new Scanner(System.in);

    public static Staff getInfoStaff(String str) throws Exception {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date of birth:");
        String date = sc.nextLine();
        StaffManagement.checkInputDateOfBirth(date);
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        switch (str) {
            case "Manager":
                return new Manager(id, name, date, address, gender);
            case "Salesman":
                return new Salesman(id, name, date, address, gender);
            case "Technical":
                return new TechnicalStaff(id, name, date, address, gender);
            case "Guard":
                System.out.println("1: Day shift or 2:Night shift?");
                int choice1 = Integer.parseInt(sc.nextLine());
                double salaryCoefficient = 0;
                if (choice1 == 1) {
                    salaryCoefficient = 1.0;
                } else if (choice1 == 2) {
                    salaryCoefficient = 1.5;
                }
                Guard guard = new Guard(id, name, date, address, gender);
                guard.setSalaryCoefficient(salaryCoefficient);
                return guard;
        }
        return null;
    }

    public static Product getInfoProduct(String str) throws Exception {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter code: ");
        int code = Integer.parseInt(sc.nextLine());
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter weight: ");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.print("Enter size: ");
        double size = Double.parseDouble(sc.nextLine());
        System.out.print("Enter color: ");
        String color = sc.nextLine();
        System.out.print("Enter price: ");
        long price = Long.parseLong(sc.nextLine());
        switch (str) {
            case "Phone":
                System.out.print("Enter type phone: ");
                String typePhone = sc.nextLine();
                System.out.print("Enter type keyboard: ");
                String typeKey = sc.nextLine();
                return new Phone(id, name, code, brand, weight, size, color, price, typePhone, typeKey);
            case "Laptop":
                System.out.print("Enter gateHDMI: ");
                int gate = Integer.parseInt(sc.nextLine());
                System.out.println("Keyboard has led : Yes/No");
                String ledKey = sc.nextLine();
                if (ledKey.equals("Yes") || ledKey.equals("No")) {
                    return new Laptop(id, name, code, brand, weight, size, color, price, gate, ledKey);
                }
                throw new Exception("Yes/No");
        }
        return null;
    }

    public static void login() throws Exception {
        System.out.println("------Login------");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        LoginAndRegister.login(username,pass);
    }

    public static void register() throws Exception {
        System.out.println("------Register------");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter password:" +
                "\nNote:- a digit must occur at least once, " +
                "\n- a lower case letter must occur at least once, " +
                "\n- an upper case letter must occur at least once, " +
                "\n- a special character must occur at least once [@#$%^&+=], " +
                "\n- no whitespace allowed in the entire string, " +
                "\n- anything, at least eight places though ");
        String pass = sc.nextLine();
        System.out.println(LoginAndRegister.checkPassword(pass));
        if (LoginAndRegister.checkPassword(pass)){
            User user = new User(username, pass);
        LoginAndRegister.register(user);}
        else {
            System.err.println("password not exactly!!!");
            register();
        }

    }
}
